package cn.edu.hainu.service.impl;

import java.util.List;

import cn.edu.hainu.dao.CommentDao;
import cn.edu.hainu.dao.impl.CommentDaoImpl;
import cn.edu.hainu.domain.Comment;
import cn.edu.hainu.service.CommentService;

public class CommentServiceImpl implements CommentService {
	private CommentDao dao=new CommentDaoImpl();
	@Override
	public List<Comment> findCommentByNid(String nid) {
		return dao.findCommentByNid(Integer.parseInt(nid));
	}
	@Override
	public void addComment(Comment comment) {
		dao.addComment(comment);
	}
	@Override
	public void acceptComment(String cid) {
		dao.acceptComment(Integer.parseInt(cid));
	}
	@Override
	public List<Comment> findAll() {
		
		return dao.findAll();
	}
	@Override
	public void delComByCid(String[] cid) {
		for (int i = 0; i < cid.length; i++) {
			dao.delCommByCid(cid[i]);
		}
		
	}
	@Override
	public List<Comment> findNoteCommentByTopic(String topic) {
		
		return dao.findNoteCommentByTopic(topic);
	}

}
