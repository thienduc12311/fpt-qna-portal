package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.AnswerDAO;
import swp391.fptqna.dao.NotificationDAO;
import swp391.fptqna.dao.ReportedAnswerDAO;
import swp391.fptqna.dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResolveReportedAnswer", value = "/manage/ResolveReportedAnswer")
public class ResolveReportedAnswer extends HttpServlet {

    private final String ACCEPTED_VIEW = "../accepted.jsp";
    private final String ERROR_VIEW = "../errorResolve.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            String state = request.getParameter("state");
            int reportedAnswerId = Integer.parseInt(request.getParameter("reportedAnswerId"));
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            int answerId = Integer.parseInt(request.getParameter("answerId"));
            int ownerFlagUserId = Integer.parseInt(request.getParameter("ownerUserId"));
            int ownerAnswerFlagUserId = Integer.parseInt(request.getParameter("ownerAnswerFlagUserId"));
            ReportedAnswerDAO reportedAnswerDAO = new ReportedAnswerDAO();
            NotificationDAO notificationDAO = new NotificationDAO();
            switch (state) {
                case "REJECT": {
                    if (!reportedAnswerDAO.setState(reportedAnswerId, (byte) 1)) throw new Exception("Reject failed");
                    if (!notificationDAO.insert(3, answerId + "|" + questionId + "|", ownerFlagUserId))
                        throw new Exception("Notification reject fail");
                    break;
                }
                case "DELETE": {
                    AnswerDAO answerDAO = new AnswerDAO();
                    if (!answerDAO.deleteWithoutDB(answerId)) {
                        throw new Exception("Delete reported answer failed");
                    }
                    if (!reportedAnswerDAO.setState(reportedAnswerId, (byte) 2))
                        throw new Exception("Delete reported answer failed");
                    String reason = request.getParameter("reasonText");
                    if (!notificationDAO.insert(4, answerId + "|" + questionId , ownerFlagUserId))
                        throw new Exception("Notification DELETE fail");
                    if (!notificationDAO.insert(5, answerId + "|" + questionId + "|" + reason, ownerAnswerFlagUserId))
                        throw new Exception("Notification DELETE fail");
                    break;
                }
                case "DELETE_BAN": {

                    AnswerDAO answerDAO = new AnswerDAO();
                    if (!answerDAO.deleteWithoutDB(answerId))
                        throw new Exception("Delete reported answer failed");
                    if (!reportedAnswerDAO.setState(reportedAnswerId, (byte) 3))
                        throw new Exception("Delete reported answer failed");
                    UserDAO userDAO = new UserDAO();
                    if (!userDAO.setState(ownerAnswerFlagUserId, false)) {
                        reportedAnswerDAO.setState(reportedAnswerId, (byte) 0);
                        throw new Exception("Delete reported answer failed");
                    }
                    if (!notificationDAO.insert(4, answerId + "|" + questionId + "|", ownerFlagUserId))
                        throw new Exception("Notification DELETE fail");
                    break;
                }
                default: {
                    throw new Exception("Sth fail");
                }
            }

            request.setAttribute("back", "/MainController?action=ReportedAnswer&page=1");
            request.getRequestDispatcher(ACCEPTED_VIEW).forward(request, response);
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
