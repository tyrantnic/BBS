package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hainu.service.CommentService;
import cn.edu.hainu.service.impl.CommentServiceImpl;

@WebServlet("/deleteCommentServlet")
public class DeleteCommentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String[] cid=request.getParameterValues("cid");
		CommentService service=new CommentServiceImpl();
		service.delComByCid(cid);
		response.sendRedirect(request.getContextPath()+"/admin/comment.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}
