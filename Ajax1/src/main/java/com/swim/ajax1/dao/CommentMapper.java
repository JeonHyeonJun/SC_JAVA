package com.swim.ajax1.dao;

import java.util.ArrayList;

import com.swim.ajax1.vo.Comment;

public interface CommentMapper {
	public int insertComment(Comment comment);
	public int deleteComment(int num);
	public int updateComment(Comment comment);
	public ArrayList<Comment> commentList();
}
