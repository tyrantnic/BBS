package cn.edu.hainu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter",urlPatterns = "/admin/admin.jsp")
public class AdminFilter implements Filter{

	public void init(FilterConfig config) throws ServletException {
        //锟斤拷取锟斤拷始锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷web.xml锟斤拷锟�<init--param>...</init--param>
        System.out.println("admin过滤器初始化");
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest request2=(HttpServletRequest) request;
		HttpServletResponse response2=(HttpServletResponse) response;
		System.out.println("锟阻止访问admin.jsp,转向访问"+request2.getContextPath()+"/adminAllNoteServlet");
		System.out.println(request2.getParameter("isFilter"));;
		
        request2.getRequestDispatcher("/adminAllNoteServlet").forward(request2, response2);
        return;
	}
	public void destroy() {
		
	}

}
