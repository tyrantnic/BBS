package cn.edu.hainu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "IndexFilter",urlPatterns = "/index.jsp")
public class IndexFilter implements Filter{

	public void init(FilterConfig config) throws ServletException {
        //获取初始化参数，定义在web.xml里的<init--param>...</init--param>
        System.out.println("index过滤器初始化");
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest request2=(HttpServletRequest) request;
		HttpServletResponse response2=(HttpServletResponse) response;
		System.out.println("阻止访问index.jsp,转向访问"+request2.getContextPath()+"/allNoteServlet");
        response2.sendRedirect(request2.getContextPath()+"/allNoteServlet");
        return;
	}
	public void destroy() {
		
	}

}
