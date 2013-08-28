<%-- 
    Document   : ENB
    Created on : Aug 8, 2013, 4:11:59 PM
    Author     : B.Revanth
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
        <link rel="stylesheet"  href="Styles/Main.css">			
        <link href="Styles/alertify.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.core.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.default.css" rel="stylesheet" type="text/css" />   
        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>=		
        <script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
        <script src="Scripts/jquery-ui.js" type="text/javascript"></script>
        <script src="Scripts/alertify.min.js" type="text/javascript"></script>
        <script src="CusScripts/writeenb.js" type="text/javascript"></script>
        <%
            HttpSession ses = request.getSession();
            String enbname = (String) session.getAttribute("enbname");
            EnbdescHelper eh1 = new EnbdescHelper();
            Enbdesc enb = eh1.getEnbid(enbname, Integer.parseInt(session.getAttribute("uid").toString()));
            //int enbid=enb.getId();
            Set set = enb.getNoteses();
            Iterator<Notes> itr = set.iterator();
            String notes = "";
            if (itr.hasNext()) {
                notes = itr.next().getNotes().toString();
            }
        %>
        <style>
            .highlight-green 
            {
                color: #00FF00;
            }
            .test {
                width: 600px;
                height: 600px;
                overflow: auto

            }
        </style>
        <script>
     
            function edValueKeyPress(){
    
                var myElement = document.getElementById('edValue');
                myElement.onpaste = function(e) {
                    var pastedText = undefined;
                    if (window.clipboardData && window.clipboardData.getData) { // IE
                        pastedText = window.clipboardData.getData('Text');
                    } else if (e.clipboardData && e.clipboardData.getData) {
                        pastedText = e.clipboardData.getData('text/plain');
                    }
                    //alert(pastedText); // Process and handle text...
                    ref='';
                    while(ref==null||ref==''){
                     ref =prompt("Please enter a Reference","");
                  }
                    //alert(ref.length)
                    if(ref!=null||ref!=''){                    
                    insertHtmlAtCursor('<p style=\"color:red; background:yellow; font:italic bold 12px/30px Georgia,serif;\">'+pastedText+'<br></p> <p style="color:#46786">Reference: '+ref+'</p>')
                    }  return false; // Prevent the default handler from running.
                };
   
            }
    
            function insertHtmlAtCursor(html) {
                var range, node;
                if (window.getSelection && window.getSelection().getRangeAt) {
                    range = window.getSelection().getRangeAt(0);
                    node = range.createContextualFragment(html);
                    range.insertNode(node);
                } else if (document.selection && document.selection.createRange) {
                    document.selection.createRange().pasteHTML(html);
                }
            }
  
            function getSelectionHtml() {
                var html = "";
                if (typeof window.getSelection != "undefined") {
                    var sel = window.getSelection();
                    if (sel.rangeCount) {
                        var container = document.createElement("div");
                        for (var i = 0, len = sel.rangeCount; i < len; ++i) {
                            container.appendChild(sel.getRangeAt(i).cloneContents());
                        }
                        html = container.innerHTML;
                    }
                } else if (typeof document.selection != "undefined") {
                    if (document.selection.type == "Text") {
                        html = document.selection.createRange().htmlText;
                    }
                }
                //alert(html);
                replaceSelectionWithHtml('<del>'+html+'</del>&nbsp;')
                lblValue.innerHTML = edValue.innerHTML;
            }

            function replaceSelectionWithHtml(html) {
                var range, html;
                if (window.getSelection && window.getSelection().getRangeAt) {
                    range = window.getSelection().getRangeAt(0);
                    range.deleteContents();
                    var div = document.createElement("div");
                    div.innerHTML = html;
                    var frag = document.createDocumentFragment(), child;
                    while ( (child = div.firstChild) ) {
                        frag.appendChild(child);
                    }
                    range.insertNode(frag);
                } else if (document.selection && document.selection.createRange) {
                    range = document.selection.createRange();
                    html = (node.nodeType == 3) ? node.data : node.outerHTML;
                    range.pasteHTML(html);
                }
            }
        </script>        
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
            <div  class="ajax-loader">
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
                        <div style="width:100%; min-height: 300px; border: 2px #999999 double;" id="edValue" contenteditable="true" onKeyPress="edValueKeyPress()" onKeyUp="edValueKeyPress()"> </div>
                        <br>
                        <input type='button' class='button' onclick="getSelectionHtml();" value="Strike OFF"> 
                        <input type='hidden' value="" name='notes1' id="notes1">                        
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
                            <tr>
                                <td>1.</td>
                                <td><input type='text' name='dsd1' class='required'></td>
                                <td><input type='text' name='dsp1' class='required'></td>
                                <td><input type='text' name='dsa1' class='required'></td>
                                <td><input type='text' name='dss1' class='required'></td>
                                <td><input type='text' name='dse1' class='required'></td>
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
                                <td><input type='text' name='lnc1' class='required'></td>
                                <td><input type='text' name='lnl1' class='required'></td>
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
                                <td><input type='text' name='pld1' class='required' ></td>
                                <td><input type='text' name='plw1' class='required' ></td>
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