package swp391.fptqna.controllers.manage;

import swp391.fptqna.dao.FlagTypeDAO;
import swp391.fptqna.dao.ReportedQuestionDAO;
import swp391.fptqna.dto.FlagTypeDTO;
import swp391.fptqna.dto.ReportedQuestionDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "ReportedQuetion", value = "/manage/ReportedQuestion")
public class ReportedQuestion extends HttpServlet {
    private final String REPORTED_QUESTION_VIEW = "reportedQuestionManagement.jsp";
    private final String ERROR_VIEW = "../error.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            int page = Integer.parseInt(request.getParameter("page"));
            ReportedQuestionDAO reportedQuestionDAO = new ReportedQuestionDAO();
            int numberOfPage = reportedQuestionDAO.getNumberOfPage();
            request.setAttribute("numberOfPage", numberOfPage);
            ArrayList<ReportedQuestionDTO> list = reportedQuestionDAO.getReportedQuestionByPage(page);
            FlagTypeDAO flagTypeDAO = new FlagTypeDAO();
            HashMap<Integer, FlagTypeDTO> listFlagType = flagTypeDAO.getAll();
            request.setAttribute("listFlagType", listFlagType);
            request.setAttribute("listReportedQuestion", list);
            request.getRequestDispatcher(REPORTED_QUESTION_VIEW).forward(request,response);
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
