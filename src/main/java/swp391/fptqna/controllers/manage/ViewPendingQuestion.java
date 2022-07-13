package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.AnswerDAO;
import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.TagDAO;
import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.AnswerDTO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.TagDTO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ViewPendingQuestion", value = "/manage/ViewPendingQuestion")
public class ViewPendingQuestion extends HttpServlet {
    private final String PENDING_QUESTION_VIEW = "viewPendingQuestion.jsp";
    private final String ERROR_VIEW = "../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            QuestionDAO questionDAO = new QuestionDAO();
            QuestionDTO question = questionDAO.getQuestionById(questionId);
            UserDAO userDAO = new UserDAO();
            UserDTO ownerUser = userDAO.getUserById(question.getOwnerUserId());
            if (question.getDeletionDate() != null) throw new Exception("This question has been rejected");
            TagDAO tagDAO = new TagDAO();
            ArrayList<TagDTO> listTag = tagDAO.getListTagByQuestionId(questionId);
            request.setAttribute("question", question);
            request.setAttribute("listTag", listTag);
            request.setAttribute("ownerUser", ownerUser);
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
