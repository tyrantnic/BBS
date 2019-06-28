package cn.edu.hainu.service.impl;

import java.util.List;

import cn.edu.hainu.dao.UserDao;
import cn.edu.hainu.dao.impl.UserDaoImpl;
import cn.edu.hainu.domain.User;
import cn.edu.hainu.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao=new UserDaoImpl();
	@Override
	public void zhuce(User user) {
		dao.insertUser(user);
	}
	
	public User login(User user) {
		return dao.selectUser(user);
	}

	
	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
		
	}

	@Override
	public User findUserByUid(String uid) {
		return dao.findUserByUid(uid);
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteUserByUid(String[] uid) {
		for (int i = 0; i < uid.length; i++) {
			dao.deleteUserByUid(uid[i]);
		}
		
	}

	@Override
	public List<User> findUserByUname(String uname) {
		List<User> users=dao.findUserByUname(uname);
		return users;
	}

}
