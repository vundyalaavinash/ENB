<%-- 
    Document   : account
    Created on : Aug 8, 2013, 4:10:10 PM
    Author     : B.Revanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Account</title>
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
            <h1>Account</h1>
            <nav>
                <a href="logout.jsp">Logout</a>
            </nav>
        </header>
        <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
            <h3>
                <%
                    if (session.getAttribute("name") == null) {
                        response.sendRedirect("index.jsp");
                    } else {
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
        <form id="changepassword" method="post" action="ChangePassword">
            <div id="main">
                <div id="mydiv">
                    <div  class="ajax-loader">
                        <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Loading</h3>
                        <img src="Styles/images/loader.gif" />
                    </div>
               </div>
            </div>
        </form>
    </body>
</html>
