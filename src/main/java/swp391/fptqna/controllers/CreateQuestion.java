package swp391.fptqna.controllers;


import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.TagDAO;
import swp391.fptqna.dto.TagDTO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

@WebServlet(name = "CreateQuestion", value = "/CreateQuestion")
public class CreateQuestion extends HttpServlet {
    private final String CREATE_QUESTION_VIEW = "createQuestion.jsp";
    private final String ERROR_VIEW = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "view";
        switch (action) {
            case "view":
                getView(request, response);
                break;

            case "createQuestion":
                createQuestion(request, response);
                break;
        }

    }

    protected void getView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TagDAO tagDAO = new TagDAO();
        try {
            ArrayList<TagDTO> tags = tagDAO.getAllAvailableTag();
            request.setAttribute("tags", tags);
            request.getRequestDispatcher(CREATE_QUESTION_VIEW).forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            System.out.println(ex);
        }
    }

    protected void createQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String[] tagList = request.getParameterValues("questionTag");
        String title = request.getParameter("questionTitle");
        String content = request.getParameter("questionContent");
        UserDTO userDTO = (UserDTO) session.getAttribute("USER");
        QuestionDAO questionDAO = new QuestionDAO();
        try {
            Timestamp createdTime = Timestamp.valueOf(LocalDateTime.now());
            boolean isAdded = questionDAO.createNewQuestion(userDTO.getId(), title, content, tagList, createdTime);
            if (isAdded)
                request.setAttribute("SUCCESS", "Your question is created. Please wait for the approval of admin");
            else request.setAttribute("ERROR", "Some thing went wrong, please try again later!");
            request.getRequestDispatcher(CREATE_QUESTION_VIEW).forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
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