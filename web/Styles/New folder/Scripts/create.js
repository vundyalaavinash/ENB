
var isSuccess=false;
$(function (){
	
	$("input[type='submit'],input[type='reset'],.juia").button();
	
	$(document).ready(function(){
		$("#createForm").validate();
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
		
		$.validator.addMethod('uniqueBname',function(value,event){	
			$.ajax({
				  type: 'POST',
				  url: 'CheckBname',
				  data: {Bname:value},
				  success: function(data){
					  if(data=="1"){
						  isSuccess=true;
					  }else{
						  isSuccess=false;
					  }
				  },
				  error:function(){
					  alert("error");
				  },
				  dataType: "text",
				  async:false
				});
			/*$.post('CheckBname',
				{Bname:value},
				function(data){
					if(data=="1"){
						isSuccess=true;
					}
					else{
						isSuccess=false;
					}
				});	*/
			return isSuccess;
		},"<span class='redd'>Board Name already exists</span>");
		
		$.validator.addMethod('notPlayDefault',function(value,event){
			if(value!="Default") return true;
			else return false;
		},"<span class='redd'>Select Maximum no of Players</span>");
		
		$.validator.addMethod('notDieDefault',function(value,event){
			if(value!="Default") return true;
			else return false;
		},"<span class='redd'>Select a Die Color</span>");
		
		$.validator.addMethod('matchpass',function(value,event){
			if($("#pass").val()!=value) return false;
			else return true;
		},"<span class='redd'>Password not Matching</span>");
		
		$.validator.addMethod('passwordUnder',function(value,event){
			var exp1=/^[0-9_]/;
			var exp2=/^\w/;
			if(exp1.test(value)) return false;
			else if(!exp2.test(value))return false;
			else if(value.length < 5) return false;
			else return true;
		},"<span class='redd'>Enter Valid Password</span>");
		
		
		
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
				$(this).find('span').html('&#x25B2;');
			else 
				$(this).find('span').html('&#x25BC;');
		});
		
		/*Validations*/
		
		$("#createForm").validate();
		
		$.validator.addMethod('passwordUnder',function(value,event){
			var exp1=/^[0-9_]/;
			var exp2=/^\w/;
			if(exp1.test(value)) return false;
			else if(!exp2.test(value))return false;
			else return true;
		},"<span class='redd'>Enter Valid PassPhrase</span>");
		
		$.validator.addMethod('notPlayDefault',function(value,event){
			if(value!="Default") return true;
			else return false;
		},"<span class='redd'>Select Maximum Number of Players</span>");
		
		$.validator.addMethod('notDieDefault',function(value,event){
			if(value!="Default") return true;
			else return false;
		},"<span class='redd'>Select a Die Color</span>");
		
		
		
	});
	
	
});