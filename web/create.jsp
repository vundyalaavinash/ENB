<%-- 
    Document   : create
    Created on : Aug 8, 2013, 4:09:40 PM
    Author     : B.Revanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create ENB</title>
        <link rel="stylesheet"  href="Styles/Main.css">		
        <link rel="stylesheet"  href="Styles/default.css">		
        <link rel="stylesheet"  href="Styles/default.date.css">		
        <link rel="stylesheet"  href="Styles/square/blue.css">	

        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>
        <script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
        <script src="Scripts/picker.js" type="text/javascript"></script>
        <script src="Scripts/picker.date.js" type="text/javascript"></script>
        <script src="Scripts/jquery.icheck.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.min.js" type="text/javascript"></script>
        <script src="Scripts/alertify.min.js" type="text/javascript"></script>

        
        <script src="CusScripts/create.js" type="text/javascript"></script>

    </head>
    <body>
        <header>
            <span>Engineering Notebook</span>
            <h1>Create ENB</h1>
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

        <div id="main">
            <form id="createform" method="post" action="CreateForm">
                <table width="50%">
                    <tr>
                        <td><br>
                            Project Name:
                            <br>
                            <input type="text" value="" name="proj" class="required uproject" placeholder="Enter Project" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <table>
                                <tr>
                                    <td>
                                        <br>
                                        <br>
                                        Duration of Project
                                        <br>
                                        <br>	
                                    </td>
                                    <td>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        From:
                                        <br>
                                        <input name="from" type="text" class="datepicker1 required" placeholder="From" />
                                    </td>
                                    <td>
                                        To:
                                        <br>
                                        <input name="to" type="text" class="datepicker required"  placeholder="To"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><br></td>
                                    <td>
                                        <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Preferred ENB Duration :</td>
                                    <td>
                                        <table>
                                            <tr>
                                                <td>
                                                    <input type="radio" id="radio1" name="weekmonth" value="weekly">
                                                </td>
                                                <td>
                                                    &nbsp;&nbsp;&nbsp;<label for="radio1">Weekly</label><br/>
                                                <td/>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <br/>
                                                </td>
                                                <td>

                                                <td/>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <input type="radio" id="radio2" name="weekmonth" value="monthly">
                                                </td>
                                                <td>
                                                    &nbsp;&nbsp;&nbsp;<label for="radio1">Monthly</label><br/>
                                                <td/>
                                            </tr>
                                        </table>
                                    </td>
                                <script>
                                    $(document).ready(function() {
                                        function callback_logType(id, type) {
                                            type1 = $("#" + id).val();
                                        }
                                        ;
                                        $('#main input').on('ifChanged', function(event) {
                                            callback_logType(this.id, event.type);
                                        }).iCheck({
                                            checkboxClass: 'icheckbox_square-blue',
                                            radioClass: 'iradio_square-blue',
                                            increaseArea: '20%'
                                        });
                                    });
                                </script>
                    </tr>
                </table>
                </td>
                </tr>
                <tr>
                    <td><br>

                        <input type="Submit" value="Create ENB" name="submitbtn" class="button" />
                    </td>
                </tr>
                </table>			
            </form>
        </div>
    </body>
</html>