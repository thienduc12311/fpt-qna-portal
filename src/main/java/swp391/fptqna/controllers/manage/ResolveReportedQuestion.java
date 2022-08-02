package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResolveReportedQuestion", value = "/manage/ResolveReportedQuestion")
public class ResolveReportedQuestion extends HttpServlet {
    private final String ACCEPTED_VIEW = "../successPage.jsp";
    private final String ERROR_VIEW = "../errorResolve.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            String state = request.getParameter("state");
            String emailTo = request.getParameter("emailTo");
            int reportedQuestionId = Integer.parseInt(request.getParameter("reportedQuestionId"));
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            int ownerFlagUserId = Integer.parseInt(request.getParameter("ownerUserId"));
            int ownerQuestionFlagUserId = Integer.parseInt(request.getParameter("ownerQuestionFlagUserId"));
            ReportedQuestionDAO reportedQuestionDAO = new ReportedQuestionDAO();
            NotificationDAO notificationDAO = new NotificationDAO();
            switch (state) {
                case "REJECT": {
                    if (!reportedQuestionDAO.setState(reportedQuestionId, (byte) 1))
                        throw new Exception("Reject failed");
                    if (!notificationDAO.insert(6, questionId + "|", ownerFlagUserId))
                        throw new Exception("Notification reject fail");
                    break;
                }
                case "DELETE": {
                    QuestionDAO questionDAO = new QuestionDAO();
                    if (!questionDAO.deleteWithoutDB(questionId))
                        throw new Exception("Delete reported question failed");
                    if (!reportedQuestionDAO.setState(reportedQuestionId, (byte) 2))
                        throw new Exception("Delete reported question failed");
                    String reason = request.getParameter("reasonText");
                    reason = questionId + "|" + reason;
                    if (!notificationDAO.insert(7, reason, ownerFlagUserId))
                        throw new Exception("Notification DELETE fail");
                    if (!notificationDAO.insert(8, reason, ownerQuestionFlagUserId))
                        throw new Exception("Notification DELETE fail");
                    break;
                }
                case "DELETE_BAN": {

                    QuestionDAO questionDAO = new QuestionDAO();
                    if (!questionDAO.deleteWithoutDB(questionId))
                        throw new Exception("Delete reported question failed");
                    if (!reportedQuestionDAO.setState(reportedQuestionId, (byte) 3))
                        throw new Exception("Delete reported question failed");
                    UserDAO userDAO = new UserDAO();
                    if (!userDAO.setState(ownerQuestionFlagUserId, false)) {
                        reportedQuestionDAO.setState(reportedQuestionId, (byte) 0);
                        throw new Exception("Delete reported question failed");
                    }

                    request.setAttribute("emailTo",emailTo);
                    request.setAttribute("reason","Your account have been banned!!");
                    request.getRequestDispatcher("/SendEmail").include(request,response);
                    if (!notificationDAO.insert(7, questionId + "|", ownerFlagUserId))
                        throw new Exception("Notification DELETE fail");
                    break;
                }
                default: {
                    throw new Exception("Sth fail");
                }
            }

            request.setAttribute("back", "/MainController?action=ReportedQuestion&page=1");
            request.getRequestDispatcher(ACCEPTED_VIEW).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher(ERROR_VIEW).forward(request,response);
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
