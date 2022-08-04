package swp391.fptqna.controllers;

import swp391.fptqna.dao.*;
import swp391.fptqna.dto.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
            String resource = "";
            if (question.getTitle().contains("Semester "))
                resource = "resource";
            if (action == null) action = "view";
            switch (action) {
                case "view":
                    viewQuestion(request, response, question, resource);
                    break;
                case "comment":
                    addComment(request, response, question, resource);
                    break;
                case "answer":
                    addAnswer(request, response, question, resource);
                    break;
            }
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            System.out.println(ex);
        }

    }

    private void addAnswer(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question, String resource) throws ServletException, IOException {
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
                        QuestionDAO qDAO = new QuestionDAO();
                        QuestionDTO q = qDAO.getQuestionById(questionId);
                        NotificationDAO notificationDAO = new NotificationDAO();
                        if (user.getId() != q.getOwnerUserId()) {
                            if (!notificationDAO.insert(10, questionId + "|", q.getOwnerUserId()))
                                throw new Exception("Notification fail");
                        }
                        QuestionFollowDAO followDAO = new QuestionFollowDAO();
                        ArrayList<Integer> listFollwer = followDAO.getFollower(questionId);
                        for (int tmp: listFollwer) {
                            if (user.getId() != tmp) {
                                if (!notificationDAO.insert(11, questionId + "|", tmp))
                                    throw new Exception("Notification fail");
                            }
                        }
                    } else {
                        request.setAttribute("ERROR_MESSAGE", "Something went wrong, please try again later!");
                    }
                }

            }
            forwardRequest(request, response, question, resource);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            System.out.println(ex);
        }
    }

    private void addComment(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question, String resource) throws ServletException, IOException {
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
            forwardRequest(request, response, question, resource);
        } catch (Exception ex) {
            response.sendRedirect(ERROR_VIEW);
            System.out.println(ex);
        }
    }

    String wrapWithQuotesAndJoin(List<String> strings) {
        return strings.stream()
                .collect(Collectors.joining("\", \"", "\"", "\""));
    }
    private void forwardRequest(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question, String resource) throws Exception {
        question.setAnswerList(new ExtendedAnswerList());
        question.setComments(new ArrayList<CommentDTO>());
        AnswerDAO answerDAO = new AnswerDAO();
        answerDAO.getListAnswersOfQuestion(question);
        CommentDAO commentDAO = new CommentDAO();
        commentDAO.getListCommentOfQuestion(question);
        commentDAO.getListCommentOfAnswer(question);
        FlagTypeDAO flagTypeDAO = new FlagTypeDAO();
        ArrayList<FlagTypeDTO> flags = flagTypeDAO.getAllFlag();
        String[] answerCountByDate1 = answerDAO.getAnswerCountByCalenderDate(question).keySet().toArray(new String[answerDAO.getAnswerCountByCalenderDate(question).keySet().size()]);
        String[] topAnswerScore1 = answerDAO.getTopAnswerScoreFilterQuestionId(question).keySet().toArray(new String[answerDAO.getTopAnswerScoreFilterQuestionId(question).keySet().size()]);
        request.setAttribute("answerCountByDate", answerDAO.getAnswerCountByCalenderDate(question));
        request.setAttribute("topAnswerScore", answerDAO.getTopAnswerScoreFilterQuestionId(question));
        request.setAttribute("answerCountByDate1", wrapWithQuotesAndJoin(Arrays.asList(answerCountByDate1)));
        request.setAttribute("topAnswerScore1", wrapWithQuotesAndJoin(Arrays.asList(topAnswerScore1)));
        //System.out.println(answerDAO.getTopAnswerScoreFilterQuestionId(question));
        //System.out.println(wrapWithQuotesAndJoin(Arrays.asList(tmp)));

        request.setAttribute("resource", resource);
        request.setAttribute("question", question);
        request.setAttribute("flags", flags);
        request.getRequestDispatcher(QUESTION_VIEW).forward(request, response);
    }

    private void viewQuestion(HttpServletRequest request, HttpServletResponse response, ExtendedQuestionDTO question, String resource) throws ServletException, IOException {
        try {
            forwardRequest(request, response, question, resource);
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