

$(document).ready(function() {
    var allergies = ['Peanuts', 'Gluten', 'Lactose', 'Pollen']; // Replace with your allergy data
    var supplements = ['Vitamin C', 'Fish Oil', 'Probiotics', 'Calcium']; // Replace with your supplement data

    $('#allergiesInput').typeahead({
        source: allergies,
        minLength: 1,
        items: 'all'
    });

    $('#supplementsInput').typeahead({
        source: supplements,
        minLength: 1,
        items: 'all'
    });
});

(function () {
'use strict'
const forms = document.querySelectorAll('.requires-validation')
Array.from(forms)
  .forEach(function (form) {
    form.addEventListener('submit', function (event) {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()
$(document).ready(function() {
            const apiKey = 'ed72f3bc92e90d79ab43d3fba25fbe2a'; // Replace with your actual API key

            // Function to fetch city suggestions based on user input
            function fetchCitySuggestions(query) {
                const suggestionUrl = `https://api.openweathermap.org/data/2.5/find?q=${query}&type=like&sort=population&cnt=10&appid=ed72f3bc92e90d79ab43d3fba25fbe2a`;

                $.ajax({
                    url: suggestionUrl,
                    method: 'GET',
                    success: function (data) {
                        displayCitySuggestions(data.list);
                    },
                    error: function (error) {
                        console.error('Error fetching city suggestions:', error);
                    }
                });
            }

            // Function to display city suggestions in the dropdown
            function displayCitySuggestions(suggestions) {
                const dropdown = $('#citySuggestions');
                dropdown.empty();

                suggestions.forEach(city => {
                    const suggestionItem = `<a class="dropdown-item" href="#" data-id="${city.id}">${city.name}, ${city.sys.country}</a>`;
                    dropdown.append(suggestionItem);
                });

                // Show the dropdown
                dropdown.show();
            }

            // Handle city input changes
            $('#cityInput').on('input', function() {
                const query = $(this).val();

                if (query.length > 2) {
                    fetchCitySuggestions(query);
                } else {
                    $('#citySuggestions').hide();
                }
            });

            // Handle city suggestion click
            $('#citySuggestions').on('click', '.dropdown-item', function() {
                const cityId = $(this).data('id');
                const cityName = $(this).text();

                // Set the selected city in the input field
                $('#cityInput').val(cityName);

                // Hide the suggestions dropdown
                $('#citySuggestions').hide();
            });

            // Handle get weather button click
            $('#getWeatherBtn').on('click', function() {
                const city = $('#cityInput').val();
                fetchWeather(city);
            });

            // Function to fetch weather data for a specific city
            function fetchWeather(city) {
                const weatherUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=ed72f3bc92e90d79ab43d3fba25fbe2a`;

                $.ajax({
                    url: weatherUrl,
                    method: 'GET',
                    success: function (data) {
                        displayWeather(data);
                    },
                    error: function (error) {
                        console.error('Error fetching weather data:', error);
                        alert('Error fetching weather data. Please try again.');
                    }
                });
            }

            // Function to display weather results on the page
            function displayWeather(data) {
                const weatherResults = $('#weatherResults');
                weatherResults.empty();

                const weatherHtml = `
                    <h3>${data.name}, ${data.sys.country}</h3>
                    <p>Temperature: ${data.main.temp} &deg;C</p>
                    <p>Weather: ${data.weather[0].description}</p>
                    <p>Humidity: ${data.main.humidity}%</p>
                    <p>Wind Speed: ${data.wind.speed} m/s</p>
                `;

                weatherResults.html(weatherHtml);
            }
        });