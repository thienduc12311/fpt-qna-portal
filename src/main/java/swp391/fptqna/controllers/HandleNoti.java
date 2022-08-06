package swp391.fptqna.controllers;

import swp391.fptqna.dao.NotificationDAO;
import swp391.fptqna.dao.TagDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HandleNoti", value = "/HandleNoti")
public class HandleNoti extends HttpServlet {

    private final String ERROR_VIEW = "/errorResolve.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("back", "/home?page=1");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String href = request.getParameter("h");
            if (href==null || href.isEmpty()) href="/ManageMyQuestion?page=1";
            NotificationDAO notificationDAO = new NotificationDAO();
            if (!notificationDAO.updateState(id, false)) throw new Exception("Read noti fails");
            response.sendRedirect(href);
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
