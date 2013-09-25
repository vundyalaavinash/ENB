<%-- 
    Document   : Students
    Created on : Sep 24, 2013, 11:56:20 AM
    Author     : Avinash
--%>

<%@page import="com.enb.Helper.*"%>
<%@page import="com.enb.POJO.*"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Students</title>
        <link rel="stylesheet"  href="Styles/Main.css">		
        <link rel="stylesheet"  href="Styles/jquery.gridster.css">
        <link rel="stylesheet"  href="Styles/default.css">		
        <link rel="stylesheet"  href="Styles/default.date.css">		
        <link rel="stylesheet"  href="Styles/square/blue.css">	
        <link href="Styles/alertify.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.core.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.default.css" rel="stylesheet" type="text/css" />

        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>=		
        <script src="Scripts/jquery.gridster.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.icheck.min.js" type="text/javascript"></script>
        <script src="Scripts/alertify.min.js" type="text/javascript"></script>

        <script src="CusScripts/students.js" type="text/javascript"></script>

    </head>
    <body>
        <header>
            <span>Engineering Notebook</span>
            <h1>Account</h1>
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
            <a href="adminhome.jsp">Home</a>
            <a href="Students.jsp">Student</a>
            <a href="adminaccount.jsp">Account</a>
        </nav>
        <div id="main">
             <div id="mydiv" class="hide">
                <div  class="ajax-loader">
                    <h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Loading</h3>
                    <img src="Styles/images/loader.gif" />
                </div>
            </div> 
            <form id="StudentGroup" method="post">
                <p>Select Students to be Under you:</p>
                <table cellspacing='10'>
                <% 
                    GroupHelper gh=new GroupHelper();
                    RegistrationHelper rh=new RegistrationHelper();
                    ArrayList<Integer> al=new ArrayList<Integer>();
                    ArrayList<Groups> ag=gh.getAllGroups(Integer.parseInt(session.getAttribute("uid").toString()));
                    for(int i=0;i<ag.size();i++){
                        al.add(ag.get(i).getUserauthBySid().getId());
                    }
                    ArrayList<Userauth> au=rh.getStudentsAll();
                    for(int i=0;i<au.size();i++){
                        Userauth ua=au.get(i);
                        if(al.contains(ua.getId())){
                            out.println("<tr><td><input type='checkbox' name='students' value='"+ua.getId()+"' checked></td><td>"+ua.getName()+"</td></tr>");
                        }
                        else{
                            out.println("<tr><td><input type='checkbox' name='students' value='"+ua.getId()+"'></td><td>"+ua.getName()+"</td></tr>");
                        }
                    }                    
                %>
                </table>
                <br>
                <script>
                    $(document).ready(function() {
                        $('#StudentGroup input').iCheck({
                            checkboxClass: 'icheckbox_square-blue',
                            radioClass: 'iradio_square-blue',
                            increaseArea: '20%'
                        });
                    });
                </script>
                <input type='button' class='button' value='Update' id='update'>
            </form>
        </div>
    </body>
</html>
