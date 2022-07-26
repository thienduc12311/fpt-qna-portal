package swp391.fptqna.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Vote", value = "/Vote")
public class Vote extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            String action = request.getParameter("action");
//            int questionId = Integer.parseInt(request.getParameter("questionId"));
//            ExtendQuestionList questionList = new ExtendQuestionList();
//            QuestionDAO questionDAO = new QuestionDAO();
//            questionList.add(questionDAO.getExtendQuestionById(questionId));
//            questionDAO.getAllTagsOfQuestion(questionList);
//            ExtendedQuestionDTO question = questionList.getQuestionById(questionId);
//            if (action == null) action = "view";
//            switch (action) {
//                case "view":
//                    viewQuestion(request, response, question);
//                    break;
//                case "comment":
//                    addComment(request, response, question);
//                    break;
//                case "answer":
//                    addAnswer(request, response, question);
//                    break;
//            }
//        } catch (Exception ex) {
//            response.sendRedirect(ERROR_VIEW);
//            System.out.println(ex);
//        }

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