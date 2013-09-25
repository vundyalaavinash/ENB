<%-- 
 Document : ENB
 Created on : Aug 8, 2013, 4:11:59 PM
 Author  : B.Revanth
--%>

<%@page import="com.enb.POJO.Notes"%>
<%@page import="com.enb.Helper.NotesHelper"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.enb.POJO.Enbdesc"%>
<%@page import="com.enb.Helper.EnbdescHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ENB Tool</title>
        <link rel="stylesheet" href="Styles/Main.css">			
        <link href="Styles/alertify.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.core.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.default.css" rel="stylesheet" type="text/css" /> 
        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>=		
        <script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
        <script src="Scripts/jquery-ui.js" type="text/javascript"></script>
        <script src="Scripts/alertify.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.autosize.min.js" type="text/javascript"></script>  
        <script src="Scripts/idle-timer.min.js" type="text/javascript"></script>
        <script src="CusScripts/writeenb.js" type="text/javascript"></script>        
    </head>
    <body>
        <header>
            <span>Engineering Notebook</span>
            <h1>Tool</h1>
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
        <div id="mydiv" class="hide">
            <div class="ajax-loader">
                <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Loading</h3>
                <img src="Styles/images/loader.gif" />
            </div>
        </div>
        <div id="main">					
            <div id="tabs">
                <form method="post" action="enb" id="enbform">
                    <ul> 
                        <li><a href="#tab1" id="atab1" class="present">Notes</a></li> 
                        <li><a href="#tab2" id="atab2">Deliverable Status</a></li> 
                        <li><a href="#tab3" id="atab3">Lessons Learned Reflection</a></li>
                        <li><a href="#tab4" id="atab4">Plan for the Next Week</a></li>
                    </ul> 
                    <div class="settings">
                        <span class="status"></span>
                        <input type="button" value="save" style="float:right;" class="button" id="savebtn" >
                        <br>
                    </div>
                    <div id="tab1">
                        <br>
                        <br>
                        <div style="width:100%; min-height: 300px; border: 2px #999999 double;" id="edValue" contenteditable="true" onKeyPress="edValueKeyPress()" onKeyUp="edValueKeyPress()" onKeyDown='showCaretPos()'> </div>
                        <br>
                        <input type='button' class='button' onclick="getSelectionHtml();" value="Strike OFF"> 
                        <input type='hidden' value="" name='notes1' id="notes1">      
                    </div> 
                    <div id="tab2">
                        <br>
                        <br>
                        <table width="100%" border="0" cellspacing="20" id="dstable">
                            <tr>
                                <td width="5%">SNO</td>
                                <td width="15%"><center>Deliverable</center></td>
                                <td width="27%"><center>What did you plan to accomplish?</center></td>
                                <td width="27%"><center>What did you actually accomplish?</center></td>
                                <td width="10%"><center>Size</center></td>
                                <td width="10%"><center>Effort</center></td>
                            </tr>
                            <tr>
                                <td>1.</td>
                                <td><center><textarea onkeyup="textAreaAdjust(this)" name="dsd1" ></textarea></center></td>
                                <td><center><textarea onkeyup="textAreaAdjust(this)" name="dsp1" ></textarea></center></td>
                                <td><center><textarea onkeyup="textAreaAdjust(this)" name="dsa1" ></textarea></center></td>
                                <td><center><textarea onkeyup="textAreaAdjust(this)" name="dss1" ></textarea></center></td>
                                <td><center><textarea onkeyup="textAreaAdjust(this)" name="dse1" ></textarea></center></td>
                            </tr>					 
                        </table>
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
                            <tr>
                                <td>1.</td>
                                <td><center><textarea onkeyup="textAreaAdjust(this)" name="lnc1" ></textarea></center></td>
                            <td><center><textarea onkeyup="textAreaAdjust(this)" name="lnl1" ></textarea></center></td>
                            </tr>
                        </table>
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
                            <tr>
                                <td>1.</td>
                                <td><center><textarea onkeyup="textAreaAdjust(this)" name="pld1" ></textarea></center></td>
                            <td><center><textarea onkeyup="textAreaAdjust(this)" name="plw1" ></textarea></center></td>
                            </tr>					 
                        </table>
                        <br/>
                        <input type="button" class="button" value="Add Row" id="planr">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>