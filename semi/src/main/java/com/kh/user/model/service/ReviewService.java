package com.kh.user.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.user.model.dao.ReviewDao;
import com.kh.user.model.vo.Review;
import static com.kh.common.template.JDBCTemplate.*;




public class ReviewService {
	private ReviewDao dao = new ReviewDao();

	// 리뷰 목록 조회

	public List<Review> selectReviewList(int productNo) {
		Connection conn = getConnection(); // 데이터베이스 연결 가져오기
		List<Review> list = dao.selectList(conn, productNo); // DAO 메서드 호출
		close(conn); // 연결 닫기
		return list; // 리뷰 목록 반환
	}

	// 리뷰 총 개수 조회

	public int selectReviewCount(int productNo) {
		Connection conn = getConnection(); // 데이터베이스 연결 가져오기
		int listCount = dao.selectReviewCount(conn, productNo); // DAO 메서드 호출
		close(conn); // 연결 닫기
		return listCount; // 총 리뷰 개수 반환
	}

	public int insertReview(Review r) {
		Connection conn = getConnection();

		int result = dao.insertReview(conn, r);
		if (result > 0) {
			commit(conn);
			int rno = dao.selectReviewListNo(conn);
			r.setReviewNo(rno);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Review selectOne(int reviewNo) {
		Connection conn = getConnection();
		Review r = dao.selectOne(conn, reviewNo);
		close(conn);
		return r;
	}

	public int updateReview(Review r) {

		Connection conn = getConnection();
		int result = dao.updateReview(conn, r);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	public int deleteReview(int reviewNo) {
	    Connection conn = getConnection(); // 데이터베이스 연결 객체 가져오기

	    int result = dao.deleteReview(conn, reviewNo); // DAO 계층 호출하여 리뷰 삭제

	    if (result > 0) {
	        commit(conn); // 삭제 성공 시 커밋
	    } else {
	        rollback(conn); // 삭제 실패 시 롤백
	    }

	    close(conn); // 연결 닫기
	    return result; // 삭제 결과 반환
	}

}
