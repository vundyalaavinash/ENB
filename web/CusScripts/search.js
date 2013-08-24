/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    $("#search").click(function(){
        $('#mydiv').show();
        $.post('Search',
        {
            keywords:$('#keyword').val()
        },
        function(data){
            $('#results').html(data);
            $('#mydiv').hide();
            },false);
        return false;
    });
});

