<%-- 
    Document   : forgot
    Created on : Aug 8, 2013, 4:04:40 PM
    Author     : B.Revanth
--%>

<html>
    <head>
        <title>ENB | ARM Technologies</title>
        <link rel="stylesheet"  href="Styles/Home.css">		
        <script src="Scripts/jquery-1.10.2.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.shuffleLetters.js" type="text/javascript"></script>
        <script src="Scripts/jquery.validate.min.js" type="text/javascript"></script>
        <script src="Scripts/additional-methods.js" type="text/javascript"></script>

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
                    <div id="login">						
                        <h2>Resend Verification Code</h2>
                        <form id="loginForm" method="post" action="resend">
                            <fieldset>
                                <% if (request.getAttribute("error") != null) {
                                        out.println("<p class='alert' style='color:white;'>" + request.getAttribute("error") + "</p>");
                                    }%>
                                <p><label for="email">E-mail address</label></p>
                                <p><input type="email" id="email" class="email required" placeholder="Enter Email ID" name="email"></p>
                                <p><input type="submit" value="Send Verification Code" class="button"></p>
                                <p>
                                    <div class="floatl divf"><a href="signup.jsp" class="floatr">Sign Up</a></div>
                                    <div class="floatr divf"><a href="verify.jsp">Verify User</a></div>
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
                &copy; <a href="#">ARM Team </a> 2013
            </div>
            <div id="footerright">
                <a href="about.jsp">About</a>
                <a href="terms.jsp">Terms</a>
            </div>			
        </footer>
    </body>
</html>

