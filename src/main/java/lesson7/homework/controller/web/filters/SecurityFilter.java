package lesson7.homework.controller.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class SecurityFilter implements Filter {
    private boolean active = false;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String act = filterConfig.getInitParameter("active");
        if (act != null) {
            active = (act.toUpperCase().equals("TRUE"));
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (active) {
            response.getWriter().write("test</br>");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
