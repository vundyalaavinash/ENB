
var isSuccess=false;
var isSuccessP=false;
$(function (){
	
	$("input[type='submit'],input[type='reset'],.juia").button();

	$(document).ready(function(){
		$("#joinForm").validate();
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
		
		$("#bname").on('change',function(){
			$.post(
					"GetColors",
					{bnamee:$("#bname option:selected").text()},
					function(data){
						$("#diel").slideDown();
						if($('#die')){
							$('#die').remove();
						}
						$("#diel").append(data);
					});
		});
		
		$.validator.addMethod('passPhrase',function(value,event){	
			$.ajax({
				  type: 'POST',
				  url: 'CheckPassP',
				  data: {pass:value,bnamee:$("#bname option:selected").text()},
				  success: function(data){
					  if(data=="1"){
						  isSuccessP=true;
					  }else{
						  isSuccessP=false;
					  }
				  },
				  error:function(){
					  alert("error");
				  },
				  dataType: "text",
				  async:false
				});
			return isSuccessP;
		},"<span class='redd'>Incorrect Password</span>");
		
		$.validator.addMethod('passwordUnder',function(value,event){
			var exp1=/^[0-9_]/;
			var exp2=/^\w/;
			if(exp1.test(value)) return false;
			else if(!exp2.test(value))return false;
			else return true;
		},"<span class='redd'>Enter Valid PassPhrase</span>");
		
		$.validator.addMethod('notDieDefault',function(value,event){
			if(value!="Default") return true;
			else return false;
		},"<span class='redd'>Select a Die Color</span>");
		
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

	});

});