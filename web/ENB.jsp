<%-- 
    Document   : ENB
    Created on : Aug 8, 2013, 4:11:59 PM
    Author     :
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
       // HttpSession ses=request.getSession();
        String enbname =(String) session.getAttribute("enbname");
                    EnbdescHelper eh1 = new EnbdescHelper();
                    Enbdesc enb = eh1.getEnbid(enbname);
                    //int enbid=enb.getId();
                    Set set = enb.getNoteses();
                    Iterator itr = set.iterator();
                    Notes note = (Notes) itr.next();
                    String notes=note.getNotes().toString();
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
       <script type="text/javascript">
    
    
    function getText()
    {
    document.getElementById("notes").innerHTML="<p><%=notes%> Got Text </p>";
    }
    
    function copyNotes()
    {
        var notes1=document.getElementById("notes").innerHTML;
        document.edit_notes.mynotes.value=notes1;
        alert("saved text is "+notes1);
    }
    
    function saveHighlight()
    {
    var selection;

            //Get the selected stuff
            if(window.getSelection) 
              selection = window.getSelection();
            else if(typeof document.selection!="undefined")
              selection = document.selection;

            //Get a the selected content, in a range object
            var range = selection.getRangeAt(0);

            //If the range spans some text, and inside a tag, set its css class.
            if(range && !selection.isCollapsed)
            {
              if(selection.anchorNode.parentNode == selection.focusNode.parentNode)
              {
                var span = document.createElement('span');
                span.className = 'highlight-green';
                range.surroundContents(span);
                alert(range);
              }
            }
    }
    
    function getReference(elem,e)
    {
        var savedcontent = elem.innerHTML;
        alert("my text is "+e.clipboardData.getData('text/plain'));
        var texttocopy=e.clipboardData.getData('text/plain');
        var reference=prompt("Enter the Reference for Copied Text ","");
        var mynotes=document.getElementById("notes").innerHTML;
        var rep_text="";
        if(reference.length!=0)
        {
            rep_text="<font style=\"background-color:yellow;\">"+texttocopy+"</font>"
            rep_text=rep_text+"  &nbsp; &nbsp; <font style=\"background-color:green;\">Reference : "+reference+"</font> for Copied text";
            alert(rep_text);
            rep_text=mynotes+rep_text;
        }
        else
            {
                rep_text=elem.innerHTML;
        }
    if (e && e.clipboardData && e.clipboardData.getData) {// Webkit - get data from clipboard, put into editdiv, cleanup, then cancel event
        if (/text\/html/.test(e.clipboardData.types)) {
            alert("got html");
            e.preventDefault();
            elem.innerHTML = rep_text;
        }
        else if (/text\/plain/.test(e.clipboardData.types)) {
            alert("got it");
            e.preventDefault();
            elem.innerHTML = rep_text;
        }
        else {
            alert("nothing");
            e.preventDefault();
            elem.innerHTML=rep_text;
        }
        
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
                    if(session.getAttribute("name")==null){
                        response.sendRedirect("index.jsp");
                    }
                    else{
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
                    </div>
                    <div id="tab1">
                        <br>
                        <br>
                        <div class="test" contenteditable="true" id="notes" style="border:medium dotted black" onPaste="getReference(this,event);">
                            <textarea name="notes1" rows="13" placeholder="Enter your notes here"></textarea>
                        </div>
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