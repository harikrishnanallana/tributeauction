package controller;

import dal.AdminDao;
import model.User;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginAction", urlPatterns = {"/LoginAction"})
public class LoginAction extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Kiểm tra người dùng đã đăng nhập chưa
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            // Nếu đã đăng nhập, chuyển hướng tới trang tương ứng
            if (user.getRole().equals("admin")) {
                response.sendRedirect(request.getContextPath() + "/AdminManagerAction");
            } else {
                response.sendRedirect(request.getContextPath() + "/HomeAction");
            }
        } else {
            // Chưa đăng nhập, hiển thị trang đăng nhập
            request.getRequestDispatcher("/page/LoginPage/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDao adminDao = new AdminDao();
        User user = adminDao.CheckUserLogin(username, password);

        if (user == null) {
            String error = "Incorrect information entered, please try again.";
            response.sendRedirect(request.getContextPath() + "/LoginAction?error=" + URLEncoder.encode(error, "UTF-8"));
        } else {
            // Xác thực thành công, lưu thông tin user vào session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if (user.Role.equals("admin")) {
                // Nếu người dùng có vai trò 'admin', chuyển hướng đến trang AdminManagerAction
                response.sendRedirect(request.getContextPath() + "/AdminManagerAction");
            } else {
                // Nếu người dùng không có vai trò 'admin', chuyển hướng đến trang Home
                response.sendRedirect(request.getContextPath() + "/HomeAction");
            }
        }
    }
}
