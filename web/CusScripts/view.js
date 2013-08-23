/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $('#enbtitle').change(function(){
        if($('#enbtitle option:selected').val()!="Default"){
            $('#mydiv').show();
            $.post(
                "View",
                {eid:$('#enbtitle option:selected').val()},
                function(data){
                    $("#tabs").html(data);                
                    $('#mydiv').hide();
                },
                "text"
            );
        }
    });
    
    $("#delbtn").click(function(){
        var htext=$('.invicible').html();
        $('#htmlcontent').val(htext);
        alert($('#htmlcontent').val());
        return true;
    });
});
