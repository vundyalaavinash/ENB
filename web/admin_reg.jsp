<%-- 
    Document   : signup
    Created on : Aug 8, 2013, 4:20:13 PM
    Author     : Avinash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ENB | ARM Technologies</title>
        <link rel="stylesheet"  href="Styles/HomeOthers.css">		
         <link href="Styles/alertify.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.core.css" rel="stylesheet" type="text/css" />
        <link href="Styles/alertify.default.css" rel="stylesheet" type="text/css" />
        
        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.min.js" type="text/javascript"></script>
        <script src="Scripts/additional-methods.js" type="text/javascript"></script>
        <script src="Scripts/alertify.min.js" type="text/javascript"></script>
        
        <script src="CusScripts/Home.js" type="text/javascript"></script>

    </head>
    <body>
        <header>
            <div id="headmid">
                <div id="headleft">
                    <div id="logo">
                        <h1 id="title">Engineering NoteBook</h1>
                    </div>
                </div>		
                <div id="headright">
                    <div id="login" style="margin-top:5%">						
                        <h2>Sign UP</h2>
                        <form id="loginForm" method="post" action="AdminReg">
                            <fieldset>
                                <% if(request.getAttribute("error")!=null){
                                    out.println("<p class='alert' style='color:white;'>"+request.getAttribute("error")+"</p>");
                                                                   }%>
                                <p><label for="password2">Full Name</label></p>
                                <p><input type="text" id="fname" name="fname" class="required"  placeholder="Enter Your Name"></p>
                                <p><label for="email">E-mail address</label></p>
                                <p><input type="email" id="email" name="email" class="email required" placeholder="Enter Email ID"></p>

                                <p><label for="password">Password</label></p>
                                <p><input type="password" id="password" name="pass" class="required"  placeholder="Enter Password"></p>

                                <p><label for="password2">Re-Type Password</label></p>
                                <p><input type="password" id="password2" name="repass" class="required passmatch"  placeholder="re-Enter Password"></p>
                                <div class="floatl divf"><input type="submit" value="Sign UP" class="button" id="submit"></div>
                                <div class="floatr divf"><a href="index.jsp" style="padding:5px;">Log IN</a></div>
                                </p>
                            </fieldset>
                        </form>
                    </div>
                </div>	
            </div>

        </header>				
        <footer>
            <hr>
            <div id="footerleft">
                &copy; <a href="#">ARM Technologies </a> 2013
            </div>
            <div id="footerright">
                <a href="about.jsp">About</a>
                <a href="terms.jsp">Terms</a>
            </div>			
        </footer>
    </body>
</html>

