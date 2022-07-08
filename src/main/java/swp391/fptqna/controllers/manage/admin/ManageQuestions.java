package swp391.fptqna.controllers.manage.admin;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageQuestions", value = "/manage/admin/ManageQuestions")
public class ManageQuestions extends HttpServlet {
    private final String MANAGED_QUESTION_VIEW = "questionManagement.jsp";
    private final String ERROR_VIEW = "../../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int page = Integer.parseInt(request.getParameter("page"));
            QuestionDAO questionDAO = new QuestionDAO();
            ArrayList<QuestionDTO> list = questionDAO.getQuestionByPage(page) ;
            request.setAttribute("listQuestion", list);
            request.getRequestDispatcher(MANAGED_QUESTION_VIEW).forward(request,response);
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
