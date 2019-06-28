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
import cn.edu.hainu.domain.User;
import cn.edu.hainu.service.CommentService;
import cn.edu.hainu.service.NoteService;
import cn.edu.hainu.service.impl.CommentServiceImpl;
import cn.edu.hainu.service.impl.NoteServiceImpl;

/**
 * Servlet implementation class MyNoteServlet
 */
@WebServlet("/myNotesServlet")
public class MyNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyNotesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		User user = (User)request.getSession().getAttribute("user");
		int uid = user.getUid();
		NoteService service = new NoteServiceImpl();
		List<Note> mynotes = service.findNotesByUid(uid);//查询我的留言信息
		request.setAttribute("mynotes",mynotes);
		request.getRequestDispatcher("/myNotes.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
