package swp391.fptqna.controllers;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dto.ExtendQuestionList;
import swp391.fptqna.dto.ExtendedQuestionDTO;
import swp391.fptqna.dto.QuestionDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 0;
        HttpSession session = request.getSession();
        ArrayList<QuestionDTO> questionList = null;
        ExtendQuestionList extendedQuestion = new ExtendQuestionList();
        QuestionDAO questionDAO = new QuestionDAO();
        try {
            String action = request.getParameter("action");
            System.out.println(action);
            String tag = request.getParameter("tag");
            System.out.println(tag);

            if (action == null) action = "latest";
            int numberOfPage = 0;

            //5 filter actions: latest, search, tag, most voted, most answered
            numberOfPage = questionDAO.getNumberOfAvailablePage();
            page = Integer.parseInt(request.getParameter("page"));
            switch (action){
                case "latest":
                    questionList = questionDAO.getAvailableQuestionByPage(page);
                    break;
                case "search":
                    break;
                case "tag":
                    numberOfPage = questionDAO.getNumberOfAvailablePageFilterTag(tag);
                    page = Integer.parseInt(request.getParameter("page"));
                    questionList = questionDAO.getAvailableQuestionFilterTagByPage(page, tag);
                    break;
                case "mostLiked":
                    questionList = questionDAO.getAvailableQuestionFilterMostLikedByPage(page);
                    break;
                case "mostAnswered":
                    questionList = questionDAO.getAvailableQuestionFilterMostAnsweredByPage(page);
                    break;
            }

            if (questionList.isEmpty()) {
                throw new Exception("List is empty");
            }
            for (QuestionDTO question : questionList) {
                ExtendedQuestionDTO exQuestion = new ExtendedQuestionDTO(question);
                extendedQuestion.add(exQuestion);
            }
            questionDAO.getAllTagsOfQuestion(extendedQuestion);
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("numberOfPage", numberOfPage);
            session.removeAttribute("questions");
            session.setAttribute("questions", extendedQuestion);
            request.getRequestDispatcher("home.jsp").forward(request, response);
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