/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    var lncount=1;
    var plancount=1;
    var dscount=1;
    $('textarea').autosize();       
    function disableF5(e) {
        if ((e.which || e.keyCode) == 116) e.preventDefault();
    }
    $(document).bind("keydown", disableF5);
    $(document).on("keydown", disableF5);


    $( "#tabs" ).tabs();	
    $("#atab1").click(function(){
        $("#atab1").addClass("present");
        $("#atab2").removeClass("present");
        $("#atab3").removeClass("present");
        $("#atab4").removeClass("present");
    });
    $("#atab2").click(function(){
        $("#atab2").addClass("present");
        $("#atab1").removeClass("present");
        $("#atab3").removeClass("present");
        $("#atab4").removeClass("present");
    });
    $("#atab3").click(function(){
        $("#atab3").addClass("present");
        $("#atab2").removeClass("present");
        $("#atab1").removeClass("present");
        $("#atab4").removeClass("present");
    });
    $("#atab4").click(function(){
        $("#atab4").addClass("present");
        $("#atab2").removeClass("present");
        $("#atab3").removeClass("present");
        $("#atab1").removeClass("present");
    });
	
    $("#lnar").click(function(){
        lncount+=1;
		$("#lntable").append("<tr><td>"+lncount+".</td><td><center><textarea onkeyup='textAreaAdjust(this)' name='lnc"+lncount+"' ></textarea></center></td><td><center><textarea onkeyup='textAreaAdjust(this)' name='lnl"+lncount+"' ></textarea></center></td></tr>");
    });
	
    $("#planr").click(function(){
        plancount+=1;
		$("#plantable").append("<tr><td>"+plancount+".</td><td><center><textarea onkeyup='textAreaAdjust(this)' name='pld"+plancount+"' ></textarea></center></td><td><center><textarea onkeyup='textAreaAdjust(this)' name='plw"+plancount+"' ></textarea></center></td></tr>");
    });
	
    $("#dsr").click(function(){
        dscount+=1;
		$("#dstable").append("<tr><td>"+dscount+".</td><td><center><textarea onkeyup='textAreaAdjust(this)' name='dsd"+dscount+"'></textarea></center></td><td><center><textarea onkeyup='textAreaAdjust(this)' name='dsp"+dscount+"'></textarea></center></td><td><center><textarea onkeyup='textAreaAdjust(this)' name='dsa"+dscount+"'></textarea></center></td><td><center><textarea onkeyup='textAreaAdjust(this)' name='dss"+dscount+"'></textarea></center></td><td><center><textarea onkeyup='textAreaAdjust(this)' name='dse"+dscount+"'></textarea></center></td><td></textarea></center></td></tr>");
    });	
        
    $("#savebtn").click(function(){
        $('#mydiv').show();
        var notes=$("#edValue").html();
        $("#notes1").val(notes);            
        var currentdate = new Date(); 
        var datesetted = currentdate.getDate() + "/"
        +(currentdate.getMonth()+1)  + "/" 
        + currentdate.getFullYear() + " @ "  
        + currentdate.getHours() + ":"  
        + currentdate.getMinutes() + ":" 
        + currentdate.getSeconds();
        var datetime = "Last Saved: " + currentdate.getDate() + "/"
        + (currentdate.getMonth()+1)  + "/" 
        + currentdate.getFullYear() + " @ "  
        + currentdate.getHours() + ":"  
        + currentdate.getMinutes() + ":" 
        + currentdate.getSeconds();
           
        $.ajax({
            type: "POST",
            url: "enb",
            data: $("#enbform").serialize(),
            success: function(msg) {                  
                $('#mydiv').hide();
                alertify.success("ENB saved Succesfully!");
                $(".status").html(datetime);
                $("#edValue").append("<p>"+datesetted+"</p>");
            },
            async: false
        }); 
        return false;
    });
        
    $(document).keydown(function(e) {
        var doPrevent;
        if (e.keyCode == 8 || e.keyCode == 46) {
            var d = e.srcElement || e.target;
            if (d.tagName.toUpperCase() == 'INPUT' || d.tagName.toUpperCase() == 'TEXTAREA') {
                doPrevent = d.readOnly || d.disabled;
            }
            else
                doPrevent = true;
        }
        else
            doPrevent = false;

        if (doPrevent)
            e.preventDefault();
    });
        
    $( "#dialog" ).dialog({
        autoOpen: false,
        show: {
            effect: "blind",
            duration: 1000
        },
        hide: {
            effect: "explode",
            duration: 1000
        }
    });
 
    $( "#opener" ).click(function() {
        $( "#dialog" ).dialog( "open" );
    });

    $("#button").click(function() {
        alert($("#reference").html());
        $( "#dialog" ).dialog( "close" );

    });

});
