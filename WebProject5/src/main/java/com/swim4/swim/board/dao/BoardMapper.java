package com.swim4.swim.board.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.swim4.swim.board.vo.Board;
import com.swim4.swim.board.vo.Reply;

public interface BoardMapper {
	public int boardWrite(Board board);
	public ArrayList<Board> boardList(HashMap<String, Object> params, RowBounds rb);
	public int boardCount(HashMap<String, Object> params);
	public Board selectOneBoard(int boardnum);
	public int updateHits(int boardnum);
	public int boardDelete(Board board);
	public int boardUpdate(Board board);
	
	public void insertReply(Reply reply);
	public void deleteReply(Reply reply);
	public void updateReply(Reply reply);
	public void updateReplyGroup(Reply reply);
	public void updateReplyDel(Reply reply);
	public Reply selectOneReply(int replynum);
	public ArrayList<Reply> replyList(int boardnum);
}
