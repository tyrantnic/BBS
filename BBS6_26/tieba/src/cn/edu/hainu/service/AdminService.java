package cn.edu.hainu.service;

import cn.edu.hainu.dao.AdminDao;
import cn.edu.hainu.dao.impl.AdminDaoImpl;
import cn.edu.hainu.domain.Admin;

public interface AdminService {

	AdminDao dao=new AdminDaoImpl();
	Admin login(Admin admin);
}
