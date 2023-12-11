$(document).ready(function() {
  let nutrientChart;

  // Form submission handling
  $('#reportForm').on('submit', function(event) {
    event.preventDefault();

    // Your existing AJAX request
    $.ajax({
      type: 'POST',
      url: '/reports',  // Replace with your actual endpoint
      data: {
        selectedDate: $('#datePicker').val(),
        reportDuration: $('input[name=reportDuration]:checked').val()
      },
      success: function(response) {
        console.log("success!", response);
        createOrUpdateChart(response.nutrientInfo);
      },
      error: function(error) {
        // Handle errors as needed
        console.log('Error generating report:', error);
      }
    });
  });

  // Function to create or update the chart
  function createOrUpdateChart(data) {
    // Assuming 'data' is the response containing NutrientInfo
    console.log("data", data);

    // Destroy existing chart if it exists
    if (nutrientChart) {
      nutrientChart.destroy();
    }

    // Create your chart here using Chart.js
    let ctx = document.getElementById('nutrientChart').getContext('2d');
    nutrientChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: Object.keys(data),
        datasets: [{
          label: 'Nutrient Values',
          data: Object.values(data),
          backgroundColor: 'rgba(75, 192, 192, 0.2)',
          borderColor: 'rgba(75, 192, 192, 1)',
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
            title: {
              display: true,
              text: 'Percentage of Recommended Dosage'
            }
          }
        }
      }
    });

    // Show the chart container
    $('#nutrientChart').show();
  }

});
