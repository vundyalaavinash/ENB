<%-- 
    Document   : logs
    Created on : Aug 8, 2013, 4:09:03 PM
    Author     : B.Revanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>View Logs</title>
		<link rel="stylesheet"  href="Styles/Main.css">		
		<link rel="stylesheet"  href="Styles/jquery.gridster.css">
		<link rel="stylesheet"  href="Styles/default.css">		
		<link rel="stylesheet"  href="Styles/default.date.css">			
		
		<script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
		<script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>=		
		<script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
		<script src="Scripts/picker.js" type="text/javascript"></script>
		<script src="Scripts/picker.date.js" type="text/javascript"></script>
		
		<script src="CusScripts/logs.js" type="text/javascript"></script>
		
	</head>
	<body>
		<header>
			<span>Engineering Notebook</span>
			<h1>Logs</h1>
			<nav>
				<a href="Home.html">Logout</a>
			</nav>
		</header>
		<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
			<h3>Raj</h3>
			<a href="Homepage.jsp">Home</a>
			<a href="create.jsp">Create ENB</a>
			<a href="manage.jsp">Manage ENB</a>
			<a href="view.jsp">View ENB</a>
			<a href="logs.jsp">Logs</a>
			<a href="account.jsp">Account</a>
		</nav>
		
		<div id="main">
			<div width="100%">
				<div class="floatl divf">
					Date:
					<br>
					<input name="to" type="text" size="20" class="datepicker" width="50%"  />
					<br><br>
					<input type="button" class="button floatr" value="Get Logs" />
				</div>
			</div>
			
			<div class="divfull margintoplogs">
				<table border="0" width="100%" cellspacing="10px" id="logs">
					<tr>
						<td><strong>Date & Time</strong></td>
						<td><strong>Description</strong></td>
					</tr>
					<tr>
						<td>20/07/2013 19:12 AM</td>
						<td>Login</td>
					</tr>
					<tr>
						<td>20/07/2013 19:32 AM</td>
						<td>Cerate ENB</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
