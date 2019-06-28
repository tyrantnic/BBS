package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import cn.edu.hainu.domain.Admin;
import cn.edu.hainu.service.AdminService;
import cn.edu.hainu.service.impl.AdminServiceImpl;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		Map<String, String[]> map=request.getParameterMap();
		Admin admin=new Admin();
		try {
			BeanUtils.populate(admin, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdminService service=new AdminServiceImpl();
		Admin admin2=service.login(admin);
		if (admin2!=null) {
			session.setAttribute("admin", admin2);
			session.removeAttribute("adminerror");
			response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
		}else {
			session.setAttribute("adminerror", "用户名或密码错误");
			response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}
