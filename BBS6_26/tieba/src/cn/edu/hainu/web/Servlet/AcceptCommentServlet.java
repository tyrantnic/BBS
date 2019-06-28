package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hainu.service.CommentService;
import cn.edu.hainu.service.impl.CommentServiceImpl;

/**
 * Servlet implementation class AcceptCommentServlet
 */
@WebServlet("/acceptCommentServlet")
public class AcceptCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AcceptCommentServlet() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cid = request.getParameter("cid");//url传参
		String nid = request.getParameter("nid");//url传参
		CommentService commentService=new CommentServiceImpl();
		commentService.acceptComment(cid);
		response.sendRedirect(request.getContextPath()+"/detailNoteServlet?nid="+nid);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}
