<%-- 
    Document   : login
    Created on : Jul 6, 2023, 6:20:31 AM
    Author     : nkhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> welcome page</title>
    </head>
   <body>
    <% 
        String ms = (String) request.getParameter("message");
        if (ms != null) {
    %>
    <h3 name="error" style="color: red"><%= ms %></h3>
    <% } %>
       welcome page
    </body>
</html>
