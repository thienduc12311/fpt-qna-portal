package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.AnswerDAO;
import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.ReportedAnswerDAO;
import swp391.fptqna.dao.TagDAO;
import swp391.fptqna.dto.AnswerDTO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.ReportedAnswerDTO;
import swp391.fptqna.dto.TagDTO;

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
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            int answerId = Integer.parseInt(request.getParameter("answerId"));
            int reportedAnswerId = Integer.parseInt(request.getParameter("reportedAnswerId"));
            QuestionDAO questionDAO = new QuestionDAO();
            QuestionDTO question = questionDAO.getQuestionById(questionId);
            AnswerDAO answerDAO = new AnswerDAO();
            AnswerDTO answer = answerDAO.getAnswerById(answerId);
            ReportedAnswerDAO reportedAnswerDAO = new ReportedAnswerDAO();
            ReportedAnswerDTO reportedAnswer = reportedAnswerDAO.getReportedAnswerById(reportedAnswerId);
            TagDAO tagDAO = new TagDAO();
            ArrayList<TagDTO> listTag = tagDAO.getListTagByQuestionId(questionId);
            request.setAttribute("question", question);
            request.setAttribute("answer",answer);
            request.setAttribute("reportedAnswer", reportedAnswer);
            request.setAttribute("listTag", listTag);
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
