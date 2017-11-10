package board.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import board.vo.Board;

public class BoardDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	SqlSession ss = null;
	
	
	public boolean insertBoard(Board b) {
		int cnt = 0;
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			cnt = mapper.insertBoard(b);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
		
		if(cnt == 0) 
			return false;
		else 
			return true;
	}
	
	public void updateBoard(Board b) {
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			mapper.updateBoard(b);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
	}
	
	public void deleteBoard(int boardnum) {
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			mapper.deleteBoard(boardnum);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
	}
	
	public void updateHits(int boardnum) {
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			mapper.updateHits(boardnum);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
	}
	
	public Board selectBoard(int boardnum) {
		Board b = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			b = mapper.selectBoard(boardnum);
			ss.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
		return b;
	}
	
	public ArrayList<Board> selectAllBoard(){
		ArrayList<Board> list = null;
		
		try {
			ss = factory.openSession();
			BoardMapper mapper = ss.getMapper(BoardMapper.class);
			list = mapper.selectAllBoard();
			ss.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) ss.close();
		}
		return list;
	}
}
