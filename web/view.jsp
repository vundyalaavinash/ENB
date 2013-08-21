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
                            <input type="submit" class="button floatr hide" id="delbtn" value="Delete ENB"/>
                        </td>
                    </tr>
                </table>
            </div>

            <div id="tabs" class="hide lessfont invicible">
                <h2>Notes</h2>
                <%
                    String enbname = null;
                    EnbdescHelper eh1 = new EnbdescHelper();
                    Enbdesc enb = eh1.getEnbid(enbname);
                    //int enbid=enb.getId();
                    Set set = enb.getNoteses();
                    Iterator itr = set.iterator();

                    while (itr.hasNext()) {
                        Notes notes = (Notes) itr.next();
                        out.println("<textarea>" + notes.getNotes().toString() + "</textarea>");
                        //System.out.println(itr.next());
                    }

                %>
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
                    <%
                        Set set1 = enb.getDeliverablestatuses();
                        itr = set1.iterator();
                        int i = 1;
                        while (itr.hasNext()) {

                            Deliverablestatus del = (Deliverablestatus) itr.next();
                            out.println("<tr>");
                            out.println("<td><input type='text' value='" + i + "' readonly></td>");
                            out.println("<td><input type='text' value='" + del.getDeliverables() + "' readonly></td>");
                            out.println("<td><input type='text' value='" + del.getPlanToAccomplish() + "' readonly></td>");
                            out.println("<td><input type='text' value='" + del.getActualAccomplished() + "' readonly></td>");
                            out.println("<td><input type='text' value='" + del.getSize() + "' readonly></td>");
                            out.println("<td><input type='text' value='" + del.getEffort() + "' readonly></td>");
                            out.println("</tr>");
                            i++;
                        }
                    %>
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
                    <%
                        Set set2 = enb.getLessonses();
                        itr = set2.iterator();
                        i = 1;
                        while (itr.hasNext()) {

                            Lessons les = (Lessons) itr.next();
                            out.println("<tr>");
                            out.println("<td><input type='text' value='" + i + "' readonly></td>");
                            out.println("<td><input type='text' value='" + les.getContext() + "' readonly></td>");
                            out.println("<td><input type='text' value='" + les.getLessons() + "' readonly></td>");
                            out.println("</tr>");
                            i++;
                        }
                    %>
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
                    <%
                        Set set3 = enb.getPlans();
                        itr = set3.iterator();
                        i = 1;
                        while (itr.hasNext()) {

                            Plan plan = (Plan) itr.next();
                            out.println("<tr>");
                            out.println("<td><input type='text' value='" + i + 1 + "' readonly></td>");
                            out.println("<td><input type='text' value='" + plan.getDeliverable() + "' readonly></td>");
                            out.println("<td><input type='text' value='" + plan.getIntendToAccomplish() + "' readonly></td>");
                            out.println("</tr>");
                            i++;
                        }
                    %>
                </table>

            </div>
        </div>
    </body>
</html>
