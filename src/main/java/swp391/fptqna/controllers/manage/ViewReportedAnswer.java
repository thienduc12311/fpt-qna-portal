package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.*;
import swp391.fptqna.dto.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ViewReportedAnswer", value = "/manage/ViewReportedAnswer")
public class ViewReportedAnswer extends HttpServlet {
    private final String PENDING_QUESTION_VIEW = "viewReportedAnswer.jsp";
    private final String ERROR_VIEW = "../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {

            int reportedAnswerId = Integer.parseInt(request.getParameter("reportedAnswerId"));
            ReportedAnswerDAO reportedAnswerDAO = new ReportedAnswerDAO();
            ReportedAnswerDTO reportedAnswer = reportedAnswerDAO.getReportedAnswerById(reportedAnswerId);
            int answerId = reportedAnswer.getAnswerId();
            AnswerDAO answerDAO = new AnswerDAO();
            AnswerDTO answer = answerDAO.getAnswerById(answerId);
            int questionId = answer.getQuestionId();
            QuestionDAO questionDAO = new QuestionDAO();
            QuestionDTO question = questionDAO.getQuestionById(questionId);
            TagDAO tagDAO = new TagDAO();
            ArrayList<TagDTO> listTag = tagDAO.getListTagByQuestionId(questionId);
            UserDAO userDAO = new UserDAO();
            UserDTO ownerQuestionUser = userDAO.getUserById(question.getOwnerUserId());
            UserDTO ownerAnswerUser = userDAO.getUserById(answer.getOwnerUserId());
            request.setAttribute("question", question);
            request.setAttribute("answer",answer);
            request.setAttribute("reportedAnswer", reportedAnswer);
            request.setAttribute("listTag", listTag);
            request.setAttribute("ownerQuestionUser",ownerQuestionUser);
            request.setAttribute("ownerAnswerUser", ownerAnswerUser);
            request.getRequestDispatcher(PENDING_QUESTION_VIEW).forward(request,response);
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
