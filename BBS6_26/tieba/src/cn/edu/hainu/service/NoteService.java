package cn.edu.hainu.service;

import java.util.List;

import cn.edu.hainu.domain.Note;

public interface NoteService {

	public List<Note> findAll(); 
	void addNote(Note note);
	public Note findNoteByNid(String nid);
	void seenumPlusOne(String nid);
	void comnumPlusOne(String nid);
	public List<Note> findNotesByUid(int uid);
	public List<Note> moreViewNotes();
	public List<Note> moreComNotes(); 
	public List<Note> moreRewardNotes(); 
	public List<Note> searchNotesByKey(String key); 
	public void deleteNoteByNid(String[] nid);
}
