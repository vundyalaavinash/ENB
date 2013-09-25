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
                        <h2>Message!</h2>
                        <form id="loginForm" method="post" action="ForgotPassword">
                            <fieldset>
                                <% if (request.getAttribute("error") != null) {
                                        out.println("<p class='alert' style='color:white;'>" + request.getAttribute("error") + "</p>");
                                    }%>
                                <%
                                    // if the id parameter is null then there is no purpose for this page
                                    if (request.getParameter("id") == null) {
                                        response.sendRedirect("index.jsp");
                                    } else {
                                        // if the id is 'axty1'(no significance randomly choosen) then the password is send to email id msg should be displayed
                                        if (request.getParameter("id").toString().equals("axty1")) {
                                            out.print("<p>Your Password has been sent to your eMail ID!</p>"
                                                    + "<p>"
                                                    + "<div class='floatl divf'><a href='signup.jsp' class='floatr'>Sign Up</a>"
                                                    + "</div><div class='floatr divf'><a href='index.jsp'>Sign IN</a></div></p>");
                                        } else if (request.getParameter("id").toString().equals("")) {
                                            out.print("<p>A Verification code has been Sent to Your mail ID!</p>");
                                        }
                                    }
                                %>

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

