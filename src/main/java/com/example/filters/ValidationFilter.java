package com.example.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "ValidationFilter", urlPatterns = "/SignInServlet")
public class ValidationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (request.getParameter("radios") == null) {
            request.setAttribute("errorType", "no selected radio");
            request.getRequestDispatcher("error").forward(request, response);
        }

        chain.doFilter(request, response);
    }
}
