package com.kh.user.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.admin.model.vo.AdminNoticeCategory;
import com.kh.admin.model.vo.Board;
import com.kh.common.model.vo.PageInfo;

import static com.kh.common.template.JDBCTemplate.*;

public class BoardDao {

	private Properties prop = new Properties();
	
	public BoardDao() {
		String path = BoardDao.class.getResource("/sql/board/board-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Board> selectNotice(Connection conn, PageInfo pi, String sort) {
		
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNotice");
		
		switch (sort) {
        case "count":
            sql += " ORDER BY COUNT DESC";
            break;
        case "plus":
            sql += " ORDER BY PLUS DESC";
            break;
        default:
            sql += " ORDER BY BOARD_NO DESC";
    }
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1 ) * pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = Board.builder()
			            	   .boardNo(rset.getInt("BOARD_NO"))
			            	   .category(new AdminNoticeCategory(0, rset.getString("BOARD_CATEGORY")))
			            	   .boardTitle(rset.getString("BOARD_TITLE"))
			            	   .boardWriter(rset.getString("BOARD_WRITER"))
			            	   .plus(rset.getInt("PLUS"))
			            	   .count(rset.getInt("COUNT"))
			            	   .createDate(rset.getDate("CREATE_DATE"))
			            	   .build();
				list.add(b);
				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	
	
	public int selectNoticeCount(Connection conn, int boardType) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNoticeCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, boardType);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}


}
