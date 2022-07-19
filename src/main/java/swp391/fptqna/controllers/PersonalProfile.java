package swp391.fptqna.controllers;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dto.ExtendQuestionList;
import swp391.fptqna.dto.ExtendedQuestionDTO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PersonalProfile", value = "/PersonalProfile")
public class PersonalProfile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 0;
        HttpSession session = request.getSession(false);
        System.out.println(session);
        UserDTO user = (UserDTO)session.getAttribute("USER") ;
        System.out.println(user);
        System.out.println(user.getId()); //=0
        ArrayList<QuestionDTO> questionList = null;
        ExtendQuestionList extendedQuestion = new ExtendQuestionList();
        QuestionDAO questionDAO = new QuestionDAO();
        try {
            int numberOfPage = 0;
            numberOfPage = questionDAO.getNumberOfAvailablePageFilterUserId(user.getId());
            page = Integer.parseInt(request.getParameter("page"));

            System.out.println(page); //=1
            questionList = questionDAO.getAvailableQuestionFilterUserIdByPage(page, user.getId());


            if (questionList.isEmpty()) {
                request.setAttribute("emptyList", "You have not asked any question.");
                //throw new Exception("List is empty");
            }
            for (QuestionDTO question : questionList) {
                ExtendedQuestionDTO exQuestion = new ExtendedQuestionDTO(question);
                extendedQuestion.add(exQuestion);
                System.out.println(exQuestion);
            }
            questionDAO.getAllTagsOfQuestion(extendedQuestion);
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("numberOfPage", numberOfPage);
            session.removeAttribute("questions");
            session.setAttribute("questions", extendedQuestion);
            request.getRequestDispatcher("personalprofile.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
            System.out.println(ex);
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
