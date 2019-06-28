 package cn.edu.hainu.web.Servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;


import cn.edu.hainu.dao.impl.PhotoDaoImpl;
import cn.edu.hainu.domain.User;
import cn.edu.hainu.service.UserService;
import cn.edu.hainu.service.impl.UserServiceImpl;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		List<String> list=new ArrayList<String>();
		String filename=PhotoDaoImpl.getPhotoNewName();
		ServletContext servletContext=null;
		servletContext=request.getSession().getServletContext();
		List<FileItem> items=PhotoDaoImpl.getRequsetFileItems(request, servletContext);
		boolean isLoadToSQL=false;
		for(FileItem item:items) {
			if (!item.isFormField()) {
				if (item.getSize()!=0) {
					isLoadToSQL=PhotoDaoImpl.saveFile(item,filename);
				}
				
			}else {
				list.add(item.getString("UTF-8"));
			}
			
		}
		
		Map<String, String> map=new HashMap<String,String>();
		String finalPhotoName=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/images/"+filename;
		if (!isLoadToSQL) {
			UserService service=new UserServiceImpl();
			User user=service.findUserByUid(list.get(2));
			map.put("avatar", user.getAvatar());
		}else {
			map.put("avatar", finalPhotoName);
		}
		map.put("tel", list.get(0));
		map.put("nickname", list.get(1));
		map.put("uid", list.get(2));
		User user=new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserService service=new UserServiceImpl();
		service.updateUser(user);
		User user2=service.findUserByUid(list.get(2));
		HttpSession session=request.getSession();
		session.setAttribute("user",user2);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}
}
