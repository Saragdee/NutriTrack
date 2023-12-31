
// Replace this with your actual api/database data --------->>>> anastasia to do

$(document).ready(function() {

        $('#allergiesInput').on('click', function() {
            $('#allergiesDropdown').toggle();
        });

        $('#allergiesDropdown input[type="checkbox"]').change(function() {
            var selectedOptions = $('#allergiesDropdown input[type="checkbox"]:checked').map(function() {
                return $(this).val();
            }).get();
            $('#displayAllergies').val(selectedOptions.join(', '));
        });
        $('#supplementsInput').on('click', function() {
            $('#supplementsDropdown').toggle();
        });

        $('#supplementsDropdown input[type="checkbox"]').change(function() {
            var selectedOptions = $('#supplementsDropdown input[type="checkbox"]:checked').map(function() {
                return $(this).val();
            }).get();
            $('#displaySupplements').val(selectedOptions.join(', '));
        });


        // Handle clicks outside the dropdown to close it
        $(document).on('click', function(event) {
            if (!$(event.target).closest('.dropdown').length) {
                $('.dropdown-menu').hide();
            }
        });


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