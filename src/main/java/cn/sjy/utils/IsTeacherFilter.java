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

public class IsTeacherFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
	    throws IOException, ServletException {
	HttpServletRequest request = (HttpServletRequest) servletRequest;
	HttpServletResponse response = (HttpServletResponse) servletResponse;
	HttpSession session = request.getSession();

	// 查看权限等级是否是教师级别以上。
	Authority authority = Authority.valueOf(session.getAttribute("userAuthority").toString());
	if (authority.equals(Authority.TEACHER) || authority.equals(Authority.ADMIN)) {
	    filterChain.doFilter(servletRequest, servletResponse);
	    return;
	} else {
	    System.out.println(request.getRequestURI() + "请求被拦截。");
	    if (request.getRequestURI().indexOf("pages") != -1) {
		response.sendRedirect("../index.jsp");
	    } else {
		response.sendRedirect("./index.jsp");
	    }
	}
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	this.filterConfig = filterConfig;
    }

}
