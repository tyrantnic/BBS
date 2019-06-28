package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hainu.domain.User;
import cn.edu.hainu.service.UserService;
import cn.edu.hainu.service.impl.UserServiceImpl;


@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String key=request.getParameter("key");
		UserService service=new UserServiceImpl();
		List<User> users=service.findUserByUname(key);
		request.setAttribute("users", users);
		request.getRequestDispatcher("/admin/member.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}
