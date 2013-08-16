$(function(){

	$("input[type='submit'],input[type='reset'],.juia").button();
	$(document).ready(function(){
		$("#sol1,#sol2").on("mouseenter",function(){
			$(this).find("img").effect("pulsate",500);
		});
		
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