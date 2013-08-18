$(document).ready(function(){
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
});