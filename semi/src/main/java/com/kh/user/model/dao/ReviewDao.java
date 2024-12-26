package com.kh.user.model.dao;

import static com.kh.common.template.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.user.model.vo.Review;

public class ReviewDao {
    private Properties prop = new Properties(); // SQL 쿼리를 저장할 Properties 객체
    public ReviewDao() {
        try {
            // XML 파일 경로 설정
            String fileName = ReviewDao.class.getResource("/sql/review/review.xml").getPath();
            prop.loadFromXML(new FileInputStream(fileName)); // XML 파일 로드
        } catch (Exception e) {
            System.err.println("XML 파일 로드 실패: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 리뷰 목록 조회 메서드
    public List<Review> selectList(Connection conn, int productNo) {
        List<Review> list = new ArrayList<>(); // 리뷰 목록을 저장할 리스트
        PreparedStatement pstmt = null; // SQL 쿼리 실행을 위한 PreparedStatement 객체
        ResultSet rset = null; // SQL 실행 결과를 저장할 ResultSet 객체
        String sql = prop.getProperty("selectReviewList"); // SQL 쿼리를 가져옴

        try {
            pstmt = conn.prepareStatement(sql); // SQL 쿼리 준비
            pstmt.setInt(1, productNo); // 첫 번째 파라미터: 상품 번호
            rset = pstmt.executeQuery(); // 쿼리 실행 및 결과 가져오기

            while (rset.next()) { // 결과를 반복 처리
                // 빌더 패턴을 사용하여 Review 객체 생성
                Review review = Review.builder()
                        .reviewNo(rset.getInt("REVIEW_NO")) // 리뷰 번호
                        .reviewWriter(rset.getString("REVIEW_WRITER")) // 리뷰 작성자
                        .productNo(rset.getInt("PRODUCT_NO")) // 상품 번호
                        .reviewContent(rset.getString("REVIEW_CONTENT")) // 리뷰 내용
                        .reviewDate(rset.getDate("REVIEW_DATE")) // 리뷰 작성일
                        .reviewScore(rset.getInt("REVIEW_SCORE")) // 리뷰 별점
                        .build();

                list.add(review); // 생성된 Review 객체를 리스트에 추가
            }

        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        } finally {
            close(rset); // ResultSet 닫기
            close(pstmt); // PreparedStatement 닫기
        }
        return list; // 리뷰 목록 반환
    }

    // 리뷰 총 개수 조회 메서드
    public int selectReviewCount(Connection conn, int productNo) {
        int listCount = 0; // 리뷰 총 개수 초기화
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectReviewCount"); // SQL 쿼리를 가져옴

        try {
            pstmt = conn.prepareStatement(sql); // SQL 쿼리 준비
            pstmt.setInt(1, productNo); // 첫 번째 파라미터: 상품 번호
            rset = pstmt.executeQuery(); // 쿼리 실행 및 결과 가져오기

            if (rset.next()) { // 결과가 있으면
                listCount = rset.getInt(1); // 첫 번째 열의 값을 가져옴
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        } finally {
            close(rset); // ResultSet 닫기
            close(pstmt); // PreparedStatement 닫기
        }
        return listCount; // 리뷰 총 개수 반환
    }

    // 리뷰 번호 조회 메서드
    public int selectReviewListNo(Connection conn) {
        int rno = 0; // 리뷰 번호 초기화
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectReivewListNo"); // SQL 쿼리를 가져옴

        try {
            pstmt = conn.prepareStatement(sql); // SQL 쿼리 준비
            rset = pstmt.executeQuery(); // 쿼리 실행 및 결과 가져오기

            if (rset.next()) { // 결과가 있으면
                rno = rset.getInt(1); // 첫 번째 열의 값을 가져옴
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        } finally {
            close(rset); // ResultSet 닫기
            close(pstmt); // PreparedStatement 닫기
        }
        return rno; // 리뷰 번호 반환
    }

    // 리뷰 추가 메서드
    public int insertReview(Connection conn, Review r) {
        int updateCount = 0; // 업데이트된 행의 개수 초기화
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertReview"); // SQL 쿼리를 가져옴

        try {
            pstmt = conn.prepareStatement(sql); // SQL 쿼리 준비
            pstmt.setString(1, r.getReviewWriter()); // 첫 번째 파라미터: 리뷰 작성자
            pstmt.setInt(2, r.getProductNo()); // 두 번째 파라미터: 상품 번호
            pstmt.setString(3, r.getReviewContent()); // 세 번째 파라미터: 리뷰 내용
            pstmt.setInt(4, r.getReviewScore()); // 네 번째 파라미터: 리뷰 별점

            updateCount = pstmt.executeUpdate(); // 쿼리 실행 및 결과 저장
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        } finally {
            close(pstmt); // PreparedStatement 닫기
        }
        return updateCount; // 업데이트된 행의 개수 반환
    }

    // 리뷰 단일 조회 메서드
    public Review selectOne(Connection conn, int reviewNo) {
        Review r = null; // 초기화
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectOneReview"); // SQL 쿼리를 가져옴

        try {
            pstmt = conn.prepareStatement(sql); // SQL 쿼리 준비
            pstmt.setInt(1, reviewNo); // 첫 번째 파라미터: 리뷰 번호
            rset = pstmt.executeQuery(); // 쿼리 실행 및 결과 가져오기

            if (rset.next()) { // 결과가 있으면
                r = Review.builder()
                        .reviewContent(rset.getString("REIVEW_CONTENT")) // 리뷰 내용
                        .reviewScore(rset.getInt("REVIEW_SCORE")) // 리뷰 별점
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        } finally {
            close(rset); // ResultSet 닫기
            close(pstmt); // PreparedStatement 닫기
        }
        return r; // 조회된 Review 객체 반환
    }

    // 리뷰 업데이트 메서드
    public int updateReview(Connection conn, Review r) {
        int updateCount = 0; // 업데이트된 행의 개수 초기화
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateReview"); // SQL 쿼리를 가져옴

        try {
            pstmt = conn.prepareStatement(sql); // SQL 쿼리 준비
            pstmt.setString(1, r.getReviewContent()); // 첫 번째 파라미터: 리뷰 내용
            pstmt.setInt(2, r.getReviewScore()); // 두 번째 파라미터: 리뷰 별점
            pstmt.setInt(3, r.getReviewNo()); // 세 번째 파라미터: 리뷰 번호

            updateCount = pstmt.executeUpdate(); // 쿼리 실행 및 결과 저장
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        } finally {
            close(pstmt); // PreparedStatement 닫기
        }
        return updateCount; // 업데이트된 행의 개수 반환
    }

    // 리뷰 삭제 메서드
    public int deleteReview(Connection conn, int reviewNo) {
        int updateCount = 0; // 업데이트된 행의 개수 초기화
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteReview"); // SQL 쿼리를 가져옴

        try {
            pstmt = conn.prepareStatement(sql); // SQL 쿼리 준비
            pstmt.setInt(1, reviewNo); // 첫 번째 파라미터: 리뷰 번호

            updateCount = pstmt.executeUpdate(); // 쿼리 실행 및 결과 저장
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리
        } finally {
            close(pstmt); // PreparedStatement 닫기
        }
        return updateCount; // 삭제된 행의 개수 반환
    }
}