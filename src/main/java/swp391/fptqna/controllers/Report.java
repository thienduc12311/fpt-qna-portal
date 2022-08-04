package swp391.fptqna.controllers;

import swp391.fptqna.dao.ReportedAnswerDAO;
import swp391.fptqna.dao.ReportedQuestionDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Report", value = "/Report")
public class Report extends HttpServlet {
    private final String ERROR_VIEW = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String view = request.getParameter("view");
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            String type = request.getParameter("type");
            int flagId = Integer.parseInt(request.getParameter("flagId"));
            String description = request.getParameter("description");
            UserDTO userDTO = (UserDTO) session.getAttribute("USER");
            ReportedQuestionDAO reportedQuestionDAO = new ReportedQuestionDAO();
            ReportedAnswerDAO reportedAnswerDAO = new ReportedAnswerDAO();
            boolean isSuccess = false;
            boolean isReported = false;
            if (type.equals("answer")) {
                isReported = reportedAnswerDAO.isReported(typeId, userDTO.getId());
                if (!isReported) {
                    isSuccess = reportedAnswerDAO.createReport(flagId, typeId, userDTO.getId(), description);
                }
            } else if (type.equals("question")) {
                isReported = reportedQuestionDAO.isReported(typeId, userDTO.getId());
                if (!isReported) {
                    isSuccess = reportedQuestionDAO.createReport(flagId, typeId, userDTO.getId(), description);
                }
            }
            if (isSuccess) {
                request.setAttribute("SUCCESS_MESSAGE", "Report success!");
            } else if (isReported) {
                request.setAttribute("ERROR_MESSAGE", "You already reported this " + type);
            } else {
                request.setAttribute("ERROR_MESSAGE", "Something went wrong please try again later!");
            }
            request.getRequestDispatcher(view).forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            ex.printStackTrace();
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