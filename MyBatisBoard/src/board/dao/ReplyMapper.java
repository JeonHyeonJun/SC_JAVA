package board.dao;

import java.util.ArrayList;

import board.vo.Reply;

public interface ReplyMapper {
	public int insertReply(Reply r);
	public int updateReply(Reply r);
	public int deleteReply(int replynum);
	public Reply selectReply(int replynum);
	public ArrayList<Reply> selectAllReply();
}
