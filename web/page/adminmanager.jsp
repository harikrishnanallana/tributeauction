<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Manager</title>
</head>
<body>
    <h2>Admin Manager</h2>
    <% 
        String message = (String) request.getAttribute("message");
        
        
        if (message != null && !message.isEmpty()) {
    %>
    <h3><%= message %></h3>
    <% } %>
    <!-- Hiển thị giao diện quản lý cho vai trò 'admin' -->
    <h1>you are admin</h1>
    
    <a href="./LogoutAction">Logout Page</a>
</body>
</html>