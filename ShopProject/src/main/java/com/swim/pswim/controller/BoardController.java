package com.swim.pswim.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swim.pswim.dao.BoardDAO;
import com.swim.pswim.vo.Board;

@Controller
public class BoardController {
	
	@Inject
	BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="writeBoardForm", method=RequestMethod.GET)
	public String writeBoardForm(String productCode, Model model){
		logger.info("리뷰쓰기폼 시작");
		model.addAttribute("productCode", productCode);
		logger.info("리뷰쓰기폼 종료");
		return "writeBoardForm";
	}
	
	@RequestMapping(value="writeBoard", method=RequestMethod.POST)
	public String writeBoard(Board board){
		logger.info("리뷰쓰기 시작");
		dao.insertBoard(board);
		logger.info("리뷰쓰기 종료");
		return "redirect:productView?productCode="+board.getProductcode();
	}
}
