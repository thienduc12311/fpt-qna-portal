package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.*;
import swp391.fptqna.dto.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BanUser", value = "/manage/BanUser")
public class BanUser extends HttpServlet {
    private final String ERROR_VIEW = "../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            String targetUrl = request.getParameter("url");
            int userId = Integer.parseInt(request.getParameter("userId"));
            String state = request.getParameter("state");
            boolean stateChange = state.equals("Unban User");
            HttpSession session = request.getSession(false);
            UserDTO user = (UserDTO) session.getAttribute("USER");
            if (user.getRole() != 0) {
                UserDAO userDAO = new UserDAO();
                if (!userDAO.setState(userId, stateChange)) throw new Exception("Ban user fail");
            }
            request.getRequestDispatcher("../"+targetUrl).forward(request,response);
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
