<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Create Game</title>
		
		<!--Styles -->
		<link rel="stylesheet" href="Styles/styles.css" type="text/css"></link>
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Amatic+SC&subset=latin"></link>
		<link rel="stylesheet" href="Styles/jquery.ui.theme.css" type="text/css" />
		<link rel="stylesheet" href="Styles/jquery-ui.css" type="text/css" />

		<!--Scripts-->
		<script src="Scripts/jquery-1.9.1.js" type="text/javascript"></script>
		<script src="Scripts/jquery-ui.js" type="text/javascript"></script>
		<script src="Scripts/jquery.validate.js" type="text/javascript"></script>
		<script src="Scripts/jquery.additional-methods.js" type="text/javascript"></script>
		<script src="Scripts/create.js" type="text/javascript"></script>
	</head>
	<body>
	<%
	%>
		<div id="top"></div>
		<div id="container">
			<div id="header">
				<div id="login">
					<nav>
						<ul>
							<% 
							if(session.getAttribute("Name")==null){
								response.sendRedirect("Login.jsp");
								out.println("<li id=\"login\">");
								out.println("<a id=\"login-trigger\" href=\"#\">Log in <span>&#x25BC;</span>");
								out.println("</a>");
								out.println("<div id=\"login-content\">");
								out.println("<form action=\"Login\" method=\"post\">");
								out.println("<fieldset id=\"inputs\">");
								out.println("<input id=\"username\" type=\"text\" name=\"Email\" placeholder=\"Your email address\" required>");   
								out.println("<input id=\"password\" type=\"password\" name=\"Password\" placeholder=\"Password\" required>");
								out.println("</fieldset>");
								out.println("<fieldset id=\"actions\">");
								out.println("<input type=\"submit\" id=\"submit\" value=\"Log in\">");
								out.println("<label><input type=\"checkbox\" checked=\"checked\"> Keep me signed in</label>");
								out.println("</fieldset>");
								out.println("</form>");
								out.println("</div>");                     
								out.println("</li>");
								out.println("<li id=\"signup\">");
								out.println("<a href=\"signup.jsp\">Sign up</a>");
								out.println("</li>");
							}
							else{
								out.println("</li>");
								out.println("<li id=\"signup\">");
								out.println("<a href=\"account.jsp\">"+session.getAttribute("Name")+"</a>");
								out.println("</li>");
								out.println("<li id=\"signup\">");
								out.println("<a href=\"Logout\">Sign out</a>");
								out.println("</li>");
							}
							%>
						</ul>
					</nav>
				</div>
				<div id="logo">
					<a href="index.jsp">
						<img  src="Styles/images/logo.png" alt="LittleBigPlanet"/>
					</a>
				</div>
				<div id="navigation">
					<ul>
						<li style="background-image: none;">
							<a href="how.jsp" id="nav1">
								<img style="opacity: 1;" src="Styles/images/nav-contact.png" alt="How to Play?" >
								<span style="display: none;">
									<h3>Instructions</h3>
								</span>
							</a>
						</li>
						<li>
							<a href="join.jsp" id="nav3">
								<img style="opacity: 1;" src="Styles/images/nav-gallery.png" alt="Join Game">
								<span style="display: none;">
									<h3>Join Game</h3>
								</span>
							</a>
						</li>
						<li>
							<a href="contact.jsp" id="nav3">
								<img style="opacity: 1;" src="Styles/images/nav-twitter.png" alt="contact us">
								<span style="display: none;">
									<h3>Contact US</h3>
								</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			
			<div id="main">
				 <div id="contact-intro">
					<h2>Create your Game and invite your friends to join!</h2>
				</div>
				<div id="contact-container">
					<div id="contact-form" class="clearfix">
						<form name="reg" method="post" action="Create" id="createForm"><!-- onSubmit="return createformValidation();">-->
							<fieldset>
							<% if(request.getAttribute("errorMsg")!=null){
								out.println(request.getAttribute("errorMsg"));
							} %>
								<label for="bname">Board Name: <span class="requireds">*</span></label>
								<input id="bname" name="bname" placeholder="Name your board" class="required minlength uniqueBname" type="text"/>
								
								<label for="pass">Passphrase: <span class="requireds">*</span></label>
								<input id="pass" name="pass" class="required passwordUnder" placeholder="Tell this phase to your friend" type="text"/>
								
								<label for="repass">Retype Passphrase: <span class="requireds">*</span></label>
								<input id="repass" name="repass" class="required matchpass" placeholder="Retype the passphrase" type="text"/>
																
								<label for="play">Maximum Player: <span class="requireds">*</span></label>
								<select id="play" name="play" required class="required notPlayDefault">
									<option value="Default">Select number of Players</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>								
								</select>
								<label for="die">Die Color: <span class="requireds">*</span></label>
								<select id="die" class="required notDieDefault" name="die" >
									<option value="Default">Select a die Color</option>
									<option value="CadetBlue" class="span-CadetBlue">CadetBlue</option>
									<option value="DarkTurquoise" class="span-DarkTurquoise">DarkTurquoise</option>
									<option value="White" class="span-White">White</option>
									<option value="Crimson"  class="span-Crimson">Crimson</option>
									<option value="LightSalmon"  class="span-LightSalmon">LightSalmon</option>
									<option value="LightSlateGrey"  class="span-LightSlateGrey">LightSlateGrey</option>
									<option value="DarkSeaGreen" class="span-DarkSeaGreen">DarkSeaGreen</option>
								</select>
								
															
								<input value="CREATE" id="submit-button" type="submit">
								<p id="req-field-desc"><span class="requireds">*</span> indicates a required field</p>
							</fieldset>
						</form>
					</div>
					<div id="contact-hero">
					</div>
				</div>
				<div id="footer">
					<h5>Copyright &#169; 2013 Avinash. All Rights Reserved.</h5>
				</div>
			</div>
		</div>
	</body>
</html>