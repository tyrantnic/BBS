package cn.edu.hainu.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.hainu.dao.CommentDao;
import cn.edu.hainu.domain.Comment;
import cn.edu.hainu.util.JDBCUtils;

public class CommentDaoImpl implements CommentDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	public List<Comment> findCommentByNid(int nid) {
		String sql = "SELECT * FROM acceptcomfirst WHERE nid = ?";
		List<Comment> comments = template.query(sql, new BeanPropertyRowMapper<Comment>(Comment.class), nid);
		return comments;
	}

	@Override
	public void addComment(Comment comment) {
		String sql = "insert into comment values(null,?,?,?,?,0,0,CURRENT_TIMESTAMP,?,?,?)";
		template.update(sql, comment.getNid(), comment.getContent(), comment.getMyid(), comment.getYourid(),
				comment.getMyname(), comment.getYourname(),comment.getAvatar());
	}

	@Override
	public void acceptComment(int cid) {
		String sql= "update comment set accept=1 where cid= ? ";
		template.update(sql,cid);
	}

	@Override
	public List<Comment> findAll() {
		String sql="select b.topic,a.* from comment a,note b  where a.nid=b.nid ";
		List<Comment> comments=template.query(sql, new BeanPropertyRowMapper<Comment>(Comment.class));
		return comments;
	}

	@Override
	public void delCommByCid(String cid) {
		String sql="delete from comment where cid=?";
		template.update(sql,cid);
		
	}

	@Override
	public List<Comment> findNoteCommentByTopic(String topic) {
		String sql="select a.topic,b.* from comment b,note a where a.nid=b.nid and topic like '%"+topic+"%'";
		System.out.println(sql);
		List<Comment> comments=template.query(sql, new BeanPropertyRowMapper<Comment>(Comment.class));
		return comments;
	}
	

}
