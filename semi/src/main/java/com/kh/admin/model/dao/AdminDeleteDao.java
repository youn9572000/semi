package com.kh.admin.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import static com.kh.common.template.JDBCTemplate.*;

public class AdminDeleteDao {
	private Properties prop = new Properties();
	
	public AdminDeleteDao() {
		String path = AdminNoticeDao.class.getResource("/sql/admin/admin-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int BoardDeleteDao(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("boardDelete");
				try {
			        pstmt = conn.prepareStatement(sql);
			        pstmt.setInt(1, boardNo); // 게시글 번호 바인딩
			        result = pstmt.executeUpdate();
			    } catch (Exception e) {
			        e.printStackTrace();
			    } finally {
			        close(pstmt);
			    }
			    return result;
			}

	public int ReplyDeleteDao(Connection conn, int replyNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("replyDelete");
		try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, replyNo); // 게시글 번호 바인딩
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}

	public int ReviewDeleteDao(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reivewDelete");
		try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, reviewNo); // 게시글 번호 바인딩
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}

	public int EBoardDeleteDao(Connection conn, int eboardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("eboardDelete");
		try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, eboardNo); // 게시글 번호 바인딩
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}

	public int FBoardDeleteDao(Connection conn, int fboardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("fboardDelete");
		try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, fboardNo); // 게시글 번호 바인딩
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}

	public int MBoardDeleteDao(Connection conn, int mboardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("mboardDelete");
		try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, mboardNo); // 게시글 번호 바인딩
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(pstmt);
	    }
	    return result;
	}



}
