$(document).ready(function(){
	$('.datepicker').pickadate();
	
	$("#createform").validate();
	$.extend($.validator.messages, {
		required: "<span class='alert'>This field is required.</span>",		    
		email: "<span class='alert'>Please enter a valid email address.</span>",		    
		date: "<span class='alert'>Please enter a valid date.</span>",
		dateISO: "<span class='alert'>Please enter a valid date (ISO).</span>",
		equalTo: "<span class='alert'>Please enter the same value again.</span>",
		accept: "Please enter a value with a valid extension.</span>",
		maxlength: $.validator.format("<span class='alert'>Please enter no more than {0} characters.</span>"),
		minlength: $.validator.format("<span class='alert'>Please enter at least {0} characters.</span>"),

	});
	
	$.validator.addMethod('notPlayDefault',function(value,event){
		if(value!="Default") return true;
		else return false;
	},"<span class='alert'>Select Maximum no of Players</span>");
	
	
});