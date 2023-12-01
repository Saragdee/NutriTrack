// Initialize Datepicker using jQuery
$(document).ready(function() {
    $('#datepicker').datepicker({
        format: 'yyyy-mm-dd', // Define the date format
        autoclose: true // Close the picker after selection
    });
});