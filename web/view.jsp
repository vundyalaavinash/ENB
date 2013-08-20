<%-- 
    Document   : view
    Created on : Aug 8, 2013, 4:07:47 PM
    Author     : B.Revanth
--%>

<%@page import="com.enb.MiscClasses.ConstructString"%>
<html>
	<head>
		<title>View ENB</title>
		<link rel="stylesheet"  href="Styles/Main.css">		
		<link rel="stylesheet"  href="Styles/jquery-ui-1.10.3.custom.min.css">		
		
		<script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
		<script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>		
		<script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
		<script src="Scripts/jquery-ui.js" type="text/javascript"></script>
		
		<script src="CusScripts/manage.js" type="text/javascript"></script>
		<script src="CusScripts/ENB.js" type="text/javascript"></script>
		
	</head>
	<body>
		<header>
			<span>Engineering Notebook</span>
			<h1>View ENB</h1>
			<nav>
				<a href="logout.jsp">Logout</a>
			</nav>
		</header>
		<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
			<h3>
                            <%
                                if(session.getAttribute("name")==null){
                                    response.sendRedirect("index.jsp");
                                }
                                else{
                                    out.println(session.getAttribute("name"));
                                }

                             %>
                            
                            
                        </h3>
			<a href="Homepage.jsp">Home</a>
			<a href="create.jsp">Create ENB</a>
			<a href="manage.jsp">Manage ENB</a>
			<a href="view.jsp">View ENB</a>
			<a href="logs.jsp">Logs</a>
			<a href="account.jsp">Account</a>
		</nav>
		
		<div id="main">
			<div id="content">
				<table width="100%" border="0">
					<tr>
						<td width="80%">
							ENB Name :<br>
							<select name="selectenb" id="enbtitle">
								<option value="Default">Select ENB</option>
								<% out.print(ConstructString.getProjectsList(session.getAttribute("uid").toString())); %>
							</select>
						</td >
						<td width="20%">
							<input type="submit" class="button floatr hide" id="delbtn" value="Delete ENB"/>
						</td>
					</tr>
				</table>
			</div>
		
			<div id="tabs" class="hide lessfont invicible">
				<h2>Notes</h2>
				<p></p>
				<br>
				<hr>
				<br>
				<h2>Deliverable Status</h2>
					<table width="100%" border="0" cellspacing="10">
					  <tr>
						<td width="5%">SNO</td>
						<td width="16%">Deliverable</td>
						<td width="27%">What did you plan to accomplish?</td>
						<td width="27%">What did you actually accomplish?</td>
						<td width="10%">Size</td>
						<td width="10%">Effort</td>
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
				<br>
				<hr>
				<br>
				<h2>Lessons Learned Reflection</h2>
						<table width="100%" border="0"  cellspacing="10">
						  <tr>
							<td width="10%">S.NO.</td>
							<td width="25%">Context</td>
							<td width="65%">Lesson</td>
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
				<br>
				<hr>
				<br>
				<h2>Plan for the Next Week</h2>
					<table width="100%" border="0"  cellspacing="10">
					  <tr>
							<td width="10%">S.NO.</td>
							<td width="25%">Deliverable</td>
							<td width="65%">What do you intend to accomplish and why</td>
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
				
			</div>
		</div>
	</body>
</html>
