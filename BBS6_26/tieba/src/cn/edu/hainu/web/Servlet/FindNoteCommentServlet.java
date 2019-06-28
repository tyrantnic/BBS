package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hainu.domain.Comment;
import cn.edu.hainu.service.CommentService;
import cn.edu.hainu.service.impl.CommentServiceImpl;

@WebServlet("/findNoteCommentServlet")
public class FindNoteCommentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		CommentService service=new CommentServiceImpl();
		String key=request.getParameter("key");
		List<Comment> comments=service.findNoteCommentByTopic(key);
		request.setAttribute("comments", comments);
		request.getRequestDispatcher("/admin/comment.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}
