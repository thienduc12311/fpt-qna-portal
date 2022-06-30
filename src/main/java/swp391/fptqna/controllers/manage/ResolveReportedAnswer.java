package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.AnswerDAO;
import swp391.fptqna.dao.ReportedAnswerDAO;
import swp391.fptqna.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResolveReportedAnswer", value = "/ResolveReportedAnswer")
public class ResolveReportedAnswer extends HttpServlet {

    private final String ACCEPTED_VIEW = "accepted.jsp";
    private final String ERROR_VIEW = "../error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            String state = request.getParameter("state");
            int reportedAnswerId = Integer.parseInt(request.getParameter("reportedAnswerId"));
            int answerId = Integer.parseInt(request.getParameter("answerId"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            ReportedAnswerDAO reportedAnswerDAO = new ReportedAnswerDAO();
            switch (state) {
                case "REJECT": {
                    if (!reportedAnswerDAO.delete(reportedAnswerId)) throw new Exception("Reject failed");
                    break;
                }
                case "DELETE": {
                    if (!reportedAnswerDAO.setState(reportedAnswerId, (byte) 1))
                        throw new Exception("Delete reported answer failed");
                    AnswerDAO answerDAO = new AnswerDAO();
                    if (!answerDAO.delete(answerId)) {
                        reportedAnswerDAO.setState(reportedAnswerId, (byte) 0);
                        throw new Exception("Delete reported answer failed");
                    }
                    break;
                }
                case "DELETE_&_BAN": {
                    if (!reportedAnswerDAO.setState(reportedAnswerId, (byte) 1))
                        throw new Exception("Delete reported answer failed");
                    AnswerDAO answerDAO = new AnswerDAO();
                    if (!answerDAO.delete(answerId)) {
                        reportedAnswerDAO.setState(reportedAnswerId, (byte) 0);
                        throw new Exception("Delete reported answer failed");
                    }
                    UserDAO userDAO = new UserDAO();
                    if (!userDAO.setState(userId, (byte) 0)) {
                        reportedAnswerDAO.setState(reportedAnswerId, (byte) 0);
                        throw new Exception("Delete reported answer failed");
                    }
                    break;
                }
                default: {
                    throw new Exception("Sth fail");
                }
            }

            request.setAttribute("back", "/manage/reportedAnswer.jsp");
            request.getRequestDispatcher("accepted.jsp").forward(request, response);
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
