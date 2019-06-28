package cn.edu.hainu.dao;

import java.util.List;

import cn.edu.hainu.domain.Note;

public interface NoteDao {

	public List<Note> findAll();
	void addNote(Note note);
	public Note findNoteByNid(int nid);
	public void seenumPlusOne(int nid);
	public void comnumPlusOne(int nid);
	public List<Note> findNotesByUid(int uid);
	public List<Note> moreViewNotes();
	public List<Note> moreComNotes();
	public List<Note> moreRewardNotes();
	public List<Note> searchNotesByKey(String key);
	public void deleteNoteByNid(String nid);
}
