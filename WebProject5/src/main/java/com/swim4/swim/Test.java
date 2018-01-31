package com.swim4.swim;

import javax.inject.Inject;

import com.swim4.swim.board.dao.BoardDAO;
import com.swim4.swim.board.vo.Board;

public class Test {
	@Inject
	static BoardDAO dao;
	public static void main(String[] args) {
		
		for(int i=1; i<=100; i++){
			Board board = new Board();
			board.setTitle("제목"+i);
			board.setContent("내용"+i);
			board.setId("1234");
			dao.boardWrite(board);
		}
	}
}
