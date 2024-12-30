package com.kh.user.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.model.vo.Board;
import com.kh.common.model.vo.PageInfo;
import com.kh.user.model.dao.BoardDao;

import static com.kh.common.template.JDBCTemplate.*;

public class BoardService {

	private BoardDao dao = new BoardDao();

	public int selectNotice(int boardType) {

		Connection conn = getConnection();

		int listCount = dao.selectNoticeCount(conn, boardType);

		close(conn);

		return listCount;

	}

	public List<Board> selectNotice(PageInfo pi, String sort) {

		Connection conn = getConnection();

		List<Board> list = dao.selectNotice(conn, pi, sort);

		close(conn);

		return list;

	}

}
