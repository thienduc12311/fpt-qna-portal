package swp391.fptqna.controllers;

import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.UserDTO;
import swp391.fptqna.utils.DButil;
import swp391.fptqna.utils.GooglePojo;
import swp391.fptqna.utils.GoogleUtil;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginWithGoogle", value = "/login-google")
public class LoginWithGoogle extends HttpServlet {
    private final String HOME_VIEW = "index.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtil.getToken(code);
            GooglePojo googlePojo = GoogleUtil.getUserInfo(accessToken);
            request.setAttribute("accessToken", accessToken);
            System.out.println(googlePojo.getEmail());
//
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
