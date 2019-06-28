package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hainu.domain.Note;
import cn.edu.hainu.service.NoteService;
import cn.edu.hainu.service.impl.NoteServiceImpl;

/**
 * Servlet implementation class MoreViewNoteServlet
 */
@WebServlet("/moreViewNoteServlet")
public class MoreViewNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoreViewNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		NoteService service = new NoteServiceImpl();
		List<Note> notes = service.moreViewNotes();
		request.setAttribute("notes",notes);
		request.getRequestDispatcher("/mostView.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
