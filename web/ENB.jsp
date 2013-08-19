<%-- 
    Document   : ENB
    Created on : Aug 8, 2013, 4:11:59 PM
    Author     : B.Revanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>ENB Tool</title>
		<link rel="stylesheet"  href="Styles/Main.css">		
		<link rel="stylesheet"  href="Styles/jquery-ui-1.10.3.custom.min.css">		
		
		<script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
		<script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>=		
		<script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
		<script src="Scripts/jquery-ui.js" type="text/javascript"></script>
		
		
		<script src="CusScripts/ENB.js" type="text/javascript"></script>
		
	</head>
	<body>
		<header>
			<span>Engineering Notebook</span>
			<h1>Tool</h1>
			<nav>
				<a href="Logout.jsp">Logout</a>
			</nav>
		</header>
		<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
			<h3>Raj</h3>
			<a href="HomePage.jsp">Home</a>
			<a href="create.jsp">Create ENB</a>
			<a href="manage.jsp">Manage ENB</a>
			<a href="view.jsp">View ENB</a>
			<a href="view.jsp">Logs</a>
			<a href="account.jsp">Account</a>
		</nav>
		
		<div id="main">
			<div id="tabs">
				<ul>  
				  <li><a href="#tab1">Notes</a></li> 
				  <li><a href="#tab2">Deliverable Status</a></li> 
				  <li><a href="#tab3">Lessons Learned Reflection</a></li>
				  <li><a href="#tab4">Plan for the Next Week</a></li>
				</ul> 
				<div id="tab1">
					<br>
					<p>Record key insights from readings and discussions.</p>
					<br>
					<textarea name="notes1" cols="87" rows="13"></textarea>
					<br><br>
					<input type="submit" class="button" value="Save">
				</div> 
				<div id="tab2">
					<table width="100%" border="0" cellspacing="10">
					  <tr>
						<td width="5%">SNO</td>
						<td width="16%"><center>Deliverable</center></td>
						<td width="27%"><center>What did you plan to accomplish?</center></td>
						<td width="27%"><center>What did you actually accomplish?</center></td>
						<td width="10%"><center>Size</center></td>
						<td width="10%"><center>Effort</center></td>
					  </tr>
					  <tr>
						<td>1.</td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
					  </tr>
					  <tr>
						<td>2.</td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
					  </tr>
					  <tr>
						<td>3.</td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
					  </tr>
					  <tr>
						<td>4.</td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
					  </tr>
					  <tr>
						<td>5.</td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
						<td><input type="text" name="deli"></td>
					  </tr>
					</table>
					<br/>
					<input type="submit" class="button" value="Save">
					<input type="submit" class="button" value="Add Row">
				</div>
				<div id="tab3">
					    <table width="800" height="209" border="0">
						  <tr>
							<td width="10%">S.NO.</td>
							<td width="25%"><center>Context</center></td>
							<td width="65%"><center>Lesson</center></td>
						  </tr>
						  <tr>
							<td>1.</td>
							<td><input type="text" name="deli1" ></td>
							<td><input type="text" name="deli2" ></td>
						  </tr>
						  <tr>
							<td>2.</td>
							<td><input type="text" name="deli2" ></td>
							<td><input type="text" name="deli1" ></td>
						  </tr>
						  <tr>
							<td>3.</td>
							<td><input type="text" name="deli1" ></td>
							<td><input type="text" name="deli2" ></td>
						  </tr>
						  <tr>
							<td>4.</td>
							<td><input type="text" name="deli1" ></td>
							<td><input type="text" name="deli2" ></td>
						  </tr>
						  <tr>
							<td>5.</td>
							<td><input type="text" name="deli1" ></td>
							<td><input type="text" name="deli2" ></td>
						  </tr>
						</table>
						<br/>
					<input type="submit" class="button" value="Save">
					<input type="submit" class="button" value="Add Row">
				</div>
				<div id="tab4">
					<br/>
					<p>These items should appear in the deliverable status for the next week.</p>
					<br/>
					<table width="800" height="209" border="0">
					  <tr>
							<td width="10%">S.NO.</td>
							<td width="25%"><center>Deliverable</center></td>
							<td width="65%"><center>What do you intend to accomplish and why</center></td>
						  </tr>
					  <tr>
						<td>1.</td>
						<td><input type="text" name="deli1" ></td>
						<td><input type="text" name="deli2" ></td>
					  </tr>
					  <tr>
						<td>2.</td>
						<td><input type="text" name="deli1" ></td>
						<td><input type="text" name="deli2" ></td>
					  </tr>
					  <tr>
						<td>3.</td>
						<td><input type="text" name="deli1" ></td>
						<td><input type="text" name="deli2" ></td>
					  </tr>
					  <tr>
						<td>4.</td>
						<td><input type="text" name="deli1" ></td>
						<td><input type="text" name="deli2" ></td>
					  </tr>
					  <tr>
						<td>5.</td>
						<td><input type="text" name="deli1" ></td>
						<td><input type="text" name="deli2" ></td>
					  </tr>
					</table>
					<br/>
					<input type="submit" class="button" value="Save">
					<input type="submit" class="button" value="Add Row">
				</div>
			</div>
		</div>
	</body>
</html>
