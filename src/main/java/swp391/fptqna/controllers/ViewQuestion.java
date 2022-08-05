package swp391.fptqna.controllers;

import swp391.fptqna.dao.AnswerDAO;
import swp391.fptqna.dao.CommentDAO;
import swp391.fptqna.dao.FlagTypeDAO;
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

@WebServlet(name = "ViewQuestion", value = "/ViewQuestion")
public class ViewQuestion extends HttpServlet {
    private final String QUESTION_VIEW = "viewQuestion.jsp";
    private final String ERROR_VIEW = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            ExtendQuestionList questionList = new ExtendQuestionList();
            QuestionDAO questionDAO = new QuestionDAO();
            questionList.add(questionDAO.getExtendQuestionById(questionId));
            questionDAO.getAllTagsOfQuestion(questionList);
            ExtendedQuestionDTO question = questionList.getQuestionById(questionId);
            if (action == null) action = "view";
            switch (action) {
                case "view":
                    viewQuestion(request, response, question);
                    break;
                case "comment":
                    addComment(request, response, question);
                    break;
                case "answer":
                    addAnswer(request, response, question);
                    break;
                case "deleteComment":
                    deleteComment(request, response, question);
                    break;
                case "deleteQuestion":
                    deleteQuestion(request, response, question);
                    break;
                case "deleteAnswer":
                    deleteAnswer(request, response, question);
                    break;
                case "editAnswer":
                    editAnswer(request, response, question);
                    break;
                case "editQuestion":
                    editQuestion(request, response, question);
                    break;
            }
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            ex.printStackTrace();
        }

    }

    private void editAnswer(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int asnwerId = Integer.parseInt(request.getParameter("typeId"));
            UserDTO user = (UserDTO) session.getAttribute("USER");
            String content = request.getParameter("content");
            AnswerDAO answerDAO = new AnswerDAO();
            boolean isSuccess = answerDAO.updateAnswer(user.getId(), asnwerId, content);
            if (isSuccess) {
                request.setAttribute("SUCCESS_MESSAGE", "Successfully");
            } else {
                request.setAttribute("ERROR_MESSAGE", "Something went wrong, please try again later!");
            }
            forwardRequest(request, response, question);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            ex.printStackTrace();
        }
    }

    private void editQuestion(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            UserDTO user = (UserDTO) session.getAttribute("USER");
            String title = request.getParameter("title");
            String body = request.getParameter("body");
            QuestionDAO questionDAO = new QuestionDAO();
            boolean isSuccess = questionDAO.updateQuestion(user.getId(), questionId, body, title);
            if (isSuccess) {
                request.setAttribute("SUCCESS_MESSAGE", "Successfully");
            } else {
                request.setAttribute("ERROR_MESSAGE", "Something went wrong, please try again later!");
            }
            response.sendRedirect("ViewQuestion?questionId=" + questionId);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            ex.printStackTrace();
        }
    }

    private void deleteComment(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            String type = request.getParameter("type");
            UserDTO user = (UserDTO) session.getAttribute("USER");

            CommentDAO commentDAO = new CommentDAO();
            boolean isSuccess = commentDAO.deleteComment(type, typeId, user.getId());
            if (isSuccess) {
                request.setAttribute("SUCCESS_MESSAGE", "Successfully");
            } else {
                request.setAttribute("ERROR_MESSAGE", "Something went wrong, please try again later!");
            }
            forwardRequest(request, response, question);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            ex.printStackTrace();
        }
    }

    private void deleteQuestion(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question) throws ServletException, IOException {
        try {
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            QuestionDAO questionDAO = new QuestionDAO();
            boolean isDeleted = questionDAO.closeQuestion(questionId);
            if (isDeleted) {
                request.setAttribute("SUCCESS_MESSAGE", "Successfully");
            } else {
                request.setAttribute("ERROR_MESSAGE", "Something went wrong, please try again later!");
            }
            response.sendRedirect("/home?page=1");
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            ex.printStackTrace();
        }
    }

    private void deleteAnswer(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question) throws ServletException, IOException {
        try {
            int answerId = Integer.parseInt(request.getParameter("answerId"));
            AnswerDAO answerDAO = new AnswerDAO();
            boolean isSuccess = answerDAO.deleteWithoutDB(answerId);
            if (isSuccess) {
                request.setAttribute("SUCCESS_MESSAGE", "Successfully");
            } else {
                request.setAttribute("ERROR_MESSAGE", "Something went wrong, please try again later!");
            }
            forwardRequest(request, response, question);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            ex.printStackTrace();
        }
    }

    private void addAnswer(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int questionId = Integer.parseInt(request.getParameter("questionId"));
            UserDTO user = (UserDTO) session.getAttribute("USER");
            String content = request.getParameter("answerContent");
            if (content == null) {
                request.setAttribute("ERROR_MESSAGE", "Content of answer must not be blank!");
            } else {
                AnswerDAO answerDAO = new AnswerDAO();
                boolean isAnswered = answerDAO.isAnswered(user.getId(), questionId);
                if (isAnswered) {
                    request.setAttribute("ERROR_MESSAGE", "You already answered this question!");
                } else {
                    boolean isSuccess = answerDAO.addNewAnswer(user.getId(), questionId, content);
                    if (isSuccess) {
                        request.setAttribute("SUCCESS_MESSAGE", "Successfully");
                    } else {
                        request.setAttribute("ERROR_MESSAGE", "Something went wrong, please try again later!");
                    }
                }

            }
            forwardRequest(request, response, question);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            System.out.println(ex);
        }
    }

    private void addComment(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int parentId = Integer.parseInt(request.getParameter("parentId"));
            UserDTO user = (UserDTO) session.getAttribute("USER");
            String type = request.getParameter("type");
            String content = request.getParameter("commentContent");
            if (content == null) {
                request.setAttribute("ERROR_MESSAGE", "Content of comment must not be blank!");
            } else {
                CommentDAO commentDAO = new CommentDAO();
                boolean isSuccess = commentDAO.createNewComment(user.getId(), parentId, content, type);
                if (isSuccess) {
                    request.setAttribute("SUCCESS_MESSAGE", "Successfully");
                } else {
                    request.setAttribute("ERROR_MESSAGE", "Something went wrong, please try again later!");
                }
            }
            forwardRequest(request, response, question);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            System.out.println(ex);
        }
    }

    private void forwardRequest(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question) throws Exception {
        question.setAnswerList(new ExtendedAnswerList());
        question.setComments(new ArrayList<CommentDTO>());
        AnswerDAO answerDAO = new AnswerDAO();
        answerDAO.getListAnswersOfQuestion(question);
        CommentDAO commentDAO = new CommentDAO();
        commentDAO.getListCommentOfQuestion(question);
        commentDAO.getListCommentOfAnswer(question);
        FlagTypeDAO flagTypeDAO = new FlagTypeDAO();
        ArrayList<FlagTypeDTO> flags = flagTypeDAO.getAllFlag();
        request.setAttribute("question", question);
        request.setAttribute("flags", flags);
        request.getRequestDispatcher(QUESTION_VIEW).forward(request, response);
    }

    private void viewQuestion(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question) throws ServletException, IOException {
        try {
            forwardRequest(request, response, question);
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