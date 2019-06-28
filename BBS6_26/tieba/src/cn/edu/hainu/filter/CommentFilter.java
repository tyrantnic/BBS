package cn.edu.hainu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CommentFilter",urlPatterns = "/admin/comment.jsp")
public class CommentFilter implements Filter{

	public void init(FilterConfig config) throws ServletException {
        System.out.println("comment过滤器初始化");
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest request2=(HttpServletRequest) request;
		HttpServletResponse response2=(HttpServletResponse) response;
		System.out.println("锟阻止访问comment.jsp,转向访问"+request2.getContextPath()+"/allCommentServlet");
        request2.getRequestDispatcher("/allCommentServlet").forward(request2, response2);
        return;
	}
	public void destroy() {
		
	}

}
