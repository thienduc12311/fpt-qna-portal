package swp391.fptqna.controllers;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 0;
        ArrayList<QuestionDTO> questionList = null;
        QuestionDAO questionDAO = new QuestionDAO();
        try {
           page   = Integer.parseInt(request.getParameter("page"));
           int numberOfPage = questionDAO.getNumberOfPage();
           questionList = questionDAO.getAvailableQuestionByPage(page);
            if (questionList.isEmpty()) {
                throw new Exception("List is empty");
            }
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("numberOfPage", numberOfPage);
            request.setAttribute("questions", questionList);
            request.getRequestDispatcher("home.jsp").forward(request,response);
        } catch (Exception ex){
            response.sendRedirect("error.jsp");
            System.out.println(ex);
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
