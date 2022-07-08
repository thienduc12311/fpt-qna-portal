package swp391.fptqna.controllers.manage.admin;

import swp391.fptqna.dao.ReportedAnswerDAO;
import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.ReportedAnswerDTO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageUsers", value = "/manage/admin/ManageUsers")
public class ManageUsers extends HttpServlet {
    private final String MANAGED_USER_VIEW = "/manage/admin/userManagement.jsp";
    private final String ERROR_VIEW = "../../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int page = Integer.parseInt(request.getParameter("page"));
            UserDAO userDAO = new UserDAO();
            ArrayList<UserDTO> list = userDAO.getUserByPage(page);
            request.setAttribute("listUser", list);
            request.getRequestDispatcher(MANAGED_USER_VIEW).forward(request,response);
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
