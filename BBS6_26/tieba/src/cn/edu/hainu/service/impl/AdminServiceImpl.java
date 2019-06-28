package cn.edu.hainu.service.impl;

import cn.edu.hainu.domain.Admin;
import cn.edu.hainu.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Override
	public Admin login(Admin admin) {
		return dao.login(admin);
	}

}
