package swp391.fptqna.filters;

import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/index.jsp"}, filterName = "LoginAgain")
public class LoginAgain implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        try {
            UserDTO user = (UserDTO) session.getAttribute("USER");
            if (user == null) throw new Exception("user not found");
            res.sendRedirect("/home.jsp");
        } catch (Exception e){
            chain.doFilter(request, response);
        }


    }
}
