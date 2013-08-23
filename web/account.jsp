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
        <link rel="stylesheet"  href="Styles/default.css">		
        <link rel="stylesheet"  href="Styles/default.date.css">		
        <link rel="stylesheet"  href="Styles/square/blue.css">	
        <link href="Styles/alertify.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.core.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.default.css" rel="stylesheet" type="text/css" />

        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>=		
        <script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.min.js" type="text/javascript"></script>
        <script src="Scripts/alertify.min.js" type="text/javascript"></script>

        <script src="CusScripts/account.js" type="text/javascript"></script>

    </head>
    <body>
        <header>
            <span>Engineering Notebook</span>
            <h1>Account</h1>
            <nav>
                <a href="Logout.jsp">Logout</a>
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
        <div id="main">
             <div id="mydiv" class="hide">
                <div  class="ajax-loader">
                    <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Loading</h3>
                    <img src="Styles/images/loader.gif" />
                </div>
            </div> 
            <form id="changepassword" method="post" action="ChangePassword">
                <table width="50%">
                    <tr>
                        <td>
                            E-Mail ID:
                            <br>
                            <input type="text" value="<%out.println((String) session.getAttribute("email"));%>" name="email">
                        </td>
                    </tr>
                    <tr>
                        <td><br><br><br><br>
                            Current Password:
                            <br>
                            <input type="password" value="" name="cpass" id="cpass" class="required">
                        </td>
                    </tr>
                    <tr>
                        <td><br>
                            New Password:
                            <br>
                            <input type="password" value="" name="npass" id="npass" class="required">
                        </td>
                    </tr>
                    <tr>
                        <td><br>
                            Re-Type Password:
                            <br>
                            <input type="password" value="" name="renpass" id="renpass" class="required passsame">
                        </td>
                    </tr>
                    <tr>
                        <td><br><br>
                            <input type="submit" value="Change Password" class="button" id="changebtn" >
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
