<%-- 
    Document   : Homepage
    Created on : Aug 8, 2013, 4:10:55 PM
    Author     : B.Revanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Dashboard</title>
		<link rel="stylesheet"  href="Styles/Main.css">		
		<link rel="stylesheet"  href="Styles/jquery.gridster.css">		
		
		<script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
		<script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>=		
		<script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
		
		<script src="CusScripts/dashboard.js" type="text/javascript"></script>
		
	</head>
	<body>
		<header>
			<span>Engineering Notebook</span>
			<h1>Dashboard</h1>
			<nav>
				<a href="Logout.jsp">Logout</a>
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
			<div class="gridster">
				<ul>
					<li data-row="1" data-col="1" data-sizex="2" data-sizey="1">
						<span>
							<center><h2>Fries & Wings SCM</h2>
							<p>21-07-2013 to 21-08-2013</p></center>
						</span>
					</li>
					<li data-row="1" data-col="2" data-sizex="2" data-sizey="1">
						<span>
							<center><h2>Customer Feedback System</h2>
							<p>21-07-2013 to 29-10-2013</p></center>
						</span>
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>
