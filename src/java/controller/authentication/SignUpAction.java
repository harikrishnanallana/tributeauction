package controller.authentication;

import dal.UserDao;
import model.User;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SignUpAction", urlPatterns = {"/SignUpAction"})
public class SignUpAction extends HttpServlet {

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String fullname = request.getParameter("fullname");


    // You can perform any validation or verification logic here

    // Check if the username or email already exists in the database
    UserDao userDao = new UserDao();
    boolean usernameExists = userDao.checkUsernameExists(username);
    boolean emailExists = userDao.checkEmailExists(email);  

    if (usernameExists || emailExists) {
        // Redirect back to the sign-up page with an error message
        response.sendRedirect(request.getContextPath() + "/LoginAction?error=exists");
        return;
    }

    // Create a new user object
    User user = new User();
    user.setUsername(username);
    user.setEmail(email);
    user.setPassword(password);
    user.setFullName(fullname);

    // Save the user object in the database or perform any other necessary actions
    userDao.saveUser(user);

    response.sendRedirect(request.getContextPath() + "/LoginAction");
}
}
