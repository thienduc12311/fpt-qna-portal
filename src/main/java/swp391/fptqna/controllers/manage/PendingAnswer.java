package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.AnswerDAO;
import swp391.fptqna.dto.AnswerDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PendingAnswer", value = "/manage/PendingAnswer")
public class PendingAnswer extends HttpServlet {
    private final String PENDING_ANSWER_VIEW = "pendingAnswer.jsp";
    private final String ERROR_VIEW = "../error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int page = Integer.parseInt(request.getParameter("page"));
            AnswerDAO answerDAO = new AnswerDAO();
            ArrayList<AnswerDTO> list = answerDAO.getPendingAnswerByPage(page);
            request.setAttribute("listPendingAnswer", list);
            request.getRequestDispatcher(PENDING_ANSWER_VIEW).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(ERROR_VIEW);
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
