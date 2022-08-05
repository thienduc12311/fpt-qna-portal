package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.TagDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditTag", value = "/manage/EditTag")
public class EditTag extends HttpServlet {
    private final String ACCEPTED_VIEW = "../successPage.jsp";
    private final String ERROR_VIEW = "../errorResolve.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            String tag = request.getParameter("tagName");
            String description = request.getParameter("description");
            int id = Integer.parseInt(request.getParameter("id"));
            TagDAO tagDAO = new TagDAO();
            if (!tagDAO.update(id,tag,description)) throw new Exception("Add tag failed!");
            request.setAttribute("back", "/MainController?action=Tag&page=1");
            request.getRequestDispatcher(ACCEPTED_VIEW).forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher(ERROR_VIEW).forward(request,response);
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
