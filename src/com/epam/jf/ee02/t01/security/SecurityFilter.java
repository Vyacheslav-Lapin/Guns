package com.epam.jf.ee02.t01.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * SecurityFilter.
 *
 * @author Vyacheslav_Lapin
 */
//@WebFilter(urlPatterns = "catalog.jsp")
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // TODO: проверить логин и пароль
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String username = httpServletRequest.getParameter("j_username");
        String password = httpServletRequest.getParameter("j_password");

        if (UserChecker.isUserCorrect(username, password) && UserChecker.isUserTXTEnable(username))
            filterChain.doFilter(servletRequest, servletResponse);
        else
            httpServletRequest.getRequestDispatcher("error.html").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {
    }
}
