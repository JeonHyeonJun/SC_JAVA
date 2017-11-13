package board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import board.vo.Board;

public interface BoardMapper {
	public int insertBoard(Board b);
	public int updateBoard(Board b);
	public int deleteBoard(int boardnum);
	public Board selectBoard(int boardnum);
	public ArrayList<Board> selectAllBoard();
	public ArrayList<Board> search(HashMap<String, Object> h);
	
	public int updateHits(int boardnum);
}
