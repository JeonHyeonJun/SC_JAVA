package com.swim4.swim.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swim4.swim.board.vo.Board;
import com.swim4.swim.board.vo.Reply;

@Repository
public class BoardDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);

	@Inject
	SqlSession sqlSession;
	
	public int boardWrite(Board board){
		logger.info("글 추가 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try{
			result = mapper.boardWrite(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("글 추가 종료");
		return result;
	}
	
	public ArrayList<Board> boardList(HashMap<String, Object> params){
		logger.info("글 목록 받기 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<Board> list = null;
		int startRecord = (int)params.get("startRecord");
		int countPerPage = (int)params.get("countPerPage");
		RowBounds rb = new RowBounds(startRecord, countPerPage);
		
		try{
			list = mapper.boardList(params, rb);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("글 목록 받기 종료");
		return list;
	}
	
	public int boardCount(HashMap<String, Object> params){
		logger.info("전체글갯수받기 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int count = 0;
		
		try{
			count = mapper.boardCount(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("전체글갯수받기 종료");
		return count;
	}
	
	public Board selectOneBoard(int boardnum){
		logger.info("글 하나 불러오기 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		Board board = null;
		
		try{
			board = mapper.selectOneBoard(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("글 하나 불러오기 종료");
		return board;
	}
	
	public int updateHits(int boardnum){
		logger.info("조회수 증가 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try{
			result = mapper.updateHits(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("조회수 증가 종료");
		return result;
	}
	
	public int boardDelete(Board board){
		logger.info("글 제거 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try{
			result = mapper.boardDelete(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("글 제거 종료");
		return result;
	}
	
	public int boardUpdate(Board board){
		logger.info("글 수정 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try{
			result = mapper.boardUpdate(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("글 수정 종료");
		return result;
	}
	
	public void insertReply(Reply reply){
		logger.info("댓글 등록 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			mapper.insertReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글 등록 종료");
	}
	
	public void updateReplyGroup(Reply reply){
		logger.info("댓글 그룹번호 수정 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			mapper.updateReplyGroup(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글 그룹번호 수정 종료");
	}
	
	public void deleteReply(Reply reply){
		logger.info("댓글 삭제 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			mapper.deleteReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글 삭제 종료");
	}
	
	public void updateReply(Reply reply){
		logger.info("댓글 수정 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			mapper.updateReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글 수정 종료");
	}
	
	public void updateReplyDel(Reply reply){
		logger.info("댓글 임시 삭제 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		try{
			mapper.updateReplyDel(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글 임시 삭제 종료");
	}
	
	public Reply selectOneReply(int replynum){
		logger.info("댓글 하나 불러오기 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		Reply reply = null;
		
		try{
			reply = mapper.selectOneReply(replynum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글 하나 불러오기 종료");
		return reply;
	}
	
	public ArrayList<Reply> replyList(int boardnum){
		logger.info("댓글 목록 불러오기 시작");
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<Reply> reply = null;
		
		try{
			reply = mapper.replyList(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글 목록 불러오기 종료");
		return reply;
	}
}
