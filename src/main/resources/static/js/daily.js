// Initialize Datepicker using jQuery
const url = 'https://t14ha70d-usda-v1.p.rapidapi.com/content/Topics?api_key=ahhIVmBfBY6PQ3fNGmHjvSQlWZLnY6aUUBBByGlW&id=1';
const options = {
  method: 'GET',
  headers: {
    'X-RapidAPI-Key': '51f047c0c1msh6c7ac033ccf3686p13d27ejsnc2ecd06142c2',
    'X-RapidAPI-Host': 't14ha70d-usda-v1.p.rapidapi.com'
  }
};

try {
  const response = await fetch(url, options);
  const result = await response.json();
  console.log(result);
} catch (error) {
  console.error(error)


// Example: How to use the USDA API with user input
const userInput = prompt('Enter the food you ate:');
const searchUrl = `https://t14ha70d-usda-v1.p.rapidapi.com/content/Topics?api_key=ahhIVmBfBY6PQ3fNGmHjvSQlWZLnY6aUUBBByGlW&q=${userInput}`;

try {
  const searchResponse = await fetch(searchUrl, options);
  const searchResult = await searchResponse.json();
  console.log(searchResult);
} catch (error) {
  console.error(error);
}

$(document).ready(function() {
    $('#datepicker').datepicker({
        format: 'yyyy-mm-dd', // Define the date format
        autoclose: true // Close the picker after selection
    });
});

$('#foodInput').autocomplete({
        source: function (request, response) {
            const autocompleteUrl = `https://t14ha70d-usda-v1.p.rapidapi.com/content/Topics?api_key=ahhIVmBfBY6PQ3fNGmHjvSQlWZLnY6aUUBBByGlW&q=${request.term}`;

            // Fetch data from USDA API based on user input
            fetch(autocompleteUrl, options)
                .then(response => response.json())
                .then(data => {
                    // Extract relevant data for autocomplete suggestions
                    const suggestions = data.map(item => item.name);
                    response(suggestions);
                })
                .catch(error => {
                    console.error(error);
                    response([]); // Return an empty array on error
                });
        },
        minLength: 1, // Minimum characters before triggering autocomplete
        delay: 300 // Delay in milliseconds before sending the request
    });
