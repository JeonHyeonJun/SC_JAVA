package com.swim.pswim.dao;

import java.util.ArrayList;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.swim.pswim.vo.Board;

@Repository
public class BoardDAO {
	
	@Inject
	SqlSession sqlSession;
	
	public int insertBoard(Board board){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		
		try{
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public ArrayList<Board> boardList(String productcode){
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<Board> list = null;
		
		try{
			list = mapper.boardList(productcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
