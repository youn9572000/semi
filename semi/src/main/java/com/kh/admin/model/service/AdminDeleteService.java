package com.kh.admin.model.service;
import static com.kh.common.template.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.admin.model.dao.AdminDeleteDao;

public class AdminDeleteService {
	
	private AdminDeleteDao dao = new AdminDeleteDao();
	
	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
	
		int result = dao.BoardDeleteDao(conn, boardNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteReply(int replyNo) {
		Connection conn = getConnection();
		
		int result = dao.ReplyDeleteDao(conn, replyNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}

	public int deleteReview(int reviewNo) {
		Connection conn = getConnection();
		int result = dao.ReviewDeleteDao(conn, reviewNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int deleteEBoard(int eboardNo) {
		Connection conn = getConnection();
		int result = dao.EBoardDeleteDao(conn, eboardNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}

	public int deleteFBoard(int fboardNo) {
		Connection conn = getConnection();
		int result = dao.FBoardDeleteDao(conn, fboardNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}

	public int deleteMBoard(int mboardNo) {
		Connection conn = getConnection();
		int result = dao.MBoardDeleteDao(conn, mboardNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
		
	}

}
