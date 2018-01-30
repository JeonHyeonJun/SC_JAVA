package com.swim.pswim.dao;

import java.util.ArrayList;

import com.swim.pswim.vo.Board;

public interface BoardMapper {
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(Board board);
	public ArrayList<Board> boardList(String productcode);
	public Board selectOneBoard(int num);
}
