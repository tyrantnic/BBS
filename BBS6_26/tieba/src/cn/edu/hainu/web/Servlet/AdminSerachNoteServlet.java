package cn.edu.hainu.web.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hainu.domain.Note;
import cn.edu.hainu.service.NoteService;
import cn.edu.hainu.service.impl.NoteServiceImpl;


@WebServlet("/adminSerachNoteServlet")
public class AdminSerachNoteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String key=request.getParameter("search_key");
		NoteService service = new NoteServiceImpl();
		List<Note> notes = service.searchNotesByKey(key);
//		HttpSession session=request.getSession();
		request.setAttribute("notes",notes);
		request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/admin/seachNote.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}
