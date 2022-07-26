package swp391.fptqna.controllers;

import swp391.fptqna.dao.VoteDAO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Vote", value = "/Vote")
public class Vote extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "upVote":
                    upVote(request, response);
                    break;

                case "downVote":
                    downVote(request, response);
                    break;
            }
        } catch (Exception ex) {
            response.sendRedirect("error.jsp");
            ex.printStackTrace();
        }
    }

    private void upVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("USER");
        String type = request.getParameter("type");
        System.out.println(user.getId());
        String currentView = request.getParameter("currentView");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        VoteDAO voteDAO = new VoteDAO();
        int state = voteDAO.getVoteState(user.getId(), typeId, type);
        switch (state) {
            case 0:
                voteDAO.unVote(user.getId(), typeId, type);
                break;
            case 1:
                request.setAttribute("SUCCESS_MESSAGE", "You already up vote this " + type);
                break;
            case 2:
                voteDAO.vote(user.getId(), typeId, type, 1);
                break;
        }
        if (request.getAttribute("SUCCESS_MESSAGE") == null) {
            request.setAttribute("SUCCESS_MESSAGE", "Successfully");
        }
        System.out.println(currentView);
        response.sendRedirect(currentView);
    }

    private void downVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO user = (UserDTO) session.getAttribute("USER");
        String type = request.getParameter("type");
        String currentView = request.getParameter("currentView");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        VoteDAO voteDAO = new VoteDAO();
        int state = voteDAO.getVoteState(user.getId(), typeId, type);
        switch (state) {
            case 1:
                voteDAO.unVote(user.getId(), typeId, type);
                break;
            case 0:
                request.setAttribute("SUCCESS_MESSAGE", "You already down vote this " + type);
                break;
            case 2:
                voteDAO.vote(user.getId(), typeId, type, 0);
                break;
        }
        if (request.getAttribute("SUCCESS_MESSAGE") == null) {
            request.setAttribute("SUCCESS_MESSAGE", "Successfully");
        }
        response.sendRedirect(currentView);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        processRequest(request, response);
    }
}