package swp391.fptqna.controllers;

import swp391.fptqna.dao.QuestionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteWithCloseDate", value = "/DeleteWithCloseDate")
public class DeleteWithCloseDate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            QuestionDAO questionDAO = new QuestionDAO();
            boolean isDeleted = questionDAO.closeQuestion(questionId);
            if (isDeleted) {
                request.setAttribute("SUCCESS_MESSAGE", "Successfully");
            } else {
                request.setAttribute("ERROR_MESSAGE", "Something went wrong, please try again later!");
            }
            response.sendRedirect("/ManageMyQuestion?page=1");
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}