
$(function(){
	var isStarted=false;
	var isnotTurn=true;
	var notHinted=true;
	var notCalibrated=true;
	var notFullCalibarated=true;
	var donotUpdate=false;
	var totalcur=0;
	var curP=0;
	var prevP=0;
	var names=new Array();
	var id="";
	var color="";
	
	$("input[type='submit'],input[type='reset'],.juia").button();
	var ajax_call = function() {
		/* For Caliberation*/
		console.log(names);
		
		$.post('GetFullDetails',
				function(data){
					if(data!="none"){
						var as=data.split(" ");
						for(var i=0;i<as.length;i++){
							console.log(""+as);
							var k=as[i].split("-");
							if(k[0].length>0){
								names.push(k[0]);
								if($("#img"+k[1])){
									$("#img"+k[1]).remove();
								}
								$("#c"+k[2]).append("<img src='Styles/Pawns/"+k[1]+".png' width='20px' id='img"+k[1]+"'>");
							}
						}														
					}					
				});

		if(notCalibrated){
			$.post('GetDetails',
					function(data){
						if(data!="none"){
							var as=data.split(" ");
							id=as[0];
							color=as[1];
							curP=Number(as[2]);
							notCalibrated=false;
							if(curP!=0){
								notHinted=false;
							}
						}
						else{
							notCalibrated=true;
						};						
					});
		}
		/*tableRender*/
		if(!donotUpdate){
			$.post('GetGamerDetails',
					function(data){
					if($("#players")){
						$("#players").remove();
					}
						$("#dice").before(data);
						for(var i=0;i<names.length;i++){
							var sc=Number($("#"+names[i]).find(".score").text());
							console.log("#hide"+names[i]);
							co=$("#hide"+names[i]).val();
							console.log(""+co);
							if(sc==100){
								window.location.href ="won.jsp";
							}
							if($("#img"+co)){
								$("#img"+co).remove();
							}
							else
							{
								$("#c"+sc).append("<img src='Styles/Pawns/"+co+".png' width='20px' id='img"+co+"'>");
							}							
						}
				});
		}
		
		
		
		/* If Started*/
		  if(isStarted){
			  if(isnotTurn){
					$.post('Chance',
						function(data){
							if((data=="1")){
								$("#rollDice").show();
								isnotTurn=false;
							}
							else{								
								$("#rolldice").hide();
							}
						});
				}
			  $("#startgame").hide();
			  if(notHinted){
				  alert("Game Started!");
				  notHinted=false;
			  }
			  
		  }/*If not started*/
		  else{
			  $.post("CheckStarted",{},function(data){
				  if(data=="1"){
					  isStarted=true;	
					  if($("#startgame")){
						  $("#startgame").remove();
					  }					  
				  }
			  },"text");
		  }
		};
		

	var interval = 1000 * 3;
	
	
	$(document).ready(function(){
		$("#rollDice").hide();
		ajax_call();
		setInterval(ajax_call, interval);	
		$("#rollDice").on('click',function(){
			if(isStarted){	
				isnotTurn=false;
				var num=Math.round(Math.random()*5)+1;
				picRotate(num);
				prevP=curP;
				curP=curP+num;
				console.log("data : "+curP);
				console.log("num : "+num);
				if(curP>100){
					curP=prevP;
					$("#msg").text("Position off the board! Roll Again!");
				}
				else{
					ontUpdate=false;
					setPath(curP,prevP,num);
					console.log("after set: "+curP);
					if(num!=6){		
						console.log("IN :"+curP);
						$.post('PositionUpdate',
								{curr:curP},
								function(data){							
									$("#rollDice").hide();
									isnotTurn=true;
										if($("#players")){
											$("#players").remove();
										}
											$("#dice").before(data);
											if(curP==100){
												window.location.href ="won.jsp";
											}
								});
					}
					else{
						setPath(curP,prevP,num);
						donotUpdate=true;
						$("#id").find(".score").val(currP);
						$("#msg").text($("#msg").text()+"  Die Rolled to 6! Take another change!");
					}
				}
			}
			else{
				alert("Game not yet started!");
			}
			return false;
		});
		
		$("#startgame").on('click',function(){
			$.post("StartGame",{k:"1"},
			function(data){
				if(data=="1"){
					$("#msg").text("Game Started! Roll Dice Now.");
					isStarted=true;
					notHinted=false;
					$("#startgame").remove();
					$("#rollDice").show();
				}
				else{
					alert("You need minimum two players to start the game");
				}							
			});
			return false;
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
				$(this).find('span').html('&#x25B2;');
			else 
				$(this).find('span').html('&#x25BC;');
		});
		
	});
	
	var picRotate= function(num){
		$("#rollimg").attr("src","Styles/dice/dice"+num+".gif");
		$("#rollimg").effect("shake",'fast');
		$("#rollimg").effect("shake",'fast');
	};
	
	var setPath = function(num,prev,count){
		console.log($("#dice"+color));

		if(num==4){
			$("#msg").text("You climbed the ladder to position 14");
			curP=14;
		}
		else if(num==9){
			$("#msg").text("You climbed the ladder to position 31");
			curP=31;
		}
		else if(num==17){
			$("#msg").text("You are eaten by a snake! you are down to position 7");
			curP=7;
		} 
		else if(num==20){
			$("#msg").text("You climbed the ladder to position 38");
			curP=38;
		}
		else if(num==28){
			$("#msg").text("You climbed the ladder to position 84");
			curP=84;
		}
		else if(num==40){
			$("#msg").text("You climbed the ladder to position 59");
			curP=59;
		}
		else if(num==51){
			$("#msg").text("You climbed the ladder to position 67");
			curP=67;
		}
		else if(num==63){
			$("#msg").text("You climbed the ladder to position 81");
			curP=81;
		} 
		else if(num==64){
			$("#msg").text("You are eaten by a snake! you are down to position 60");
			curP=60;
		}
		else if(num==89){
			$("#msg").text("You are eaten by a snake! you are down to position 26");
			curP=26;
		}
		else if(num==95){
			$("#msg").text("You are eaten by a snake! you are down to position 73");
			curP=73;
		}
		else if(num==99){
			$("#msg").text("You are eaten by a snake! you are down to position 78");
			curP=78;
		}
		else{
			$("#msg").text("You Moved to position "+num);
		}
		
		if($("#img"+color)){
			$("#img"+color).remove();
		}
		$("#c"+curP).append("<img src='Styles/Pawns/"+color+".png' width='20px' id='img"+color+"'>");
	};
});