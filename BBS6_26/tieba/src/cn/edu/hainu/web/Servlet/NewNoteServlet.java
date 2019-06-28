package cn.edu.hainu.web.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.hainu.domain.Note;
import cn.edu.hainu.service.NoteService;
import cn.edu.hainu.service.impl.NoteServiceImpl;

@WebServlet("/newNoteServlet")
public class NewNoteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//±àÂë
		String content=request.getParameter("content");//´«²Î
		String uid=request.getParameter("uid");
		String uname=request.getParameter("unickname");
		String topic=request.getParameter("topic");
		String reward=request.getParameter("reward");
		String avatar=request.getParameter("avatar");
		Note note=new Note();
		note.setContent(content);
		note.setUid(Integer.parseInt(uid));
		note.setUname(uname);
		note.setTopic(topic);
		note.setReward(Integer.parseInt(reward));
		note.setAvatar(avatar);
		
		NoteService service=new NoteServiceImpl();
		service.addNote(note);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}
