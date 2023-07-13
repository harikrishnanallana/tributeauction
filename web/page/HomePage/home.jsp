<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--<%@ page import="io.jsonwebtoken.Claims" %>
<%@ page import="io.jsonwebtoken.Jwts" %>--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
            String message = (String) pageContext.getAttribute("message");
            if (message == null) {
                message = "heheheeh";
            }
        %>
        <t:genericpage >
            <jsp:attribute name="header">
                <h1>Welcome</h1>
            </jsp:attribute>
            <jsp:attribute name="footer">
                <p id="copyright">Copyright 1927, Future Bits When There Be Bits Inc.</p>
            </jsp:attribute>
            <jsp:attribute name="message">
                <%= message %>
            </jsp:attribute>
            <jsp:body>
                <p>Hi I'm the heart of the message</p>
            </jsp:body>
        </t:genericpage>
        <a href="LogoutAction">Logout</a>
    </body>
</html>
