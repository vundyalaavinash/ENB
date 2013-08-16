$(function (){
	$("input[type='submit'],input[type='reset'],.juia").button();
	
	
	$(document).ready(function(){
		$("#nav1,#nav2,#nav3,#nav4").on('mouseenter', function(){
			$(this).find('img').animate({'top':'-10px'},600);
		});
		$("#nav1,#nav2,#nav3,#nav4").on('mouseleave',function(){
			$(this).find('img').animate({'top':'0px'},600);
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

