package board.dao;

import java.util.ArrayList;

import board.vo.Board;

public interface BoardMapper {
	public int insertBoard(Board b);
	public int updateBoard(Board b);
	public int deleteBoard(int boardnum);
	public Board selectBoard(int boardnum);
	public ArrayList<Board> selectAllBoard();
	
	public int updateHits(int boardnum);
}
