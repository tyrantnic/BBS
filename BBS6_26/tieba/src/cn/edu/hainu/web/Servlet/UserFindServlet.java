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

import cn.edu.hainu.domain.User;
import cn.edu.hainu.service.UserService;
import cn.edu.hainu.service.impl.UserServiceImpl;


@WebServlet("/userFindServlet")
public class UserFindServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String verifycode=request.getParameter("verifycode");
		String checkcode_server=(String)session.getAttribute("CHECKCODE_SERVER");
		session.removeAttribute("CHECKCODE_SERVER");
		if(!checkcode_server.equalsIgnoreCase(verifycode)) {
			request.setAttribute("error","验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return ;
		}
		Map<String, String[]> map=request.getParameterMap();
		User user=new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserService service=new UserServiceImpl();
		User user2=service.login(user);
		if (user2!=null) {
			session.setAttribute("user", user2);
			session.removeAttribute("error");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			session.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}
