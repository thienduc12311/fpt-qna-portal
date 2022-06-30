package swp391.fptqna.controllers.manage;


import swp391.fptqna.dao.TagDAO;
import swp391.fptqna.dto.TagDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Tag", value = "/manage/Tag")
public class Tag extends HttpServlet {
    private final String TAG_VIEW = "tag.jsp";
    private final String ERROR_VIEW = "../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int page = Integer.parseInt(request.getParameter("page"));
            TagDAO tagDAO = new TagDAO();
            ArrayList<TagDTO> list = tagDAO.getTagByPage(page);
            request.setAttribute("listTag", list);
            request.getRequestDispatcher(TAG_VIEW).forward(request,response);
        } catch (Exception e){
            e.printStackTrace();
            response.sendRedirect(ERROR_VIEW);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
