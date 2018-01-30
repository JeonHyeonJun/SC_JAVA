package com.swim.pswim.dao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swim.pswim.vo.Board;

@Repository
public class BoardDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	public int insertBoard(Board board){
		logger.info("리뷰등록 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try{
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리뷰등록 종료");
		return result;
	}
	
	public int updateBoard(Board board){
		logger.info("리뷰수정 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try{
			result = mapper.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리뷰수정 종료");
		return result;
	}
	
	public int deleteBoard(Board board){
		logger.info("리뷰삭제 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try{
			result = mapper.deleteBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리뷰삭제 종료");
		return result;
	}
	
	public ArrayList<Board> boardList(String productcode){
		logger.info("리뷰리스트불러오기 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<Board> list = null;
		
		try{
			list = mapper.boardList(productcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리뷰리스트불러오기 종료");
		return list;
	}
	
	public Board selectOneBoard(int num){
		logger.info("리뷰하나불러오기 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		Board board = null;
		
		try{
			board = mapper.selectOneBoard(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("리뷰하나불러오기 종료");
		return board;
	}
}
