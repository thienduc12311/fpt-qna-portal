package swp391.fptqna.controllers;

import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")

public class Register extends HttpServlet {
    private final String REGISTER_VIEW = "register.jsp";
    private final String LOGIN_VIEW = "index.jsp";
    private final String HOME_VIEW = "home.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String txtdisplayname = request.getParameter("txtdisplayname");
            String txtpassword = request.getParameter("txtpassword");
            String txtpasswordconfirm = request.getParameter("txtpasswordconfirm");
            if (txtdisplayname.trim().equals("") || txtpassword.trim().equals("") || txtpasswordconfirm.trim().equals("")){
                request.setAttribute("ERROR", "Do not leave form empty.");
                request.getRequestDispatcher(REGISTER_VIEW).forward(request, response);
            }
            else if (!txtpassword.equals(txtpasswordconfirm)){
                request.setAttribute("ERROR", "Password do not match.");
                request.getRequestDispatcher(REGISTER_VIEW).forward(request, response);
            } else {
                HttpSession session = request.getSession(false);
                String email = (String) session.getAttribute("EMAIL");
                UserDAO dao = new UserDAO();
                UserDTO user = dao.getUser(email);
                if (user == null) {
                    boolean isInserted = dao.registerUser(email, txtdisplayname, txtpassword);
                    if (isInserted) {
                        UserDTO newUser = new UserDTO(email, txtdisplayname, txtpassword, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460__340.png", 0, 0, true, "");
                        session.setAttribute("USER", newUser);
                        response.sendRedirect(HOME_VIEW);
                    } else
                        response.sendRedirect(LOGIN_VIEW);
                } else
                    response.sendRedirect(LOGIN_VIEW);
            }
        } catch (Exception e){
            e.printStackTrace();
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
