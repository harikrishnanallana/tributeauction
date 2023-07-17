<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Manager</title>
    </head>
    <body>
        <h2>Admin Manager ${requestScope.data.size()}</h2>

        <!-- Hiển thị giao diện quản lý cho vai trò 'admin' -->
        <h1>you are admin</h1>

        <a href="./LogoutAction">Logout Page</a>


        <table border = "1px" width="60%" style="margin-left: auto; margin-right: auto;">
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>FullName</th>
                <th>Password</th>
                <th>Role</th>
                <th>Email</th> 
            </tr>
            <tr>
                <c:forEach items="${requestScope.data}" var="c">
                    <c:set var="key" value="${c.getID()}"/>
                <tr>
                    <td>${c.getID()}</td>
                    <td>${c.getUsername()}</td>
                    <td>${c.getFullName()}</td>
                    <td>${c.getPassword()}</td>
                    <td>${c.getRole()}</td>
                    <td>${c.getEmail()}</td>  
                    <td>
                        <a href="update?studentID=${key}">Update</a>
                        <a href= "#" onclick="cfDelete('${key}')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tr>
    </table>


</body>
</html>