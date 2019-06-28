package cn.edu.hainu.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.hainu.dao.NoteDao;
import cn.edu.hainu.domain.Note;
import cn.edu.hainu.domain.User;
import cn.edu.hainu.util.JDBCUtils;

public class NoteDaoImpl implements NoteDao {
	private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public List<Note> findAll() {
		String sql = "SELECT * FROM newnotefirst";
		List<Note> notes = template.query(sql, new BeanPropertyRowMapper<Note>(Note.class));
		return notes;
	}

	@Override
	public void addNote(Note note) {
		String sql = "insert into note values(null,?,?,?,?,CURRENT_TIMESTAMP,?,0,0,?)";
		template.update(sql, note.getContent(), note.getUid(), note.getUname(), note.getTopic(), note.getReward(),note.getAvatar());
	}

	@Override
	public Note findNoteByNid(int nid) {
		String sql = "SELECT * FROM note WHERE nid = ?";
		Note note = template.queryForObject(sql, new BeanPropertyRowMapper<Note>(Note.class),nid);
		return note;
	}

	@Override
	public void seenumPlusOne(int nid) {
		String sql = "UPDATE note SET seenum=seenum+1 WHERE nid= ? ";
		template.update(sql, nid);
	}

	@Override
	public void comnumPlusOne(int nid) {
		String sql = "UPDATE note SET comnum=comnum+1 WHERE nid= ? ";
		template.update(sql, nid);
	}

	@Override
	public List<Note> findNotesByUid(int uid) {
		String sql = "SELECT * FROM note WHERE uid = ?";
		List<Note> notes = template.query(sql, new BeanPropertyRowMapper<Note>(Note.class),uid);
		return notes;
	}

	@Override
	public List<Note> moreViewNotes() {
		String sql = "SELECT * FROM moreviewnote";
		List<Note> notes = template.query(sql, new BeanPropertyRowMapper<Note>(Note.class));
		return notes;
	}

	@Override
	public List<Note> moreComNotes() {
		String sql = "SELECT * FROM morecomnote";
		List<Note> notes = template.query(sql, new BeanPropertyRowMapper<Note>(Note.class));
		return notes;
	}

	@Override
	public List<Note> moreRewardNotes() {
		String sql = "SELECT * FROM rewardfirst";
		List<Note> notes = template.query(sql, new BeanPropertyRowMapper<Note>(Note.class));
		return notes;
	}

	@Override
	public List<Note> searchNotesByKey(String key) {
		String sql = "SELECT * FROM newnotefirst WHERE content LIKE '%"+key+"%'";
		List<Note> notes = template.query(sql, new BeanPropertyRowMapper<Note>(Note.class));
		return notes;
	}

	@Override
	public void deleteNoteByNid(String nid) {
		String sql="delete from note where nid=?";
		template.update(sql,nid);
	}

}
