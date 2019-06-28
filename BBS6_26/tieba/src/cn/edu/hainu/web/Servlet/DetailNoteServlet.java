package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hainu.domain.Comment;
import cn.edu.hainu.domain.Note;
import cn.edu.hainu.service.CommentService;
import cn.edu.hainu.service.NoteService;
import cn.edu.hainu.service.impl.CommentServiceImpl;
import cn.edu.hainu.service.impl.NoteServiceImpl;

@WebServlet("/detailNoteServlet")
public class DetailNoteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nid = request.getParameter("nid");//url传参
		NoteService service = new NoteServiceImpl();
		Note note = service.findNoteByNid(nid);//查询留言信息
		service.seenumPlusOne(nid);//留言浏览量加一
		
		List<Note> notes1 = service.moreViewNotes();
		List<Note> notes2 = service.moreComNotes();
		List<Note> notes3 = service.moreRewardNotes();
		request.setAttribute("notes1",notes1);
		request.setAttribute("notes2",notes2);
		request.setAttribute("notes3",notes3);
		
		CommentService commentService = new CommentServiceImpl();
		List<Comment>comments=commentService.findCommentByNid(nid);
		
		request.setAttribute("note",note);
		request.setAttribute("comments", comments);
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}
