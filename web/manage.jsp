<%-- 
    Document   : manage
    Created on : Aug 8, 2013, 4:08:21 PM
    Author     : B.Revanth
--%>

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
            <h1>Manage ENB</h1>
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
        <%
            
            int pid = Integer.parseInt(request.getParameter("pid"));
            
            ProjectHelper ph=new ProjectHelper();
            EnbdescHelper eh = new EnbdescHelper();
            RegistrationHelper rh=new RegistrationHelper();
            
            Enbdesc ed = eh.getEnbdescPID(pid);
            Project p=ph.getProjectPID(pid);
            if(ed==null){
                ed=new Enbdesc();
                Userauth ua=rh.getUserId(session.getAttribute("email").toString());
                Calendar now = Calendar.getInstance();  
            
                if(p.getIsMonthly()=="No"){
                    int weekday = now.get(Calendar.DAY_OF_WEEK);               
                    int days = (Calendar.SATURDAY - weekday) % 7;  
                    now.add(Calendar.DAY_OF_YEAR, days); 

                    Calendar projto=Calendar.getInstance();
                    projto.setTime(p.getToDate());
                    if(projto.compareTo(now)<0){
                        now=projto;
                    }
                }            
                else{
                    now.set(Calendar.DATE,now.getActualMaximum(Calendar.DATE)); 

                    Calendar projto=Calendar.getInstance();
                    projto.setTime(p.getToDate());
                    if(projto.compareTo(now)<0){
                        now=projto;
                    }
                }
                System.out.print("");                       
                Calendar at=Calendar.getInstance();
                ed.setEnbname(p.getProjectName()+" : "+at.get(Calendar.DATE)+"-"+(at.get(Calendar.MONTH)+1)+"-"+at.get(Calendar.YEAR)+" to "+now.get(Calendar.DATE)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.YEAR)); 
                ed.setProject(p);
                ed.setFromdate(at.getTime());
                ed.setTodate(now.getTime());         
                ed.setUserauth(ua);          
                System.out.print(""+ed);                       
                eh.insertEnbdesc(ed);            
                session.setAttribute("enbname", ed.getEnbname());    
                session.setAttribute("emid", eh.getEnbid(ed.getEnbname()).getId());
                System.out.println(""+session.getAttribute("emid"));
            }
            
            
            Calendar from = Calendar.getInstance();
            from.setTime(ed.getFromdate());

            Calendar to = Calendar.getInstance();
            to.setTime(ed.getTodate());

            String proj = ed.getProject().getProjectName();
            Set notes = ed.getNoteses();
            Set ds =  ed.getDeliverablestatuses();
            Set ln = ed.getLessonses();
            Set pl = ed.getPlans();
        %>
        <div id="main">
            <form method="post" id="enbform">
                <div id="content">
                    <table width="100%" border="0">
                        <tr>
                            <td width="80%">
                                ENB Name :<br>
                                <h2><%=proj%></h2>
                            </td >
                        </tr>
                    </table>
                </div>

                <div id="tabs" class="hide">

                    <ul>  
                        <li><a href="#tab1" id="atab1" class="present">Notes</a></li> 
                        <li><a href="#tab2" id="atab2">Deliverable Status</a></li> 
                        <li><a href="#tab3" id="atab3">Lessons Learned Reflection</a></li>
                        <li><a href="#tab4" id="atab4">Plan for the Next Week</a></li>
                    </ul> 
                    <div class="settings">
                        <input type="submit" value="save" style="float:right;" class="button">
                    </div>
                    <div id="tab1">
                        <br>
                        <p class="grey">Record key insights from readings and discussions.</p>
                        <br>
                        <%
                            String enbname = ed.getEnbname();
                            EnbdescHelper eh1 = new EnbdescHelper();
                            Enbdesc enb = eh1.getEnbid(enbname);
                            //int enbid = enb.getId();
                            Set set = enb.getNoteses();
                            Iterator itr = set.iterator();

                            while (itr.hasNext()) {
                                Notes note = (Notes) itr.next();
                                String s=new String(note.getNotes());
                                out.println("<textarea>" + s + "</textarea>");
                            }
                        %>
                        <br><br>
                        <input type="submit" class="button" value="Save">
                    </div> 
                    <div id="tab2">
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
                                Set set1 = enb.getDeliverablestatuses();
                                itr = set1.iterator();
                                int i = 1;
                                while (itr.hasNext()) {

                                    Deliverablestatus del = (Deliverablestatus) itr.next();
                                    out.println("<tr>");
                                    out.println("<td><input type='text' value='" + i + "'></td>");
                                    out.println("<td><input type='text' name='dsd"+i+"' value='" + del.getDeliverables() + "'></td>");
                                    out.println("<td><input type='text' name='dsp"+i+"' value='" + del.getPlanToAccomplish() + "'></td>");
                                    out.println("<td><input type='text' name='dsa"+i+"' value='" + del.getActualAccomplished() + "'></td>");
                                    out.println("<td><input type='text' name='dss"+i+"' value='" + del.getSize() + "'></td>");
                                    out.println("<td><input type='text' name='dse"+i+"' value='" + del.getEffort() + "'></td>");
                                    out.println("</tr>");
                                    i++;
                                    
                                }
                            %>					  
                        </table>
                        <br/>
                        <input type="submit" class="button" value="Save" id="dss">
                        <input type="button" class="button" value="Add Row" id="dsr">
                    </div>
                    <div id="tab3">
                        <table width="800" height="209" border="0" id="lntable">
                            <tr>
                                <td width="10%">S.NO.</td>
                                <td width="25%"><center>Context</center></td>
                            <td width="65%"><center>Lesson</center></td>
                            </tr>
                            <%
                                Set set2 = enb.getLessonses();
                                itr = set2.iterator();
                                i = 1;
                                while (itr.hasNext()) {

                                    Lessons les = (Lessons) itr.next();
                                    out.println("<tr>");
                                    out.println("<td><input type='text' value='" + i + "'></td>");
                                    out.println("<td><input type='text' name='lnc"+i+"' value='" + les.getContext() + "'></td>");
                                    out.println("<td><input type='text' name='lnl"+i+"' value='" + les.getLessons() + "'></td>");
                                    out.println("</tr>");
                                    i++;
                                }
                            %>
                        </table>
                        <br/>
                        <input type="submit" class="button" value="Save" id="lns">
                        <input type="button" class="button" value="Add Row" id="lnar" name="lnar">
                    </div>
                    <div id="tab4">
                        <br/>
                        <p>These items should appear in the deliverable status for the next week.</p>
                        <br/>
                        <table width="800" height="209" border="0" id="plantable">
                            <tr>
                                <td width="10%">S.NO.</td>
                                <td width="25%"><center>Deliverable</center></td>
                            <td width="65%"><center>What do you intend to accomplish and why</center></td>
                            </tr>
                            <%
                                Set set3 = enb.getPlans();
                                itr = set3.iterator();
                                i = 1;
                                while (itr.hasNext()) {

                                    Plan plan = (Plan) itr.next();
                                    out.println("<tr>");
                                    out.println("<td><input type='text' value='" + i + "'></td>");
                                    out.println("<td><input type='text' name='pld"+i+"' value='" + plan.getDeliverable() + "'></td>");
                                    out.println("<td><input type='text' name='plw"+i+"' value='" + plan.getIntendToAccomplish() + "'></td>");
                                    out.println("</tr>");
                                    i++;
                                }
                            %>					  
                        </table>
                        <br/>
                        <input type="submit" class="button" value="Save" id="plans">
                        <input type="button" class="button" value="Add Row" id="planr">
                    </div>

                </div>
            </form>
        </div>
    </body>
</html>