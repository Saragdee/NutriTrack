
// Replace this with your actual api/database data --------->>>> anastasia to do
const settings = {
	async: true,
	crossDomain: true,
	url: 'https://weatherapi-com.p.rapidapi.com/current.json?q=53.1%2C-0.13',
	method: 'GET',
	headers: {
		'X-RapidAPI-Key': '51f047c0c1msh6c7ac033ccf3686p13d27ejsnc2ecd06142c2',
		'X-RapidAPI-Host': 'weatherapi-com.p.rapidapi.com'
	}
};

$.ajax(settings).done(function (response) {
	console.log(response);
});

$(document).ready(function() {
    var cities = ['New York', 'Los Angeles', 'London', 'Paris', 'Tokyo']; // Replace with your city data
    var allergies = ['Peanuts', 'Gluten', 'Lactose', 'Pollen']; // Replace with your allergy data
    var supplements = ['Vitamin C', 'Fish Oil', 'Probiotics', 'Calcium']; // Replace with your supplement data

    $('#cityInput').typeahead({
        source: cities,
        minLength: 1,
        items: 'all' // Show all items in the dropdown
    });

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