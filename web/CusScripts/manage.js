$(document).ready(function(){
	$("#enbtitle").change(function(){
		if($("#enbtitle option:selected").val()==="Default"){
			$("#tabs").fadeOut(600);
			$("#delbtn").fadeOut(600);			
		}
		else{
			$("#tabs").fadeIn(600);
			$("#delbtn").fadeIn(600);
		}
	});
});