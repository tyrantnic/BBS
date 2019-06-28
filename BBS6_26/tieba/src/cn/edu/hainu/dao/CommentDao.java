package cn.edu.hainu.dao;

import java.util.List;

import cn.edu.hainu.domain.Comment;

public interface CommentDao {
	public List<Comment> findCommentByNid(int nid);
	void addComment(Comment comment);
	void acceptComment(int cid); 
	public List<Comment> findAll();
	
	void delCommByCid(String cid);
	List<Comment> findNoteCommentByTopic(String tpoic);
	
}
