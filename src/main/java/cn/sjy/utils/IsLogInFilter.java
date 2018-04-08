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
import javax.servlet.http.HttpSession;

public class IsLogInFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void destroy() {
	// TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	    throws IOException, ServletException {
	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;
	HttpSession session = request.getSession();
	/*
	 * 将首页和登录页从过滤列表中去除。
	 */
	String passURL = filterConfig.getInitParameter("passURL");
	if (passURL != null) {
	    String[] passURLs = passURL.split(";");
	    for (int i = 0; i < passURLs.length; i++) {
		if (passURLs[i] == null || "".equals(passURLs[i])) {
		    continue;
		}
		if (request.getRequestURI().indexOf(passURLs[i]) != -1) {
		    filterChain.doFilter(servletRequest, servletResponse);
		    return;
		}
	    }
	}
	/*
	 * 对来访者的权限进行判断。
	 */
	if (session.getAttribute("userId") != null) {
	    filterChain.doFilter(servletRequest, servletResponse);
	    return;
	} else {
	    response.sendRedirect("index.jsp");
	}
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	this.filterConfig = filterConfig;
    }

}
