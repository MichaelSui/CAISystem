package cn.sjy.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DirectAccessFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	    throws IOException, ServletException {
	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;
	String url = request.getRequestURI();
	if (url.indexOf("pages") != -1) {
	    if (url.indexOf("error.jsp") != -1) {
		filterChain.doFilter(servletRequest, servletResponse);
		return;
	    } else {
		System.out.println(request.getRequestURI() + "请求被拦截。");
		response.sendRedirect("../index.jsp");
	    }
	} else {
	    filterChain.doFilter(servletRequest, servletResponse);
	    return;
	}
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	this.filterConfig = filterConfig;
    }

}
