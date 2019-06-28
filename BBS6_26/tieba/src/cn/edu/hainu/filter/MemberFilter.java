package cn.edu.hainu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MemberFilter",urlPatterns = "/admin/member.jsp")
public class MemberFilter implements Filter{

	public void init(FilterConfig config) throws ServletException {
        System.out.println("member过滤器初始化");
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest request2=(HttpServletRequest) request;
		HttpServletResponse response2=(HttpServletResponse) response;
		System.out.println("阻止访问member.jsp,转向访问"+request2.getContextPath()+"/allUserServlet");
        request2.getRequestDispatcher("/allUserServlet").forward(request2, response2);
        return;
	}
	public void destroy() {
		
	}

}
