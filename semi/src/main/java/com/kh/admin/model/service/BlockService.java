package com.kh.admin.model.service;

import static com.kh.common.template.JDBCTemplate. *;
import static com.kh.common.template.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.model.dao.BlockDao;
import com.kh.admin.model.dto.BlockMemberDTO;
import com.kh.admin.model.vo.Block;
import com.kh.common.model.vo.PageInfo;

public class BlockService {
	
	private BlockDao dao = new BlockDao();

	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = dao.selectListCount(conn);
		
		close(conn);
		
		return listCount;
		
		
	}

	public List<BlockMemberDTO> selectAllList(PageInfo pi) {
		Connection conn = getConnection();
		
		List<BlockMemberDTO> list = dao.selectAllList(conn, pi);
		
		close(conn);
		
		return list;
		
	}

	public int blockUsers(String userId, String blockReason) {
        Connection conn = getConnection();
        
        int result = dao.updateBlock(conn, userId, blockReason);
        
        if (result > 0) {
        System.out.println("DB 업데이트 결과: " + result);
        
        
        	commit(conn);
        } else {
        	rollback(conn);
        }
        
        
        close(conn);
        
        return result;
	}

	public String selectSearchId(String searchId) {
		
		Connection conn = getConnection();
		String result = null;
		
		if(searchId == null || searchId.trim().isEmpty()) {
			  result = dao.searchAllList(conn);
		} else {
			 result = dao.selectSearchId(searchId, conn); 			
		}
	
		close(conn);
		
		return result;
	}

	public List<BlockMemberDTO> selectBlockList(PageInfo pi) {
		Connection conn = getConnection();
		
		List<BlockMemberDTO> list = dao.selectBlockList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int selectBlockCount() {
		Connection conn = getConnection();
		
		int listCount = dao.selectBlockCount(conn);
		
		close(conn);
		
		return listCount;
		
	}

	public List<BlockMemberDTO> selectUnblockList(PageInfo pi) {
		Connection conn = getConnection();
		
		List<BlockMemberDTO> list = dao.selectUnblockList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int selectUnblockCount() {
		Connection conn = getConnection();
		
		int listCount = dao.selectUnblockCount(conn);
		
		close(conn);
		
		return listCount;
	}



	

}
