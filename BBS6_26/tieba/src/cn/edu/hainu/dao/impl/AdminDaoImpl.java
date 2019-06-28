package cn.edu.hainu.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.hainu.dao.AdminDao;
import cn.edu.hainu.domain.Admin;
import cn.edu.hainu.util.JDBCUtils;

public class AdminDaoImpl implements AdminDao{

	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	@Override
	public Admin login(Admin admin) {
		String sql="select * from admin where aname=? and psw=?";
		Admin admin2;
		try {
			admin2 = template.queryForObject(sql,new BeanPropertyRowMapper<Admin>(Admin.class),admin.getAname(),admin.getPsw());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return admin2;
	}

}
