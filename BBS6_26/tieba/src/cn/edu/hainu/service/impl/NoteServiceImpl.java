package cn.edu.hainu.service.impl;

import java.util.List;

import cn.edu.hainu.dao.NoteDao;
import cn.edu.hainu.dao.impl.NoteDaoImpl;
import cn.edu.hainu.domain.Note;
import cn.edu.hainu.service.NoteService;

public class NoteServiceImpl implements NoteService{
	private NoteDao dao=new NoteDaoImpl();
	@Override
	public List<Note> findAll() {
		return dao.findAll();
	}
	@Override
	public void addNote(Note note) {
		dao.addNote(note);
	}
	@Override
	public Note findNoteByNid(String nid) {
		return dao.findNoteByNid(Integer.parseInt(nid));
	}
	@Override
	public void seenumPlusOne(String nid) {
		dao.seenumPlusOne(Integer.parseInt(nid));
	}
	@Override
	public void comnumPlusOne(String nid) {
		dao.comnumPlusOne(Integer.parseInt(nid));
	}
	@Override
	public List<Note> findNotesByUid(int uid) {
		return dao.findNotesByUid(uid);
	}
	@Override
	public List<Note> moreViewNotes() {
		return dao.moreViewNotes();
	}
	@Override
	public List<Note> moreComNotes() {
		return dao.moreComNotes();
	}
	@Override
	public List<Note> moreRewardNotes() {
		return dao.moreRewardNotes();
	}
	@Override
	public List<Note> searchNotesByKey(String key) {
		return dao.searchNotesByKey(key);
	}
	@Override
	public void deleteNoteByNid(String[] nid) {
		for (int i = 0; i < nid.length; i++) {
			dao.deleteNoteByNid(nid[i]);
		}
	}

}
