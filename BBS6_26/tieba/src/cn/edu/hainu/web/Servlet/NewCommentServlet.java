package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hainu.domain.Comment;
import cn.edu.hainu.service.CommentService;
import cn.edu.hainu.service.NoteService;
import cn.edu.hainu.service.impl.CommentServiceImpl;
import cn.edu.hainu.service.impl.NoteServiceImpl;

/**
 * Servlet implementation class NewCommentServlet
 */
@WebServlet("/newCommentServlet")
public class NewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//±àÂë
		String nid=request.getParameter("nid");
		String content=request.getParameter("content");//´«²Î
		String myid=request.getParameter("myid");
		String yourid=request.getParameter("yourid");
		String myname=request.getParameter("mynickname");
		String yourname=request.getParameter("yournickname");
		String avatar=request.getParameter("avatar");
		Comment comment=new Comment();
		comment.setNid(Integer.parseInt(nid));
		comment.setContent(content);
		comment.setMyid(Integer.parseInt(myid));
		comment.setYourid(Integer.parseInt(yourid));
		comment.setMyname(myname);
		comment.setYourname(yourname);
		comment.setAvatar(avatar);
		
		CommentService commentService=new CommentServiceImpl();
		commentService.addComment(comment);
		
		NoteService noteservice = new NoteServiceImpl();
		noteservice.comnumPlusOne(nid);//ÁôÑÔÆÀÂÛ+1
		
		response.sendRedirect(request.getContextPath()+"/detailNoteServlet?nid="+nid);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

}
