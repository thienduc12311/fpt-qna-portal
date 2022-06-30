package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.ReportedAnswerDAO;
import swp391.fptqna.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResolveReportedQuestion", value = "/ResolveReportedQuestion")
public class ResolveReportedQuestion extends HttpServlet {
    private final String ACCEPTED_VIEW = "accepted.jsp";
    private final String ERROR_VIEW = "../error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            String state = request.getParameter("state");
            int reportedQuestionId = Integer.parseInt(request.getParameter("reportedQuestionId"));
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            ReportedAnswerDAO reportedAnswerDAO = new ReportedAnswerDAO();
            switch (state) {
                case "REJECT": {
                    if (!reportedAnswerDAO.delete(reportedQuestionId)) throw new Exception("Reject failed");
                    break;
                }
                case "DELETE": {
                    if (!reportedAnswerDAO.setState(reportedQuestionId, (byte) 1))
                        throw new Exception("Delete reported question failed");
                    QuestionDAO questionDAO = new QuestionDAO();
                    if (!questionDAO.delete(questionId)) {
                        reportedAnswerDAO.setState(reportedQuestionId, (byte) 0);
                        throw new Exception("Delete reported question failed");
                    }
                    break;
                }
                case "DELETE_&_BAN": {
                    if (!reportedAnswerDAO.setState(reportedQuestionId, (byte) 1))
                        throw new Exception("Delete reported question failed");
                    QuestionDAO questionDAO = new QuestionDAO();
                    if (!questionDAO.delete(questionId)) {
                        reportedAnswerDAO.setState(reportedQuestionId, (byte) 0);
                        throw new Exception("Delete reported question failed");
                    }
                    UserDAO userDAO = new UserDAO();
                    if (!userDAO.setState(userId, (byte) 0)) {
                        reportedAnswerDAO.setState(reportedQuestionId, (byte) 0);
                        throw new Exception("Delete reported question failed");
                    }
                    break;
                }
                default: {
                    throw new Exception("Sth fail");
                }
            }

            request.setAttribute("back", "/manage/reportedQuestionManagement.jsp");
            request.getRequestDispatcher("accepted.jsp").forward(request, response);
            response.sendRedirect(ACCEPTED_VIEW);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(ERROR_VIEW);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
