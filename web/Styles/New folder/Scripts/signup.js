var isSuccess = false;
$(function (){
	var hasError;
	$("input[type='submit'],input[type='reset'],.juia").button();
	$("#datepicker").datepicker();
	$( "#datepicker" ).datepicker( "option", "dateFormat", "dd/mm/yy" );
	$(document).ready(function(){
		$("#signupForm").validate();
		$.extend($.validator.messages, {
		    required: "<span class='redd'>This field is required.</span>",		    
		    email: "<span class='redd'>Please enter a valid email address.</span>",		    
		    date: "<span class='redd'>Please enter a valid date.</span>",
		    dateISO: "<span class='redd'>Please enter a valid date (ISO).</span>",
		    equalTo: "<span class='redd'>Please enter the same value again.</span>",
		    accept: "Please enter a value with a valid extension.</span>",
		    maxlength: $.validator.format("<span class='redd'>Please enter no more than {0} characters.</span>"),
		    minlength: $.validator.format("<span class='redd'>Please enter at least {0} characters.</span>"),

		});
		$.validator.addMethod('notGenderDefault',function(value,event){
			if(value!="Default") return true;
			else return false;
		},"<span class='redd'>Select a Gender</span>");
		
		$.validator.addMethod('uniqueUname',function(value,event){			
			$.post('CheckUname',
					{Email:value},
					function(data){
						if(data=="1"){
							isSuccess=true;
						}
						else{
							isSuccess=false;
						}
					});		
			return isSuccess;
		},"<span class='redd'>Email ID already registered</span>");
		
		$.validator.addMethod('matchpass',function(value,event){			
			if($("#pass").val()!=value) return false;
			else return true;
		},"<span class='redd'>Password not Matching</span>");
		
		$.validator.addMethod('matchemail',function(value,event){		
			var reemail=$("#email").val();
			if(reemail!=value) return false;
			else return true;
		},"<span class='redd'>Email ID not Matching</span>");
		
		$.validator.addMethod('minLength',function(value,event){
			if(value.length <5) return false;
			else return true;
		},"<span class='redd'>Minimum Length is five characters</span>");
		
		
		$.validator.addMethod('passwordUnder',function(value,event){
			var exp1=/^[0-9_]/;
			var exp2=/^\w/;
			if(exp1.test(value)) return false;
			else if(!exp2.test(value))return false;
			else return true;
		},"<span class='redd'>Enter Valid Password</span>");
		
		$.validator.addMethod("dateITA", function(value, element) {
			var check = false;
			var re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
			if( re.test(value)) {
				var adata = value.split('/');
				var gg = parseInt(adata[0],10);
				var mm = parseInt(adata[1],10);
				var aaaa = parseInt(adata[2],10);
				var xdata = new Date(aaaa,mm-1,gg);
				if ( ( xdata.getFullYear() === aaaa ) && ( xdata.getMonth() === mm - 1 ) && ( xdata.getDate() === gg ) ){
					check = true;
				} else {
					check = false;
				}
			} else {
				check = false;
			}
			return this.optional(element) || check;
		}, "Please enter a correct date");
		
		$("#nav1,#nav2,#nav3").on('mouseenter', function(){
			$(this).find('img').animate({'opacity':'0.3'},'fast');
			$(this).find('span').addClass({'display':'block'});
			$(this).find("span").show();
			
		});
		
		$("#nav1,#nav2,#nav3").on('mouseleave',function(){
			$(this).find('img').animate({'opacity':'1'},'fast');
			$(this).find('span').removeClass({'display':'block'});
			$(this).find("span").hide();
		});
		
		$('#login-trigger').click(function(){
			$(this).next('#login-content').slideToggle();
			$(this).toggleClass('active');					
			
			if ($(this).hasClass('active')) 
				$(this).find('span').html('&#x25B2;')
			else 
				$(this).find('span').html('&#x25BC;')
		});
		
		

	});

});