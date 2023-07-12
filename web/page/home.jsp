<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="io.jsonwebtoken.Claims" %>
<%@ page import="io.jsonwebtoken.Jwts" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h2>Welcome Page</h2>
    <%  
        String message = (String) request.getAttribute("message");
        if (message != null && !message.isEmpty()) {
    %>
    <h3><%= message %></h3>
    <% } else { %>
    <h3>You are not logged in.</h3>
    <% } %>
    
    
    <%
    String jwt = (String) request.getAttribute("jwt"); // Nhận JWT từ servlet
    
    // Xác thực và giải mã JWT
    Claims claims = Jwts.parser()
            .setSigningKey(SECRET_KEY.getBytes())
            .parseClaimsJws(jwt)
            .getBody();

    // Trích xuất thông tin từ JWT
    String username = claims.getSubject();
%>
    <h1>Welcome, <%= username %></h1>
    
    <a href="LogoutAction">Logout</a>
</body>
</html>
