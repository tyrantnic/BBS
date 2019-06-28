package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hainu.service.UserService;
import cn.edu.hainu.service.impl.UserServiceImpl;

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String[] uid=request.getParameterValues("uid");
		UserService service=new UserServiceImpl();
		service.deleteUserByUid(uid);
		response.sendRedirect(request.getContextPath()+"/admin/member.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}
