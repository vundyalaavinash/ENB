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
            <a href="manage.jsp">Manage ENB</a>
            <a href="view.jsp">View ENB</a>
            <a href="logs.jsp">Logs</a>
            <a href="account.jsp">Account</a>
        </nav>

        <div id="main">
            <table width="50%">
                <tr>
                    <td>
                        E-Mail ID:
                        <br>
                        <input type="text" value="raj@gmail.com" name="email"/>
                    </td>
                </tr>
                <tr>
                    <td><br><br><br><br>
                        Current Password:
                        <br>
                        <input type="password" value="" name="cpass" class="required"/>
                    </td>
                </tr>
                <tr>
                    <td><br>
                        New Password:
                        <br>
                        <input type="password" value="" name="npass" class="required"/>
                    </td>
                </tr>
                <tr>
                    <td><br>
                        Re-Type Password:
                        <br>
                        <input type="password" value="" name="renpass" class="required"/>
                    </td>
                </tr>
                <tr>
                    <td><br><br>
                        <input type="submit" value="Change Password" class="button" />
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
