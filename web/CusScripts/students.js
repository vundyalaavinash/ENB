/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){     
    $("#update").click(function(){
        $('#mydiv').show();
        $.ajax({
            type: "POST",
            url: "Groups",
            data: $("#StudentGroup").serialize(),
            success: function(msg) {                  
                $('#mydiv').hide();
                if(msg=="done!"){
                    alertify.success("Batch updated Succesfully!");
                }
                else{
                    alertify.error(msg);
                }
            },
            async: false
        });
    });    
});

