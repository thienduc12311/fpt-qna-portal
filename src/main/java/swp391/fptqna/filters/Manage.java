package swp391.fptqna.filters;

import swp391.fptqna.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = { "/manage/*" },filterName = "manage")
public class Manage implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        UserDTO user = (UserDTO) session.getAttribute("USER");
        if (user != null) {
            if (user.getRole() != 0)
                chain.doFilter(request, response);
            else res.sendRedirect("error.jsp");
        } else res.sendRedirect("error.jsp");
    }
}