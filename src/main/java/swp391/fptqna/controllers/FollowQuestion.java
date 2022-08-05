package swp391.fptqna.controllers;

import swp391.fptqna.dao.NotificationDAO;
import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.QuestionFollowDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FollowQuestion", value = "/FollowQuestion")
public class FollowQuestion extends HttpServlet {
    private final String ACCEPTED_VIEW = "./successPage.jsp";
    private final String ERROR_VIEW = "./errorResolve.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            request.setAttribute("back", "ViewQuestion?questionId="+questionId);
            HttpSession session = request.getSession(false);
            UserDTO user = (UserDTO) session.getAttribute("USER");
            QuestionFollowDAO questionFollowDAO = new QuestionFollowDAO();
            if (!questionFollowDAO.insert(questionId,user.getId())) throw new Exception("Follow Error");
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
