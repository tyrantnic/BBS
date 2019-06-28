package cn.edu.hainu.service;

import java.util.List;

import cn.edu.hainu.domain.User;

public interface UserService {

	void zhuce(User user);
	User login(User user);
	void updateUser(User user);
	User findUserByUid(String uid);
	public List<User> findAll();
	public void deleteUserByUid(String[] uid);
	List<User> findUserByUname(String uname);
}
