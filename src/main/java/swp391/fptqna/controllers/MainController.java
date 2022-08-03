package swp391.fptqna.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainController", value = "/MainController")
public class MainController extends HttpServlet {
    private final String REGISTER_CONTROLLER = "Register";
    private final String LOGIN_CONTROLLER = "Login";
    private final String HANDLE_NOTIFICATION = "HandleNoti";

    private final String PENDING_QUESTION_CONTROLLER = "/manage/PendingQuestion";
    private final String REPORTED_ANSWER_CONTROLLER = "/manage/ReportedAnswer";
    private final String REPORTED_QUESTION_CONTROLLER = "/manage/ReportedQuestion";
    private final String TAG_CONTROLLER = "/manage/Tag";
    private final String ADD_TAG_CONTROLLER = "/manage/AddTag";
    private final String EDIT_TAG_CONTROLLER = "/manage/EditTag";
    private final String VIEW_PENDING_QUESTION_CONTROLLER = "/manage/ViewPendingQuestion";
    private final String VIEW_REPORTED_QUESTION_CONTROLLER = "/manage/ViewReportedQuestion";
    private final String VIEW_REPORTED_ANSWER_CONTROLLER = "/manage/ViewReportedAnswer";
    private final String RESOLVE_PENDING_QUESTION_CONTROLLER = "/manage/ResolvePendingQuestion";
    private final String RESOLVE_REPORTED_QUESTION_CONTROLLER = "/manage/ResolveReportedQuestion";
    private final String RESOLVE_REPORTED_ANSWER_CONTROLLER = "/manage/ResolveReportedAnswer";
    private final String BAN_OR_UNBAN_USER = "/manage/BanUser";
    private final String MANAGE_QUESTION_CONTROLLER = "/manage/admin/ManageQuestions";
    private final String UNDELETE_QUESTION_CONTROLLER = "/manage/admin/UnDeleteQuestion";

    private final String MANAGE_USER_CONTROLLER = "/manage/admin/ManageUsers";
    private final String DELETE_QUESTION_CONTROLLER = "DeleteQuestion";
    private final String LOGIN_VIEW = "index.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String action = request.getParameter("action");
            String url = LOGIN_VIEW;
            switch(action){
                case "Register":
                    url = REGISTER_CONTROLLER;
                    break;
                case "Login":
                    url = LOGIN_CONTROLLER;
                    break;
                case "PendingQuestion":
                    url = PENDING_QUESTION_CONTROLLER;
                    break;
                case "ReportedAnswer":
                    url = REPORTED_ANSWER_CONTROLLER;
                    break;
                case "ReportedQuestion":
                    url = REPORTED_QUESTION_CONTROLLER;
                    break;
                case "Tag":
                    url = TAG_CONTROLLER;
                    break;
                case "ManageUser":
                    url = MANAGE_USER_CONTROLLER;
                    break;
                case "ManageQuestion":
                    url = MANAGE_QUESTION_CONTROLLER;
                    break;
                case "ViewPendingQuestion":
                    url = VIEW_PENDING_QUESTION_CONTROLLER;
                    break;
                case "ViewReportedQuestion":
                    url = VIEW_REPORTED_QUESTION_CONTROLLER;
                    break;
                case "ViewReportedAnswer":
                    url = VIEW_REPORTED_ANSWER_CONTROLLER;
                    break;
                case "ResolvePendingQuestion":
                    url = RESOLVE_PENDING_QUESTION_CONTROLLER;
                    break;
                case "ResolveReportedQuestion":
                    url = RESOLVE_REPORTED_QUESTION_CONTROLLER;
                    break;
                case "ResolveReportedAnswer":
                    url = RESOLVE_REPORTED_ANSWER_CONTROLLER;
                    break;
                case "BanOrUnBanUser":
                    url = BAN_OR_UNBAN_USER;
                    break;
                case "DeleteQuestion":
                    url = DELETE_QUESTION_CONTROLLER;
                    break;
                case "UnDeleteQuestion":
                    url = UNDELETE_QUESTION_CONTROLLER;
                    break;
                case "AddTag":
                    url = ADD_TAG_CONTROLLER;
                    break;
                case "EditTag":
                    url = EDIT_TAG_CONTROLLER;
                    break;
                case "HandleNoti":
                    url = HANDLE_NOTIFICATION;
                    break;
            }
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e){
            e.printStackTrace();
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
