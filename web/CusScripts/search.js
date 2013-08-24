/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $("#search").click(function(){
        $('#mydiv').show();
        $.post('ValidateEmail',
        {
            keywords:$('#keyword').val()
        },
        function(data){
            $('#results').html();
            $('#mydiv').hide();
            },false);
        return false;
    });
});

