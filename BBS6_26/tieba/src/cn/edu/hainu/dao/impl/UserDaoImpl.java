package cn.edu.hainu.dao.impl;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.hainu.dao.UserDao;
import cn.edu.hainu.domain.User;
import cn.edu.hainu.util.JDBCUtils;

public class UserDaoImpl implements UserDao{

	private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
	@Override
	public void insertUser(User user) {
		String sql="insert user values(null,?,?,?,null,?)";
		template.update(sql,user.getUname(),user.getPsw(),user.getTel(),user.getNickname());
		
	}
	@Override
	public User selectUser(User user) {
		String sql="select * from user where uname=? and psw=?";
		User user2;
		try {
			user2 = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),user.getUname(),user.getPsw());
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		return user2;
	}
	@Override
	public void updateUser(User user) {
		String sql="update user set tel=?,avatar=?,nickname=? where uid=?";
		template.update(sql,user.getTel(),user.getAvatar(),user.getNickname(),user.getUid());
		
	}
	@Override
	public User findUserByUid(String uid) {
		String sql="select * from user where uid=?";
		User user2=template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),uid);
		return user2;
	}
	@Override
	public List<User> findAll() {
		String sql="select * from user";
		List<User> users=template.query(sql,new BeanPropertyRowMapper<User>(User.class));
		return users;
	}
	@Override
	public void deleteUserByUid(String uid) {
		String sql="delete from user where uid=?";
		template.update(sql,uid);
		
	}
	@Override
	public List<User> findUserByUname(String uname) {
		String sql="select * from user where uname like '%"+uname+"%'";
		List<User> users=template.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return users;
	}

}
