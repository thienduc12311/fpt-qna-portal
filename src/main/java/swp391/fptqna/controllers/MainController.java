package swp391.fptqna.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainController", value = "/MainController")
public class MainController extends HttpServlet {
    private final String REGISTER_CONTROLLER = "Register";
    private final String LOGIN_CONTROLLER = "Login";
    private final String PENDING_QUESTION_CONTROLLER = "/manage/PendingQuestion";
    private final String REPORTED_ANSWER_CONTROLLER = "/manage/ReportedAnswer";
    private final String REPORTED_QUESTION_CONTROLLER = "/manage/ReportedQuestion";
    private final String TAG_CONTROLLER = "/manage/Tag";
    private final String MANAGE_QUESTION_CONTROLLER = "/manage/admin/ManageQuestions";
    private final String MANAGE_USER_CONTROLLER = "/manage/admin/ManageUsers";
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
