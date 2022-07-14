package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.NotificationDAO;
import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ResolvePendingQuestion", value = "/manage/ResolvePendingQuestion")
public class ResolvePendingQuestion extends HttpServlet {
    private final String ACCEPTED_VIEW = "../accepted.jsp";
    private final String ERROR_VIEW = "../errorResolve.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            String state = request.getParameter("state");
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            int ownerUserId = Integer.parseInt(request.getParameter("ownerUserId"));
            QuestionDAO questionDAO = new QuestionDAO();
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("USER");
            NotificationDAO notificationDAO = new NotificationDAO();
            if (state.equals("APPROVE")) {
                if (!questionDAO.approve(questionId, user.getId())) throw new Exception("Approved fail");
                if (!notificationDAO.insert(2, questionId + "|" ,ownerUserId)) throw new Exception("Approved fail");
            } else if (state.equals("REJECT")) {
                String reason = request.getParameter("reasonText");
                reason = questionId + "|" + reason;
                if (!questionDAO.deleteWithoutDB(questionId)) throw new Exception("Rejected fail");
                if (!notificationDAO.insert(1,reason,ownerUserId)) throw new Exception("Rejected fail");
            } else {
                throw new Exception("Sth fail");
            }
            request.setAttribute("back", "/MainController?action=PendingQuestion&page=1");
            request.getRequestDispatcher(ACCEPTED_VIEW).forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher(ERROR_VIEW).forward(request,response);
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
