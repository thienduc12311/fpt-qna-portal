package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.ReportedAnswerDAO;
import swp391.fptqna.dto.ReportedAnswerDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ReportedAnswer", value = "/manage/ReportedAnswer")
public class ReportedAnswer extends HttpServlet {
    private final String REPORTED_ANSWER_VIEW = "reportedAnswerManagement.jsp";
    private final String ERROR_VIEW = "../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int page = Integer.parseInt(request.getParameter("page"));
            ReportedAnswerDAO reportedAnswerDAO = new ReportedAnswerDAO();
            ArrayList<ReportedAnswerDTO> list = reportedAnswerDAO.getReportedAnswerByPage(page);
            request.setAttribute("listReportedAnswer", list);
            request.getRequestDispatcher(REPORTED_ANSWER_VIEW).forward(request,response);
        } catch (Exception e){
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
