package swp391.fptqna.controllers;

import io.github.cdimascio.dotenv.Dotenv;
import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.UserDTO;
import swp391.fptqna.utils.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginWithGoogle", value = "/login-google")
public class LoginWithGoogle extends HttpServlet {
    private final String HOME_VIEW = "home.jsp";
    private final String ERROR_VIEW = "error.jsp";
    private final String LOGIN_VIEW = "index.jsp";
    private final String REGISTER_VIEW = "register.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomException> validateErrors = new ArrayList<>();
        System.out.println(System.getenv("STAGE"));
        HttpSession session = request.getSession(false);
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
            request.setAttribute("ERROR", "Something went wrong, please try again later");

            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtil.getToken(code);
            GooglePojo googlePojo = GoogleUtil.getUserInfo(accessToken);
            request.setAttribute("accessToken", accessToken);
            String email  =  googlePojo.getEmail();
            String fullName = googlePojo.getName();
            String avtUrl = googlePojo.getPicture();
            String googleID = googlePojo.getId();
            UserDAO dao = new UserDAO();

            boolean valid = true;
            if (!Validator.checkEmailFPT(email)){
                log("Not using fpt mail");
                validateErrors.add(new CustomException("You must use FPT email"));
                session.setAttribute("ERROR", validateErrors);
                valid = false;
                request.getRequestDispatcher(ERROR_VIEW).forward(request,response);
                return;
            }
            try {
                UserDTO user = dao.getUser(email);
                if (state == null || state.isEmpty()) {
                    if (user == null) {
                        log("new account");
                        boolean isInserted = dao.insertUser(email, fullName, googleID, avtUrl);
                        if (!isInserted) log("added");
                        UserDTO newUser = new UserDTO( email, fullName, googleID, avtUrl, 0, 0, true, "");
                        session.setAttribute("USER", newUser);
                        response.sendRedirect(HOME_VIEW);
                    } else {
                        log("login success");
                        session.setAttribute("USER", user);
                        response.sendRedirect(HOME_VIEW);
                    }
                } else {
                    if (user == null) {
                        session.setAttribute("EMAIL", email);
                        response.sendRedirect(REGISTER_VIEW);
                    }
                    else{
                        request.setAttribute("ERROR", "Account is already registered.");
                        RequestDispatcher dis = request.getRequestDispatcher(LOGIN_VIEW);
                        dis.forward(request, response);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
//
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
