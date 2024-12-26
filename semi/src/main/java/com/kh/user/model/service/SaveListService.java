package com.kh.user.model.service;

import static com.kh.common.template.JDBCTemplate.close;
import static com.kh.common.template.JDBCTemplate.commit;
import static com.kh.common.template.JDBCTemplate.getConnection;
import static com.kh.common.template.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.user.model.dao.SavelistDao;
import com.kh.user.model.vo.Save;

public class SaveListService {
	private  SavelistDao dao = new SavelistDao();

	public List<Save> selectSaveListList() {
		Connection conn = getConnection();
		List<Save>list = dao.SaveListInsert(conn);
		close(conn);
		
		return list;
	}

	public int insertSaveList(Save s) {
		Connection conn = getConnection();
		
		int result = dao.insertSaveList(conn, s);
		
		if(result > 0) {
			commit(conn);
			int saveno = dao.selectinsertSaveList(conn);
			s.setNo(saveno);			
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
		
	}

	public int deleteSaveList(Save d) {
		Connection conn = getConnection();
		int result = dao.deleteSaveList(conn,d);
		if(result > 0 ) {
			commit (conn);
			
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
