package swp391.fptqna.controllers.manage.admin;

import com.microsoft.sqlserver.jdbc.StringUtils;
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
            String search = request.getParameter("search");
            QuestionDAO questionDAO = new QuestionDAO();
            int numberOfPage = questionDAO.getNumberOfPage();
            if (search == null || search.equals("")) {
                ArrayList<QuestionDTO> list = questionDAO.getQuestionByPage(page) ;
                request.setAttribute("listQuestion", list);
            } else {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                if (StringUtils.isNumeric(search)) {
                    list.add(questionDAO.getQuestionById(Integer.parseInt(search)));
                }
                numberOfPage = 1;
                request.setAttribute("listQuestion", list);
            }
            request.setAttribute("numberOfPage", numberOfPage);

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
