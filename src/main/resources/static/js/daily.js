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
  console.error(error);
}

// Rest of your code for DateTimePicker
// Initialize DateTimePicker
$(document).ready(function() {
    $('#datetimepicker').datetimepicker({
        format: 'YYYY-MM-DD HH:mm', // Define the format for date and time
        icons: {
            time: 'bi bi-clock', // Customize icon for time
            date: 'bi bi-calendar', // Customize icon for date
            up: 'bi bi-arrow-up', // Customize icon for up arrow
            down: 'bi bi-arrow-down', // Customize icon for down arrow
            previous: 'bi bi-arrow-left', // Customize icon for previous month
            next: 'bi bi-arrow-right', // Customize icon for next month
            today: 'bi bi-pin', // Customize icon for today button
            clear: 'bi bi-trash', // Customize icon for clear button
            close: 'bi bi-x' // Customize icon for close button
        }
    });

    // Open DateTimePicker on button click
    $('#openDateTimePicker').on('click', function() {
        $('#datetimepicker').datetimepicker('show');
    });
});

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
