package cn.edu.hainu.service;

import java.util.List;

import cn.edu.hainu.domain.Comment;

public interface CommentService {

	public List<Comment> findCommentByNid(String nid);
	void addComment(Comment comment);
	void acceptComment(String cid);
	List<Comment> findAll();
	void delComByCid(String[] cid);
	List<Comment> findNoteCommentByTopic(String topic);
}
