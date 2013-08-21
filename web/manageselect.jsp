<%-- 
    Document   : manageselect
    Created on : Aug 21, 2013, 10:11:56 PM
    Author     : Avinash
--%>

<%@page import="com.enb.MiscClasses.ConstructString"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Manage ENB</title>
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
			<h1>Manage ENB</h1>
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
			<a href="manageselect.jsp">Manage ENB</a>
			<a href="viewselect.jsp">View ENB</a>
			<a href="logs.jsp">Logs</a>
			<a href="account.jsp">Account</a>
		</nav>
		
		<div id="main">
			<div class="gridster">
                            <% out.print(""+ConstructString.getProjectsManage(session.getAttribute("uid").toString())); %>
			</div>
		</div>
	</body>
</html>
