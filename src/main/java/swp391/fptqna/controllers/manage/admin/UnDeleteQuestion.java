package swp391.fptqna.controllers.manage.admin;

import swp391.fptqna.dao.NotificationDAO;
import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UnDeleteQuestion", value = "/manage/admin/UnDeleteQuestion")
public class UnDeleteQuestion extends HttpServlet {

    private final String ACCEPTED_VIEW = "../../successPage.jsp";
    private final String ERROR_VIEW = "../../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            HttpSession session = request.getSession(false);
            UserDTO user = (UserDTO) session.getAttribute("USER");
            if (user.getRole() != 2)
                throw new Exception("UnDelete question failed");
            QuestionDAO questionDAO = new QuestionDAO();
            if (!questionDAO.undelete(questionId))
                throw new Exception("Delete question failed");
            request.setAttribute("back", "/MainController?action=ManageQuestion&page=1");
            request.getRequestDispatcher(ACCEPTED_VIEW).forward(request, response);
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
