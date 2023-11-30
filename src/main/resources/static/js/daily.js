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