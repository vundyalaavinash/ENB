/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $('#enbtitle').change(function(){
        
            
        $('#mydiv').show();
        alert(this.text());
        $.post(
            "View",
            {eid:this.val()},
            function(data){
                $("#viewpan").html(data);
                
            },
            "text"
        );
        $('#mydiv').hide();
    });
});
