package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.ReportedQuestionDAO;
import swp391.fptqna.dao.TagDAO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.ReportedQuestionDTO;
import swp391.fptqna.dto.TagDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ViewReportedQuestion", value = "/manage/ViewReportedQuestion")
public class ViewReportedQuestion extends HttpServlet {
    private final String PENDING_QUESTION_VIEW = "viewReportedQuestion.jsp";
    private final String ERROR_VIEW = "../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            int reportedQuestionId = Integer.parseInt(request.getParameter("reportedQuestionId"));
            QuestionDAO questionDAO = new QuestionDAO();
            QuestionDTO question = questionDAO.getQuestionById(questionId);
            ReportedQuestionDAO reportedQuestionDAO = new ReportedQuestionDAO();
            ReportedQuestionDTO reportedQuestion = reportedQuestionDAO.getReportedQuestionById(reportedQuestionId);
            TagDAO tagDAO = new TagDAO();
            ArrayList<TagDTO> listTag = tagDAO.getListTagByQuestionId(questionId);
            request.setAttribute("question", question);
            request.setAttribute("reportedQuestion", reportedQuestion);
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
