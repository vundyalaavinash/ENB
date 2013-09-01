<%-- 
    Document   : view
    Created on : Aug 8, 2013, 4:07:47 PM
    Author     : B.Revanth
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.enb.Helper.*"%>
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
            <a href="search.jsp">Search</a>
            <a href="manageselect.jsp">Manage ENB</a>
            <a href="viewselect.jsp">View ENB</a>
            <a href="logs.jsp">Logs</a>
            <a href="account.jsp">Account</a>
        </nav>

        <div id="main">
            <div id="content">
                <form action='DownloadPDF' method="post" target="_blank">
                    <table width="100%" border="0">
                        <tr>
                            <td width="80%">
                                <input type='hidden' value="<%=request.getParameter("eid")%>" name="selectenb" id="selectenb">
                                <input type='hidden' value="" name="htmlcontent" id="htmlcontent">
                            </td >
                            <td width="20%">
                                <input type="submit" class="button floatr hide" id="delbtn" value="Download ENB"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>

            <div id='tabs' class='invicible'>
                <%

                    int eid = Integer.parseInt(request.getParameter("eid"));
                    int uid = Integer.parseInt(session.getAttribute("uid").toString());
                    EnbdescHelper eh = new EnbdescHelper();
                    Enbdesc ed = eh.getEnbdescID(eid);


                    RegistrationHelper rh = new RegistrationHelper();
                    NotesHelper nh = new NotesHelper();
                    DeliverablesHelper dh = new DeliverablesHelper();
                    LessonsHelper lh = new LessonsHelper();
                    PlanHelper plh = new PlanHelper();

                    Calendar from = Calendar.getInstance();
                    from.setTime(ed.getFromdate());

                    Calendar to = Calendar.getInstance();
                    to.setTime(ed.getTodate());

                    String proj = ed.getProject().getProjectName();
                    Set notes = ed.getNoteses();
                    Set ds = ed.getDeliverablestatuses();
                    Set ln = ed.getLessonses();
                    Set pl = ed.getPlans();


                    out.print("<table width='100%'><tr><td colspan='2'><h2>" + proj.toUpperCase() + "</h2></td></tr><tr>");
                    out.print("<td width='50%'>Engineer: <span style='color:#47a3da;'>");
                    if (session.getAttribute("name") == null) {
                        response.sendRedirect("index.jsp");
                    } else {
                        out.println(session.getAttribute("name"));
                    }
                    out.print("</span></td>");
                    out.print("<td width='50%' align='right'>Duration: <span style='color:#47a3da;'>");
                    out.print("&nbsp;&nbsp;&nbsp;" + from.get(Calendar.DATE) + "-" + from.get(Calendar.MONTH) + "-" + from.get(Calendar.YEAR));
                    out.print("</span>&nbsp;&nbsp;to<span style='color:#47a3da;'>");
                    out.print("&nbsp;&nbsp;&nbsp;" + to.get(Calendar.DATE) + "-" + to.get(Calendar.MONTH) + "-" + to.get(Calendar.YEAR));
                    out.print("</span></td></tr></table><br><hr><br>");

                    String enbname = ed.getEnbname();
                    EnbdescHelper eh1 = new EnbdescHelper();
                    Enbdesc enb = eh1.getEnbid(enbname, uid);

                    //Notes
                    out.print("<h2>Notes</h2><table><tr><td><div style='font-size:15px; width:100%;'>");
                    ArrayList<Notes> itr = nh.getNote(ed.getId());
                    if (!itr.isEmpty()) {
                        Notes note = (Notes) itr.get(0);
                        String s = new String(note.getNotes());
                        out.print(s);
                    } else {
                        out.println("No Notes in the ENB ....");
                    }
                    out.print("</div></td></tr></table><br><hr><br>");

                    //Deliverable Status
                    out.print("<h2>Deliverable Status</h2><table width='100%' border='0' cellspacing='10'><tr><td width='5%'>SNO</td><td width='16%'>Deliverable</td><td width='27%'>What did you plan to accomplish?</td><td width='27%'>What did you actually accomplish?</td><td width='10%'>Size</td><td width='10%'>Effort</td></tr>");
                    int i = 0;
                    ArrayList<Deliverablestatus> dsi = dh.getDeliverablestatus(ed.getId());
                    for (i = 0; i < dsi.size(); i++) {
                        Deliverablestatus dso = dsi.get(i);
                        out.print("<tr><td>" + (i + 1) + "</td><td>" + dso.getDeliverables() + "</td><td>" + dso.getPlanToAccomplish() + "</td><td>" + dso.getActualAccomplished() + "</td><td>" + dso.getSize() + "</td><td>" + dso.getEffort() + "</td></tr>");
                    }
                    out.print("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr></table><br><hr><br>");
                    //Lessons Learned  

                    out.print("<h2>Lessons Learned Reflection</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO.</td><td width='25%'>Context</td><td width='65%'>Lesson</td></tr>");
                    ArrayList<Lessons> lni = lh.getLessons(ed.getId());
                    for (i = 0; i < lni.size(); i++) {
                        Lessons lno = lni.get(i);
                        out.print("<tr><td>" + (i + 1) + "</td><td>" + lno.getContext() + "</td><td>" + lno.getLessons() + "</td></tr>");
                    }
                    out.print("<tr><td></td><td></td><td></td></tr></table><br><hr><br>");

                    //plans
                    out.print("<h2>Plan for the Next Week</h2><table width='100%' border='0' cellspacing='10'><tr><td width='10%'>S.NO</td><td width='25%'>Deliverable</td><td width='65%'>What do you intend to accomplish and why</td></tr>");
                    ArrayList<Plan> pli = plh.getPlan(ed.getId());
                    for (i = 0; i < pli.size(); i++) {
                        Plan plo = pli.get(i);
                        out.print("<tr><td width='10%'>" + (i + 1) + "</td><td width='25%'>" + plo.getDeliverable() + "</td><td width='65%'>" + plo.getIntendToAccomplish() + "</td></tr>");
                    }
                    out.print("<tr><td></td><td></td><td></td></tr></table>");
                    UserLogHelper uh = new UserLogHelper();
                    if (session.getAttribute("uid") == null) {
                        response.sendRedirect("index.jsp");
                    }
                    uh.insertlog(session.getAttribute("uid").toString(), "View ENB-" + ed.getEnbname());

                %>
            </div>
            <div id="mydiv" class="hide">
                <div  class="ajax-loader">
                    <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Loading</h3>
                    <img src="Styles/images/loader.gif" />
                </div>
            </div>
        </div>

    </body>
</html>
