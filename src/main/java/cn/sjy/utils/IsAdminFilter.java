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

public class IsAdminFilter implements Filter {
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

	// 获取需要过滤的地址。
	String filterURL = filterConfig.getInitParameter("filterURL");
	if (filterURL != null) {
	    String[] filterURLs = filterURL.split(";");
	    for (int i = 0; i < filterURLs.length; i++) {
		if (filterURLs[i] == null || "".equals(filterURLs[i])) {
		    continue;
		}
		if (request.getRequestURI().indexOf(filterURLs[i]) != -1) {
		    // 进行判断。
		    Authority authority = Authority.valueOf(session.getAttribute("userAuthority").toString());
		    if (authority.equals(Authority.ADMIN)) {
			break;
		    } else {
			System.out.println(request.getRequestURI() + "请求被拦截。");
			if (request.getRequestURI().indexOf("pages") != -1) {
			    response.sendRedirect("../index.jsp");
			    return;
			} else {
			    response.sendRedirect("./index.jsp");
			    return;
			}
		    }
		}
	    }
	}
	// 当前的URL无需过滤。
	filterChain.doFilter(servletRequest, servletResponse);
	return;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
	this.filterConfig = filterConfig;
    }
}
