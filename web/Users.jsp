<%-- 
    Document   : Users
    Created on : Sep 11, 2013, 11:51:55 AM
    Author     : Avinash
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.enb.POJO.Userauth"%>
<%@page import="com.enb.Helper.RegistrationHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <%
                RegistrationHelper rh = new RegistrationHelper();
                ArrayList<Userauth> al = rh.getUserauthAll();
                for (int i = 0; i < al.size(); i++) {
                    out.print("<tr><td>" + al.get(i).getName() + "</td>");
                    out.print("<td>" + al.get(i).getEmailId() + "</td>");
                    out.print("<td>" + al.get(i).getPassword() + "</td>");
                    out.print("<td>" + al.get(i).getUserrole() + "</td>");
                    out.print("<td>" + al.get(i).getVerificationCode() + "</td>");
                    out.print("<td>" + al.get(i).getMentoring() + "</td>");
                    out.print("<td><a href='Users.jsp?email="+al.get(i).getEmailId() +"' >EDIT</a></td></tr>");

                }
            %>
        </table>
        <form action='changes' method='post'>

            <table>
                <tr>
                    <%
                        if (request.getParameter("email") != null) {
                            Userauth alu = rh.getUserauth(request.getParameter("email").toString());
                            out.print("<tr><td><input type='text' name='fname' value='" + alu.getName() + "'></td>");
                            out.print("<td><input type='text' name='email' value='" + alu.getEmailId() + "'></td>");
                            out.print("<td><input type='text' name='pass' value='" + alu.getPassword() + "'></td>");
                            out.print("<td><input type='text' name='role' value='" + alu.getUserrole() + "'></td>");
                            out.print("<td><input type='text' name='code' value='" + alu.getVerificationCode() + "'></td>");
                            out.print("<td><input type='text' name='men' value='" + alu.getMentoring() + "'></td>");
                            out.print("<td><input type='submit' value='update'></td></tr>");
                        }
                    %>                  
                </tr>
            </table>
        </form>
    </body>
</html>
