package cn.edu.hainu.dao;

import java.util.List;

import cn.edu.hainu.domain.User;

public interface UserDao {

	void insertUser(User user);
	User selectUser(User user);
	void updateUser(User user);
	User findUserByUid(String uid);
	List<User> findAll();
	public void deleteUserByUid(String uid);
	public List<User> findUserByUname(String uname);
}
