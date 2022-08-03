package swp391.fptqna.filters;

import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"}, filterName = "UserAuthorization")
public class UserAuthorization implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    private boolean check(String uri){
        String[] array = {"home","allNotifications","changepassword","createQuestion","editprofile"};
        for (String tmp: array) {
            if (uri.contains(tmp)) return true;
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        try {
            if (check(req.getRequestURI())) {
                UserDTO user = (UserDTO) session.getAttribute("USER");
                if (user == null) throw new Exception("user not found");
                if (!user.getState()) res.sendRedirect("/banError.jsp"); else
                chain.doFilter(request, response);
            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception e){
            e.printStackTrace();
            res.sendRedirect("/index.jsp");
        }
    }
}
