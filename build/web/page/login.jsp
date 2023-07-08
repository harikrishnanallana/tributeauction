<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <style>
        .error-message {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <% 
            String error = (String) request.getParameter("error");
            if (error != null && !error.isEmpty()) {
        %>
        <div class="alert alert-danger"><%= error %></div>
        <% } %>
        <form action="LoginAction" method="post">
            <div class="form-group">
                <label for="username" class="col-md-2 control-label">Username:</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-md-2 control-label">Password:</label>
                <div class="col-md-10">
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </div>
        </form>
    </div>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
