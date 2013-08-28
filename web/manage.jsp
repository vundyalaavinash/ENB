<%-- 
    Document   : manage
    Created on : Aug 8, 2013, 4:08:21 PM
    Author     : B.Revanth
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.Hibernate"%>
<%@page import="com.enb.Helper.ProjectHelper"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.enb.POJO.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.enb.Helper.*"%>
<%@page import="com.enb.MiscClasses.ConstructString"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Manage ENB</title>
        <link rel="stylesheet"  href="Styles/Main.css">		
        <link href="Styles/alertify.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.core.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.default.css" rel="stylesheet" type="text/css" />

        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>		
        <script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
        <script src="Scripts/jquery-ui.js" type="text/javascript"></script>
        <script src="Scripts/alertify.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.autosize.min.js" type="text/javascript"></script>
        
        <script src="CusScripts/manage.js" type="text/javascript"></script>
        <script src="CusScripts/manageenb.js" type="text/javascript"></script>
        <script src="CusScripts/crossthrough.js" type="text/javascript"></script>
        <script>
        function textAreaAdjust(o) {
            o.style.fontFamily = "Times New Roman";
            o.style.fontSize= "12pt";
            o.style.height = "1px";
            o.style.height = (25+o.scrollHeight)+"px";
            //o.style.border="none";
        }
        </script>
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
        <%
            int pid = Integer.parseInt(request.getParameter("pid"));

            ProjectHelper ph = new ProjectHelper();
            EnbdescHelper eh = new EnbdescHelper();
            RegistrationHelper rh = new RegistrationHelper();
            NotesHelper nh = new NotesHelper();
            DeliverablesHelper dh = new DeliverablesHelper();
            LessonsHelper lh = new LessonsHelper();
            PlanHelper plh = new PlanHelper();

            Enbdesc ed = eh.getEnbdescPID(pid);
            Project p = ph.getProjectPID(pid);
            System.out.print("" + ed);
            int uid = Integer.parseInt(session.getAttribute("uid").toString());
            if (ed == null) {
                ed = new Enbdesc();
                Userauth ua = rh.getUserId(session.getAttribute("email").toString());
                Calendar now = Calendar.getInstance();

                if (p.getIsMonthly() == "No") {
                    int weekday = now.get(Calendar.DAY_OF_WEEK);
                    int days = (Calendar.SATURDAY - weekday) % 7;
                    now.add(Calendar.DAY_OF_YEAR, days);

                    Calendar projto = Calendar.getInstance();
                    projto.setTime(p.getToDate());
                    if (projto.compareTo(now) < 0) {
                        now = projto;
                    }
                } else {
                    now.set(Calendar.DATE, now.getActualMaximum(Calendar.DATE));

                    Calendar projto = Calendar.getInstance();
                    projto.setTime(p.getToDate());
                    if (projto.compareTo(now) < 0) {
                        now = projto;
                    }
                }
                Calendar at = Calendar.getInstance();
                ed.setEnbname(p.getProjectName() + " : " + at.get(Calendar.DATE) + "-" + (at.get(Calendar.MONTH) + 1) + "-" + at.get(Calendar.YEAR) + " to " + now.get(Calendar.DATE) + "-" + (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.YEAR));
                ed.setProject(p);
                ed.setFromdate(at.getTime());
                ed.setTodate(now.getTime());
                ed.setUserauth(ua);
                System.out.print("" + ed);
                eh.insertEnbdesc(ed);
                session.setAttribute("enbname", ed.getEnbname());

                session.setAttribute("emid", eh.getEnbid(ed.getEnbname(), uid).getId());
                System.out.println("" + session.getAttribute("emid"));
            }

            session.setAttribute("emid", eh.getEnbid(ed.getEnbname(), uid).getId());

            Calendar from = Calendar.getInstance();
            from.setTime(ed.getFromdate());

            Calendar to = Calendar.getInstance();
            to.setTime(ed.getTodate());

            String proj = p.getProjectName();
        %>
        <div id="main">
            <div id="mydiv" class="hide">
                <div  class="ajax-loader">
                    <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Loading</h3>
                    <img src="Styles/images/loader.gif" />
                </div>
            </div>
            <form method="post" id="enbform">
                <div id="content">
                    <table width="100%" border="0">
                        <tr>
                            <td width="80%">
                                <h2><%=proj.toUpperCase()%></h2>
                                <p><%=ed.getEnbname()%></p>
                                <br/>
                                <br/>
                            </td >
                        </tr>
                    </table>
                </div>

                <div id="tabs">   
                    <ul>  
                        <li><a href="#tab1" id="atab1" class="present">Notes</a></li> 
                        <li><a href="#tab2" id="atab2">Deliverable Status</a></li> 
                        <li><a href="#tab3" id="atab3">Lessons Learned Reflection</a></li>
                        <li><a href="#tab4" id="atab4">Plan for the Next Week</a></li>
                    </ul> 
                    <div class="settings">
                        <span class="status"></span>
                        <input type="submit" value="save" style="float:right;" class="button" id="savebtn">
                    </div>
                    <div id="tab1">
                        <br>
                        <%
                            String enbname = ed.getEnbname();
                            EnbdescHelper eh1 = new EnbdescHelper();
                            Enbdesc enb = eh1.getEnbid(enbname, uid);

                            ArrayList<Notes> itr = nh.getNote(ed.getId());
                            if (!itr.isEmpty()) {
                                Notes note = (Notes) itr.get(0);
                                String s = new String(note.getNotes());
                                out.println("<br/><br/><div id='edValue' style='width:100%; min-height:300px; border: 2px #999999 double;' contenteditable='true' onKeyPress='edValueKeyPress()' onKeyUp='edValueKeyPress()' onkeydown='showCaretPos()'>"+s+"</div><br>");
                            } else {
                                out.println("<br/><br/><div id='edValue' style='width:100%; min-height:300px; border: 2px #999999 double;' contenteditable='true' onKeyPress='edValueKeyPress()' onKeyUp='edValueKeyPress()' onkeydown='showCaretPos()'></div><br>");
                            }
                            out.print("<input type='button' class='button' onclick='getSelectionHtml();' value='Strike OFF'> <input type='hidden' value='' name='notes1' id='notes1'>");
                        %>              
                        <br><br>
                    </div> 
                    <div id="tab2">
                        <br>
                        <br>
                        <table width="100%" border="0" cellspacing="10" id="dstable">
                            <tr>
                                <td width="5%">SNO</td>
                                <td width="16%"><center>Deliverable</center></td>
                            <td width="27%"><center>What did you plan to accomplish?</center></td>
                            <td width="27%"><center>What did you actually accomplish?</center></td>
                            <td width="10%"><center>Size</center></td>
                            <td width="10%"><center>Effort</center></td>
                            </tr>
                            <%
                                //Deliverable Status
                                ArrayList<Deliverablestatus> dsi = dh.getDeliverablestatus(ed.getId());
                                int i = 0;
                                for (i = 0; i < dsi.size(); i++) {
                                    Deliverablestatus dso = dsi.get(i);
                                    out.print("<tr><td>" + (i + 1) + ".</td>");
                                    out.print("<td><center><textarea onkeyup='textAreaAdjust(this)' name='dsd"+i+"' class='test'>"+dso.getDeliverables()+"</textarea></center></td>");
                                    out.print("<td><center><textarea onkeyup='textAreaAdjust(this)' class='test' name='dsp"+i+"'>"+dso.getPlanToAccomplish()+"</textarea></center></td>");
                                    out.print("<td><center><textarea onkeyup='textAreaAdjust(this)' name=dsa"+i+"' class='test'>"+dso.getActualAccomplished()+"</textarea></center></td>");
                                    out.print("<td><center><textarea onkeyup='textAreaAdjust(this)' class='test' name='dss"+i+"'>"+dso.getSize()+"</textarea></center></td>");
                                    out.print("<td><center><textarea onkeyup='textAreaAdjust(this)' class='test' name='dse"+i+"'>"+dso.getEffort()+"</textarea></center></td>");
                                   }
                                out.print("</table><input type='hidden' id='idscount' name='idscount' value='" + i + "'>");
                            %>                             

                            <br/>
                            <input type="button" class="button" value="Add Row" id="dsr">
                            </div>    
                            <div id="tab3">
                                <br>
                                <br>
                                <table width="100%" border="0" id="lntable" cellspacing="10">
                                    <tr>
                                        <td width="10%">S.NO.</td>
                                        <td width="25%"><center>Context</center></td>
                                    <td width="65%"><center>Lesson</center></td>
                                    </tr>
                                    <%
                                        //Lessons Learned  
                                        ArrayList<Lessons> lni = lh.getLessons(ed.getId());
                                        for (i = 0; i < lni.size(); i++) {
                                            Lessons lno = lni.get(i);
                                            out.print("<tr><td>" + (i + 1) + ".</td>");
                                            out.print("<td><center><textarea onkeyup='textAreaAdjust(this)' name='lnc"+i+"' class='required' value='"+lno.getContext()+"'></textarea></center></td>");
                                            out.print("<td><center><textarea onkeyup='textAreaAdjust(this)' name='lnl"+i+"' class='required' value='"+lno.getLessons()+"'></textarea></center></td></tr>");                                    
                                        }
                                        out.print("</table><input type='hidden' id='ilncount' name='ilncount' value='" + i + "'>");
                                    %>
                                    <br/>
                                    <input type="button" class="button" value="Add Row" id="lnar" name="lnar"/>
                            </div>
                            <div id="tab4">
                                <br/>
                                <br/>
                                <table width="100%" border="0" id="plantable" cellspacing="10">
                                    <tr>
                                        <td width="10%">S.NO.</td>
                                        <td width="25%"><center>Deliverable</center></td>
                                    <td width="65%"><center>What do you intend to accomplish and why</center></td>
                                    </tr>
                                    <%
                                        //plans
                                        ArrayList<Plan> pli = plh.getPlan(ed.getId());
                                        i = 0;
                                        for (i = 0; i < pli.size(); i++) {
                                            Plan plo = pli.get(i);
                                            out.print("<tr><td>" + (i + 1) + ".</td>");
                                            out.print("<td><center><textarea onkeyup='textAreaAdjust(this)' name='pld"+i+"' class='test' value='"+plo.getDeliverable()+"'></textarea></center></td>");
                                            out.print("<td><center><textarea onkeyup='textAreaAdjust(this)' name='plw"+i+"' class='test' value='"+plo.getIntendToAccomplish()+"'></textarea></center></td></tr>");
                                        }
                                        out.print("</table><input type='hidden' id='iplancount' name='iplancount' value='" + i + "'>");
                                    %>
                                    <br/>
                                    <input type="button" class="button" value="Add Row" id="planr">
                                    </div>
                                    </div>
                                    </div>
                                    </form>
                                    </div>
                                    </body>
                                    </html>