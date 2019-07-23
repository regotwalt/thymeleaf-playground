package com.rachelgotwalt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestLoggingFilter implements Filter {

    private ServletContext servletContext;

    public void init(FilterConfig filterConfig) {
        servletContext = filterConfig.getServletContext();
        servletContext.log("Initializing RequestLoggingFilter");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletContext.log("Request coming into RequestLoggingFilter: " + ((HttpServletRequest) servletRequest).getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        servletContext.log("Destroying RequestLoggingFilter");
    }

}
