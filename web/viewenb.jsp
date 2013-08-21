<%-- 
    Document   : view
    Created on : Aug 8, 2013, 4:07:47 PM
    Author     : B.Revanth
--%>

<%@page import="com.enb.POJO.Plan"%>
<%@page import="com.enb.POJO.Lessons"%>
<%@page import="com.enb.POJO.Deliverablestatus"%>
<%@page import="com.enb.POJO.Notes"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.enb.POJO.Enbdesc"%>
<%@page import="com.enb.Helper.EnbdescHelper"%>
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
        <script src="CusScripts/view.js" type="text/javascript"></script>

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
            <div id="content">
                <table width="100%" border="0">
                    <tr>
                        <td width="80%">
                            ENB Name :<br>
                            <select name="selectenb" id="enbtitle">
                                <option value="Default">Select ENB</option>
                                <% out.print(ConstructString.getProjectsList(session.getAttribute("uid").toString()));%>
                            </select>
                        </td >
                        <td width="20%">
                            <!-- <input type="button" class="button floatr hide" id="delbtn" value="Delete ENB"/>-->
                        </td>
                    </tr>
                </table>
            </div>
            <div id="viewpan">
            </div>


            <div id="mydiv" class="hide">
                <img src="Styles/images/loader.gif">;
            </div>

        </div>
    </body>
</html>
