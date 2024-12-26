package com.kh.user.model.dao;

import static com.kh.common.template.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.user.model.vo.Save;

public class SavelistDao {
	private Properties prop = new Properties();
	public SavelistDao() {
        try {
            // XML 파일 경로 설정
            String fileName = SavelistDao.class.getResource("/sql/save/savelist.xml").getPath();
            prop.loadFromXML(new FileInputStream(fileName)); // XML 파일 로드
        } catch (Exception e) {
            System.err.println("XML 파일 로드 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }

	public List<Save> SaveListInsert(Connection conn) {
		List<Save> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectSaveList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				Save save = new Save();
				save.setNo(rset.getInt("NO"));
				save.setUserId(rset.getInt("USER_Id"));
				save.setProductNo(rset.getInt("PRODUCT_NO"));
				save.setProductName(rset.getString("PRODUCT_NAME"));
				list.add(save);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}

	public int insertSaveList(Connection conn, Save s) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertSaveList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s.getUserId());
			pstmt.setInt(2, s.getProductNo());
			pstmt.setString(3, s.getProductName());
			updateCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateCount;
	}

	public int selectinsertSaveList(Connection conn) {
	    int saveno = 0;
	    PreparedStatement pstmt = null;
	    ResultSet rset = null;
	    String sql = prop.getProperty("selectinsertSaveList");
	    
	    try {
	        // 먼저 NEXTVAL을 호출하여 시퀀스 값을 증가시킨 후
	        String nextValQuery = "SELECT SAVELIST_SEQ.NEXTVAL FROM DUAL";
	        pstmt = conn.prepareStatement(nextValQuery);
	        rset = pstmt.executeQuery();
	        
	        if (rset.next()) {
	            // NEXTVAL을 호출한 후, 그 값을 INSERT 등에 사용할 수 있습니다.
	            int nextVal = rset.getInt(1);
	            
	            // 이후, CURRVAL을 사용하여 시퀀스 값을 가져옵니다.
	            String currValQuery = "SELECT SAVELIST_SEQ.CURRVAL FROM DUAL";
	            pstmt = conn.prepareStatement(currValQuery);
	            rset = pstmt.executeQuery();
	            
	            if (rset.next()) {
	                saveno = rset.getInt(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(rset);
	        close(pstmt);
	    }
	    return saveno;
	}

	public int deleteSaveList(Connection conn, Save d) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteSaveList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, d.getUserId());   // 첫 번째 매개변수: userId
		        pstmt.setInt(2, d.getProductNo());
		        
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateCount;	
	}
}
