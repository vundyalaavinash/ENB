<%-- 
    Document   : Homepage
    Created on : Aug 8, 2013, 4:10:55 PM
    Author     : B.Revanth
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.enb.POJO.Userauth"%>
<%@page import="com.enb.Helper.RegistrationHelper"%>
<%@page import="com.enb.Helper.UserLogHelper"%>
<%@page import="com.enb.POJO.Plan"%>
<%@page import="com.enb.POJO.Lessons"%>
<%@page import="com.enb.POJO.Deliverablestatus"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.enb.POJO.Notes"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.enb.POJO.Enbdesc"%>
<%@page import="com.enb.Helper.EnbdescHelper"%>
<%@page import="com.enb.MiscClasses.ConstructString"%>
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
                <script src="CusScripts/manage.js" type="text/javascript"></script>
                <script src="CusScripts/view.js" type="text/javascript"></script>
		
	</head>
	<body>
		<header>
			<span>Engineering Notebook</span>
			<h1>View ENB</h1>
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
			<a href="adminhome.jsp">View Students</a>
                        <a href="viewall.jsp">View All ENB</a>
			<a href="adminaccount.jsp">Account</a>
		</nav>
		<div id="main">
            <div id="content">
                <form action='DownloadPDF' method="post" target="_blank">
                    <table width="100%" border="0">
                        <tr>
                            <%
                            ConstructString cs=new ConstructString();
                            ArrayList<Userauth> names=cs.getStudentDetails(Integer.parseInt(session.getAttribute("uid").toString()));
                            
                            %>
                            <td width="20%">
                                <input type="submit" class="button floatr hide" id="delbtn" value="Download ENB"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div id="mydiv" class="hide">
                <div  class="ajax-loader">
                    <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Loading</h3>
                    <img src="Styles/images/loader.gif" />
                </div>
            </div>
            <div id='tabs' class='invicible'>
            </div>
        </div>

	</body>
</html>
