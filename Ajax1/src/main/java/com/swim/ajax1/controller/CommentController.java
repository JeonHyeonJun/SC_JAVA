package com.swim.ajax1.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.swim.ajax1.dao.CommentDAO;
import com.swim.ajax1.vo.Comment;

@Controller
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Inject
	CommentDAO dao;
	
	@RequestMapping(value="comment", method=RequestMethod.GET)
	public String comment(Model model){
		logger.info("댓글페이지 접속 시작");
		logger.info("댓글페이지 접속 종료");
		return "comment";
	}
	
	@ResponseBody
	@RequestMapping(value="commentList", method=RequestMethod.GET)
	public ArrayList<Comment> commentList(){
		ArrayList<Comment> list = dao.commentList();
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public void insert(@RequestBody Comment comment){
		logger.info("댓글작성 시작");
		dao.insertComment(comment);
		logger.info("댓글작성 종료");
	}
	
	@ResponseBody
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public void delete(int num){
		logger.info("댓글삭제 시작");
		dao.deleteComment(num);
		logger.info("댓글삭제 종료");
	}
	
	@ResponseBody
	@RequestMapping(value="update", method=RequestMethod.POST)
	public void update(@RequestBody Comment comment){
		logger.info("댓글수정 시작");
		dao.updateComment(comment);
		logger.info("댓글수정 종료");
	}
}
