package swp391.fptqna.controllers;

import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    private final String LOGIN_VIEW = "index.jsp";
    private final String HOME_VIEW = "home.jsp";

    private final String ERROR_VIEW = "error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            String txtemail = request.getParameter("txtemail");
            String txtpassword = request.getParameter("txtpassword");

            if (txtemail.trim().equals("") || txtpassword.trim().equals("")){
                request.setAttribute("ERROR", "Do not leave form empty.");
                request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
            } else {
                UserDAO dao = new UserDAO();
                UserDTO user = dao.checkLogin(txtemail, txtpassword);
                if (user == null) {
                    request.setAttribute("ERROR", "Invalid email or password.");
                    request.getRequestDispatcher(LOGIN_VIEW).forward(request, response);
                } else{
                    HttpSession session = request.getSession();
                    session.setAttribute("USER", user);
                    response.sendRedirect(HOME_VIEW);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            response.sendRedirect(ERROR_VIEW);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
}
