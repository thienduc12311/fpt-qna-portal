package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ResolvePendingQuestion", value = "/manage/ResolvePendingQuestion")
public class ResolvePendingQuestion extends HttpServlet {
    private final String ACCEPTED_VIEW = "accepted.jsp";
    private final String ERROR_VIEW = "../error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            String state = request.getParameter("state");
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            QuestionDAO questionDAO = new QuestionDAO();
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("USER");
            if (state.equals("APPROVE")) {
                if (!questionDAO.approve(questionId, user.getId())) throw new Exception("Approved fail");
            } else if (state.equals("REJECT")) {
                if (!questionDAO.delete(questionId)) throw new Exception("Rejected fail");
            } else {
                throw new Exception("Sth fail");
            }
            request.setAttribute("back", "/manage/pendingQuestion.jsp");
            request.getRequestDispatcher("accepted.jsp").forward(request,response);
            response.sendRedirect(ACCEPTED_VIEW);
        } catch (Exception e) {
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
