<%-- 
    Document   : ENB
    Created on : Aug 8, 2013, 4:11:59 PM
    Author     : B.Revanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ENB Tool</title>
        <link rel="stylesheet"  href="Styles/Main.css">			

        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>=		
        <script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
        <script src="Scripts/jquery-ui.js" type="text/javascript"></script>

        <script src="CusScripts/ENB.js" type="text/javascript"></script>

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
            <h3>Raj</h3>
            <a href="Homepage.jsp">Home</a>
            <a href="create.jsp">Create ENB</a>
            <a href="manage.jsp">Manage ENB</a>
            <a href="view.jsp">View ENB</a>
            <a href="view.jsp">Logs</a>
            <a href="account.jsp">Account</a>
        </nav>

        <div id="main">					
            <div id="tabs">
                <form method="post" id="enbform">
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
                        <p>Record key insights from readings and discussions.</p>
                        <br>
                        <textarea name="notes1" rows="13" placeholder="Enter your notes here"></textarea>
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
                            <tr>
                                <td>1.</td>
                                <td><input type='text' name='lnc1' class='required'></td>
                                <td><input type='text' name='lnl1' class='required'></td>
                            </tr>
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
                            <tr>
                                <td>1.</td>
                                <td><input type='text' name='pland1' class='required' ></td>
                                <td><input type='text' name='planw1' class='required' ></td>
                            </tr>					  
                        </table>
                        <br/>
                        <input type="submit" class="button" value="Save" id="plans">
                        <input type="button" class="button" value="Add Row" id="planr">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>