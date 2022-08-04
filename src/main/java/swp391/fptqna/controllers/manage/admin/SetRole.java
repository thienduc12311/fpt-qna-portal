package swp391.fptqna.controllers.manage.admin;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SetRole", value = "/manage/admin/SetRole")
public class SetRole extends HttpServlet {
    private final String ACCEPTED_VIEW = "../../successPage.jsp";
    private final String ERROR_VIEW = "../../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int userId = Integer.parseInt(request.getParameter("id"));
            byte role = Byte.parseByte(request.getParameter("role"));
            UserDAO userDAO = new UserDAO();
            if (!userDAO.setRole(userId,role))
                throw new Exception("Set Role failed");
            request.setAttribute("back", "/MainController?action=ManageUser&page=1");
            request.getRequestDispatcher(ACCEPTED_VIEW).forward(request, response);
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
