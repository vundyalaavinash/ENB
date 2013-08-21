<%-- 
    Document   : logout
    Created on : Aug 19, 2013, 10:55:10 AM
    Author     : B.Revanth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" session="true" %>
<%
    session.invalidate();
   response.sendRedirect("index.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ENB|ARM Technologies</title>
    </head>
    <body>
    </body>
</html>

