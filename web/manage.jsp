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
        <link href="Styles/alertify.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.core.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.default.css" rel="stylesheet" type="text/css" />

        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>		
        <script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
        <script src="Scripts/jquery-ui.js" type="text/javascript"></script>
        <script src="Scripts/alertify.min.js" type="text/javascript"></script>

        <script src="CusScripts/manage.js" type="text/javascript"></script>
        <script src="CusScripts/manageenb.js" type="text/javascript"></script>

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
            System.out.print(""+ed);  
            
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
            
            session.setAttribute("emid", eh.getEnbid(ed.getEnbname()).getId());
            
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
                                <h2><%=proj.toUpperCase() %></h2>
                                <p><%=ed.getEnbname() %></p>
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
                        <input type="submit" value="save" style="float:right;" class="button" id="savebtn">
                    </div>
                    <div id="tab1">
                        <br>
                        <%
                            String enbname = ed.getEnbname();
                            EnbdescHelper eh1 = new EnbdescHelper();
                            Enbdesc enb = eh1.getEnbid(enbname);
                            //int enbid = enb.getId();
                            Set set = enb.getNoteses();
                            Iterator itr = set.iterator();

                            if (itr.hasNext()) {
                                Notes note = (Notes) itr.next();
                                String s=new String(note.getNotes());
                                out.println("<br/><br/><textarea name='notes1' rows='13' placeholder='Enter your notes here'>" + s + "</textarea>");
                            }
                            else{
                                out.println("<br/><br/><textarea name='notes1' rows='13' placeholder='Enter your notes here'></textarea>");
                            }
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
                                Iterator<Deliverablestatus> dsi=ds.iterator();                               
                                int i=0;
                                while(dsi.hasNext()){
                                    i++;
                                    Deliverablestatus dso=dsi.next();                                    
                                    out.print("<tr><td>"+i+".</td>");
                                    out.print("<td><input type='text' name='dsd"+i+"' class='required' value='"+dso.getDeliverables()+"'></td>");
                                    out.print("<td><input type='text' name='dsp"+i+"' class='required' value='"+dso.getPlanToAccomplish()+"'></td>");
                                    out.print("<td><input type='text' name='dsa"+i+"' class='required' value='"+dso.getActualAccomplished()+"'></td>");
                                    out.print("<td><input type='text' name='dss"+i+"' class='required' value='"+dso.getSize()+"'></td>");
                                    out.print("<td><input type='text' name='dse"+i+"' class='required' value='"+dso.getEffort()+"'></td></tr>");
                                }
                                out.print("</table><input type='hidden' id='idscount' name='idscount' value='"+i+"'>");                            					  
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
                                Iterator<Lessons> lni=ln.iterator();
                                i=0;
                                while(lni.hasNext()){
                                    i++;
                                    Lessons lno=lni.next();
                                    out.print("<tr><td>"+i+".</td>");
                                    out.print("<td><input type='text' name='lnc"+i+"' class='required' value='"+lno.getContext()+"'></td>");
                                    out.print("<td><input type='text' name='lnl"+i+"' class='required' value='"+lno.getLessons()+"'></td></tr>");                                    
                                }
                                out.print("</table><input type='hidden' id='ilncount' name='ilncount' value='"+i+"'>");                            					  
                            %>
                        <br/>
                        <input type="button" class="button" value="Add Row" id="lnar" name="lnar">
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
                                Iterator<Plan> pli=pl.iterator();                                
                                i=0;
                                while(pli.hasNext()){
                                    i++;
                                    Plan plo=pli.next();                                    
                                    out.print("<tr><td>"+i+".</td>");
                                    out.print("<td><input type='text' name='pld"+i+"' class='required' value='"+plo.getDeliverable()+"'></td>");
                                    out.print("<td><input type='text' name='plw"+i+"' class='required' value='"+plo.getIntendToAccomplish()+"'></td></tr>");
                                }
                                out.print("</table><input type='hidden' id='iplancount' name='iplancount' value='"+i+"'>");
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