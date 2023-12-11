$(document).ready(function() {
    const nutrientInfo = {
    301: { name: 'Calcium, Ca', unit: 'mg' },
    303: { name: 'Iron, Fe', unit: 'mg' },
    324: { name: 'Vitamin D', unit: 'IU' },
    304: { name: 'Magnesium, Mg', unit: 'mg' },
    291: { name: 'Dietary Fiber', unit: 'g' },
    306: { name: 'Potassium, K', unit: 'mg' },
    307: { name: 'Sodium, Na', unit: 'mg' },
    305: { name: 'Phosphorus, P', unit: 'mg' },
    315: { name: 'Manganese, Mn', unit: 'mg' },
    309: { name: 'Zinc, Zn', unit: 'mg' },
    401: { name: 'Vitamin C', unit: 'mg' },
    404: { name: 'Thiamin', unit: 'mg' },
    405: { name: 'Riboflavin', unit: 'mg' },
    406: { name: 'Niacin', unit: 'mg' },
    415: { name: 'Vitamin B-6', unit: 'mg' },
    410: { name: 'Pantothenic acid', unit: 'mg' },
    418: { name: 'Vitamin B-12', unit: 'µg' },
    430: { name: 'Vitamin K', unit: 'µg' },
    601: { name: 'Cholesterol', unit: 'mg' },
    318: { name: 'Vitamin A (as IU)', unit: 'IU' },
    320: { name: 'Vitamin A (as RAE)', unit: 'µg' },
    317: { name: 'Selenium', unit: 'µg' }
    };

    // Function to extract the date from the datepicker field
    function getDateFromPicker() {
        return $('#datepicker').val();
    }

    function getFoodConsumptionList() {
        let nutrientsHTML = $('#nutrientsList').html();
        console.log('nutrientsHTML:', nutrientsHTML);

        let nutrients = [];
        $(nutrientsHTML).find('li').each(function() {
            let nutrientInfo = $(this).text();
            console.log('nutrientInfo:', nutrientInfo);

            let parts = nutrientInfo.split(':');
            console.log('parts:', parts);

            if (parts.length === 2) {
                let attrId = parts[0].substring(0, 3);
                let nutrientValue = parts[1].split(' ')[1].trim();
                nutrients.push({ attrId: attrId, value: nutrientValue });
            }
        });

        console.log('nutrients:', nutrients);
        return nutrients;
    }

    $('#fetchNutrients').on('click', function() {
      event.preventDefault(); // Prevent form submission

      var foodQuery = $('#productName').val();
      var nutrientsHeading = $('#nutrientsHeading');
      // Extract nutrients data and store in an array

        $.ajax({
            url: 'https://trackapi.nutritionix.com/v2/natural/nutrients',
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'x-app-id': '436e97ea', // Replace with your actual app ID
                'x-app-key': 'ea8c78c24b35a3d98a576e0eb46e2046' // Replace with your actual app key
            },
            data: JSON.stringify({ query: foodQuery }),
            success: function(response) {
                displayNutrients(response.foods);
                nutrientsHeading.show(); // Show the heading after successful fetch

                // Assuming API response structure is an array of objects with attr_id, sup_name, and value
                var selectedFood = response.foods[0]; // Assuming only one food is selected

                // Set hidden fields in the form with API data
                $('#attrId').val(selectedFood.attr_id);
                $('#supName').val(selectedFood.sup_name);
                $('#supQuant').val(selectedFood.value);
            },
            error: function(error) {
              console.error('Error fetching nutrients:', error);
              $('#nutrientsList').html('<li>Error fetching nutrients. Please try again.</li>');
            }
        });
        console.log('food consumption list', nutrientsHeading);
    });

    $('#submit').on('click', function(event) {
        event.preventDefault(); // Prevent default form submission

        // Get the date from the datepicker field
        const dateFromPicker = getDateFromPicker();

        // Get the food consumption list
        let formData = getFoodConsumptionList();
        for (let food of formData) {
            food.date = dateFromPicker;
        }

        // Perform AJAX POST request to your Java endpoint
        $.ajax({
            type: 'POST',
            url: '/logfood', // Your Java endpoint URL
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                // Handle success response, if needed
                console.log('Submission successful:', response);
            },
            error: function(error) {
                // Handle error response, if needed
                console.error('Error submitting form:', error);
            }
        });

        // If needed, you can submit the form after AJAX request completion
        // $('#yourFormId').submit();
    });

    function displayNutrients(foods) {
        var nutrientsList = $('#nutrientsList');
        nutrientsList.empty();

        if (foods && foods.length > 0) {
            foods.forEach(function(food) {
            var filteredNutrients = food.full_nutrients.filter(function(nutrient) {
            return nutrientInfo.hasOwnProperty(nutrient.attr_id) && nutrient.value > 1;
            });

            var nutrients = '';
            filteredNutrients.forEach(function(nutrient) {
            var attrInfo = nutrientInfo[nutrient.attr_id];
            nutrients += `<li>${nutrient.attr_id} ${attrInfo.name}: ${nutrient.value} ${attrInfo.unit}</li>`;
            });

            if (nutrients !== '') {
              nutrientsList.append(`<li>${food.food_name}<ul>${nutrients}</ul></li>`);
            }
            });
        } else {
            nutrientsList.html('<li>No nutrient information available</li>');
        }
    }

    $('#datepicker').datepicker({
        format: 'dd/MM/yyyy', // Define the date format
        autoclose: true // Close the picker after selection
    });
});