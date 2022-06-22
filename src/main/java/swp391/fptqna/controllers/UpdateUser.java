package swp391.fptqna.controllers;

import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateUser", value = "/UpdateUser")
public class UpdateUser extends HttpServlet {
    private final String EDIT_PROFILE_VIEW = "editprofile.jsp";
    private final String PERSONAL_PROFILE_VIEW = "personalprofile.jsp";
    private final String CHANGE_PASSWORD_VIEW = "changepassword.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String txtdisplayname = request.getParameter("txtdisplayname");
            String txtbio = request.getParameter("txtbio");
            String txtoldpassword = request.getParameter("txtoldpassword");
            String txtnewpassword = request.getParameter("txtnewpassword");
            String txtretypepassword = request.getParameter("txtretypepassword");
            String id = request.getParameter("id");
            if (txtnewpassword != null && txtretypepassword != null) {
                System.out.println("password ok");
//                || txtoldpassword.trim().equals("")
                if (txtnewpassword.trim().equals("") || txtretypepassword.trim().equals("") ) {
                    request.setAttribute("ERROR", "Do not leave form empty.");
                    System.out.println("Do not leave display name empty.");
                    request.getRequestDispatcher(CHANGE_PASSWORD_VIEW).forward(request, response);
                } else if (!txtnewpassword.trim().equals(txtretypepassword.trim())) {
                    request.setAttribute("ERROR", "Passwords don't match.");
                    System.out.println("Passwords don't match.");

                    request.getRequestDispatcher(CHANGE_PASSWORD_VIEW).forward(request, response);
                } else {
                    HttpSession session = request.getSession(false);
                    UserDTO user = (UserDTO) session.getAttribute("USER");
                    if (!txtoldpassword.equals(user.getPassword())) {
                        System.out.println("Old password is incorrect.");
                        request.setAttribute("ERROR", "Old password is incorrect.");
                        request.getRequestDispatcher(CHANGE_PASSWORD_VIEW).forward(request, response);
                    } else {
                        UserDAO dao = new UserDAO();
                        boolean result = dao.updateUser(txtdisplayname, txtnewpassword, txtbio, new Integer(id));
                        if (result){
                            user.setPassword(txtnewpassword);
                            session.setAttribute("USER", user);
                            response.sendRedirect(PERSONAL_PROFILE_VIEW);
                        }
                    }
                }
            } else {
                if (txtdisplayname.trim().equals("")) {
                    System.out.println("Do not leave display name empty.");
                    request.setAttribute("ERROR", "Do not leave display name empty.");
                    request.getRequestDispatcher(EDIT_PROFILE_VIEW).forward(request, response);
                } else {
                    UserDAO dao = new UserDAO();
                    boolean result = dao.updateUser(txtdisplayname, txtoldpassword, txtbio, new Integer(id));
                    if (result){
                        HttpSession session = request.getSession(false);
                        UserDTO user = (UserDTO) session.getAttribute("USER");
                        user.setName(txtdisplayname);
                        user.setBio(txtbio);
                        session.setAttribute("USER", user);
                        response.sendRedirect(PERSONAL_PROFILE_VIEW);
                    }
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
