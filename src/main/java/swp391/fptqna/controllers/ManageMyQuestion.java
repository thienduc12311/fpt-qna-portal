package swp391.fptqna.controllers;

import swp391.fptqna.dao.NotificationDAO;
import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dto.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageMyQuestion", value = "/ManageMyQuestion")
public class ManageMyQuestion extends HttpServlet {
    private final String MANAGE_VIEW = "manageMyQuestion.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            String page = request.getParameter("page");
            if (page == null) page = "1";
            int currentPage = Integer.parseInt(page);
            UserDTO userDTO = (UserDTO) session.getAttribute("USER");
            QuestionDAO questionDAO = new QuestionDAO();
            NotificationDAO notificationDAO = new NotificationDAO();
            ArrayList<NotificationDTO> notifications = notificationDAO.getNotiByUserAndType(userDTO.getId(), 1);
            ArrayList<ReasonRejectDTO> reasonReject = new ArrayList<>();
            ExtendQuestionList extendQuestionList = new ExtendQuestionList();

            int numberOfQuestion = questionDAO.numberOfQuestionByUser(userDTO.getId());
            ArrayList<QuestionDTO> questionList = questionDAO.getAllQuestionOfUser(userDTO.getId(), currentPage);
            for (QuestionDTO question : questionList) {
                ExtendedQuestionDTO extendedQuestionDTO = new ExtendedQuestionDTO(question);
                extendQuestionList.add(extendedQuestionDTO);
            }
            for (NotificationDTO noti : notifications) {
                String body = noti.getBody();
                int questionId = Integer.parseInt(body.substring(0, body.lastIndexOf("|")));
                String content = body.substring(body.lastIndexOf("|") + 1);
                ReasonRejectDTO rejectDTO = new ReasonRejectDTO(questionId, content);
                if (extendQuestionList.getQuestionById(questionId) != null) {
                    extendQuestionList.getQuestionById(questionId).setReject(rejectDTO);
                }
            }
            request.setAttribute("numberOfPage", numberOfQuestion);
            request.setAttribute("reasonReject", reasonReject);
            request.setAttribute("questionList", extendQuestionList);
            request.getRequestDispatcher(MANAGE_VIEW).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp");
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