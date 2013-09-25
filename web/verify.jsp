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
                        <h2>Verify User</h2>
                            
                        <form id="loginForm" method="post" action="VerifyUser">
                            <fieldset>
                                <% if (request.getAttribute("error") != null) {
                                        out.println("<p class='alert' style='color:white;'>" + request.getAttribute("error") + "</p>");
                                    }%>
                                <p><label for="email">Email ID:</label></p>
                                <%
                                if(request.getParameter("email")!=null){
                                    out.print("<p><input type='text' class='required' placeholder='Enter Email ID' name='email' value='"+request.getParameter("email").toString() +"' readonly></p>");
                                }
                                else{
                                    out.print("<p><input type='text' class='required' placeholder='Enter Email ID' name='email' ></p>");
                                }                                
                                %>
                                <p><label for="email">Enter Verification Code:</label></p>
                                <p><input type="text" class="required" placeholder="Enter Verification Code" name="code"></p>
                                <p><input type="submit" value="Verify !" class="button"></p>
                            </fieldset>
                        </form>
                        <p>A mail has been sent to your Email ID! If you did not receive any email <a href='resend.jsp'>Click here to resend</a></p>
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

