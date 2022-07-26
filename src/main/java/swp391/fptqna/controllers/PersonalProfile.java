package swp391.fptqna.controllers;

import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.UserDAO;
import swp391.fptqna.dto.ExtendQuestionList;
import swp391.fptqna.dto.ExtendedQuestionDTO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@WebServlet(name = "PersonalProfile", value = "/PersonalProfile")
public class PersonalProfile extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int page = 0;
        HttpSession session = request.getSession(false);
        UserDTO user = (UserDTO) session.getAttribute("USER");
        String userid = request.getParameter("userid");
        System.out.println(userid);
        UserDAO userDAO = new UserDAO();
        if (userid != null) {
            user = userDAO.getUserById(Integer.parseInt(userid));
        }
        ArrayList<QuestionDTO> questionList = null;
        ExtendQuestionList extendedQuestion = new ExtendQuestionList();
        QuestionDAO questionDAO = new QuestionDAO();
        try {
            int numberOfPage = 0;
            int numberofAnswers = 0;
            int numberofQuestions = 0;
            numberOfPage = questionDAO.getNumberOfAvailablePageFilterUserId(user.getId());
            numberofAnswers = userDAO.countUserAnswers(user.getId());
            numberofQuestions = userDAO.countUserQuestions(user.getId());
            page = Integer.parseInt(request.getParameter("page"));
            questionList = questionDAO.getAvailableQuestionFilterUserIdByPage(page, user.getId());

            if (questionList.isEmpty()) {
                request.setAttribute("emptyList", user.getName() + " has not asked any question.");
                //throw new Exception("List is empty");
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
            request.setAttribute("userProfile", user);
            if (userid != null) {
                request.setAttribute("numberofAnswers", numberofAnswers);
                request.setAttribute("numberofQuestions", numberofQuestions);
                request.getRequestDispatcher("otherProfile.jsp").forward(request, response);
            } else {
                session.setAttribute("numberofAnswers", numberofAnswers);
                session.setAttribute("numberofQuestions", numberofQuestions);
                request.getRequestDispatcher("personalprofile.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
            System.out.println(ex);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}