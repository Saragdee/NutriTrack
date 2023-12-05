  $(document).ready(function() {
            $('#datepicker').datepicker({
                format: 'yyyy-mm-dd', // Define the date format
                autoclose: true // Close the picker after selection
            });

        $(document).ready(function() {
            // Initialize Autocomplete
            $('#cityInput').autocomplete({
                source: function (request, response) {
                    const apiKey = 'ahhIVmBfBY6PQ3fNGmHjvSQlWZLnY6aUUBBByGlW';
                    const autocompleteUrl = `https://api.nal.usda.gov/fdc/v1/foods/search?query=${request.term}&api_key=${apiKey}`;

                    $.ajax({
                        url: autocompleteUrl,
                        method: 'GET',
                        success: function (data) {
                            if (data.foods) {
                                const foodNames = data.foods.map(food => food.description);
                                response(foodNames);
                            } else {
                                response([]); // No results
                            }
                        },
                        error: function (error) {
                            console.error('Error fetching food data:', error);
                            response([]); // Return an empty array on error
                        }
                    });
                },
                minLength: 1, // Minimum characters before triggering autocomplete
                delay: 300 // Delay in milliseconds before sending the request
            });

            // Handle button click
            $('#searchButton').on('click', function() {
                searchFood();
            });
        });

        function searchFood() {
            const apiKey = 'ahhIVmBfBY6PQ3fNGmHjvSQlWZLnY6aUUBBByGlW';
            const foodInput = $('#cityInput').val();

            if (!foodInput) {
                alert('Please enter a food');
                return;
            }

            const apiEndpoint = `https://api.nal.usda.gov/fdc/v1/foods/search?query=${foodInput}&api_key=ahhIVmBfBY6PQ3fNGmHjvSQlWZLnY6aUUBBByGlW`;

            $.ajax({
                url: apiEndpoint,
                method: 'GET',
                success: function (data) {
                    displayResults(data);
                },
                error: function (error) {
                    console.error('Error fetching food data:', error);
                    alert('Error fetching food data. Please try again.');
                }
            });
        }

        function displayResults(data) {
            const resultsContainer = $('#foodResults');
            resultsContainer.empty();

            if (data.foods && data.foods.length > 0) {
                const food = data.foods[0];
                const nutrients = food.foodNutrients;

                const resultHtml = `
                    <h3>${food.description}</h3>
                    <ul>
                        ${nutrients.map(nutrient => `<li>${nutrient.nutrientName}: ${nutrient.value} ${nutrient.unitName}</li>`).join('')}
                    </ul>
                `;

                resultsContainer.html(resultHtml);
            } else {
                resultsContainer.html('<p>No results found</p>');
            }
        }
   });
