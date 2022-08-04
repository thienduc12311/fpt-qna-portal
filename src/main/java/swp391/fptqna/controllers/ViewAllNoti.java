package swp391.fptqna.controllers;

import swp391.fptqna.dao.NotificationDAO;
import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dao.TagDAO;
import swp391.fptqna.dto.NotificationViewDTO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ViewAllNoti", value = "/ViewAllNoti")
public class ViewAllNoti extends HttpServlet {
    private final String VIEW_ALL = "allNotifications.jsp";
    private final String ERROR_VIEW = "../error.jsp";

    private void buildHref(ArrayList<NotificationViewDTO> listNoti){
        try{
            for (NotificationViewDTO noti: listNoti) {
                String[] body = noti.getNoti().getBody().split("\\|");
                String content = noti.getContent();
                for (String ele: body){
                    content = content.replaceFirst("\\$\\{}", ele);
                }
                noti.setContent(content);
                int type = noti.getNoti().getNotificationTypeId();
                if ( type == 3 ){
                    String href = "/ViewQuestion?questionId=" + body[1];
                    QuestionDAO questionDAO = new QuestionDAO();
                    QuestionDTO question = questionDAO.getQuestionById(Integer.parseInt(body[1]));
                    String title = question.getTitle().length() > 40 ? question.getTitle().substring(0,40) : question.getTitle();
                    content = content.replace(body[1], '"' +  title + "..." + '"');
                    noti.setContent(content);
                    noti.setHref(href);
                } else if(type == 2 || type == 6 || type == 10 ) {
                    String href = "/ViewQuestion?questionId=" + body[0];
                    QuestionDAO questionDAO = new QuestionDAO();
                    QuestionDTO question = questionDAO.getQuestionById(Integer.parseInt(body[0]));
                    String title = question.getTitle().length() > 40 ? question.getTitle().substring(0,40) : question.getTitle();
                    content = content.replace(body[0], '"' +  title + "..." +'"');
                    noti.setContent(content);
                    noti.setHref(href);
                } else {
                    noti.setHref("");
                    QuestionDAO questionDAO = new QuestionDAO();
                    QuestionDTO question = questionDAO.getQuestionById(Integer.parseInt(body[0]));
                    String title = question.getTitle().length() > 40 ? question.getTitle().substring(0,40) : question.getTitle();
                    content = content.replace(body[0], '"' +  title + "..." + '"');
                    noti.setContent(content);
                }
            }} catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try {
            HttpSession session = request.getSession(false);
            UserDTO user = (UserDTO) session.getAttribute("USER");
            NotificationDAO notificationDAO = new NotificationDAO();
            ArrayList<NotificationViewDTO> listNoti = notificationDAO.getTop(user.getId(), 100);
            buildHref(listNoti);
            request.setAttribute("listNoti", listNoti);
            request.getRequestDispatcher(VIEW_ALL).forward(request,response);
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
