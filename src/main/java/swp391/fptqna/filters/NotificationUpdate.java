package swp391.fptqna.filters;

import swp391.fptqna.dao.NotificationDAO;
import swp391.fptqna.dao.QuestionDAO;
import swp391.fptqna.dto.NotificationDTO;
import swp391.fptqna.dto.NotificationViewDTO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(urlPatterns = { "/header.jsp" },filterName = "Notification", dispatcherTypes = {DispatcherType.INCLUDE})
public class NotificationUpdate implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

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

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        try{
            UserDTO user = (UserDTO) session.getAttribute("USER");
            NotificationDAO notiDAO = new NotificationDAO();
            ArrayList<NotificationViewDTO> listNoti = notiDAO.getTop(user.getId(),5);
            buildHref(listNoti);
            session.setAttribute("noti",listNoti );
        } catch (Exception e) {
            session.setAttribute("noti",new ArrayList<NotificationViewDTO>());
            e.printStackTrace();
        }

        chain.doFilter(request, response);
    }
}
