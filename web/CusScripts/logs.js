$(document).ready(function(){
        var currentDate = new Date(new Date().getTime());
	$('.datepicker').pickadate({
            format: 'dd/mm/yyyy',
            formatSubmit: 'dd/mm/yyyy',
            max:currentDate        
        });
        $('#getlogs').click(function(){
            $('#mydiv').show();
            $.ajax({
                type: "POST",
                url: "Logs",
                data: $("#logform").serialize(),
                success: function(msg) {                  
                  
                  $("#logsdiv").html(msg);
                  $('#mydiv').hide();
                },
                async: false
            });
        });
});