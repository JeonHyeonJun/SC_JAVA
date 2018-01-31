package com.swim.ajax1.dao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swim.ajax1.vo.Comment;

@Repository
public class CommentDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentDAO.class);
	
	@Inject
	SqlSession session;
	
	public int insertComment(Comment comment){
		logger.info("댓글등록 시작");
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		int result = 0;
		
		try{
			result = mapper.insertComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글등록 종료");
		return result;
	}
	
	public int deleteComment(int num){
		logger.info("댓글삭제 시작");
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		int result = 0;
		
		try{
			result = mapper.deleteComment(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글삭제 종료");
		return result;
	}
	
	public int updateComment(Comment comment){
		logger.info("댓글수정 시작");
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		int result = 0;
		
		try{
			result = mapper.updateComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글수정 종료");
		return result;
	}
	
	public ArrayList<Comment> commentList(){
		logger.info("댓글리스트 불러오기 시작");
		CommentMapper mapper = session.getMapper(CommentMapper.class);
		ArrayList<Comment> list = null;
		
		try{
			list = mapper.commentList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("댓글리스트 불러오기 종료");
		return list;
	}
}
