package com.swim.pswim.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.swim.pswim.dao.BoardDAO;
import com.swim.pswim.util.FileService;
import com.swim.pswim.vo.Board;

@Controller
public class BoardController {
	
	@Inject
	BoardDAO dao;
	
	final String uploadPath = "/upload"; 
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="writeBoardForm", method=RequestMethod.GET)
	public String writeBoardForm(String productCode, Model model){
		logger.info("리뷰쓰기폼 시작");
		model.addAttribute("productCode", productCode);
		logger.info("리뷰쓰기폼 종료");
		return "writeBoardForm";
	}
	
	@RequestMapping(value="writeBoard", method=RequestMethod.POST)
	public String writeBoard(Board board, MultipartFile upload){
		logger.info("리뷰쓰기 시작");
		if(!upload.isEmpty()){
			logger.info("글쓰기 첨부파일 추가 시작");
			String savedfile = FileService.saveFile(upload, uploadPath);
			board.setSavedfile(savedfile);
			board.setOriginalfile(upload.getOriginalFilename());
			logger.info("글쓰기 첨부파일 추가 종료");
		}
		dao.insertBoard(board);
		logger.info("리뷰쓰기 종료");
		return "redirect:productView?productCode="+board.getProductcode();
	}
	
	@RequestMapping(value="boardView", method=RequestMethod.GET)
	public String boardView(int num, Model model){
		logger.info("리뷰보기 시작");
		Board board = dao.selectOneBoard(num);
		model.addAttribute("board", board);
		logger.info("리뷰보기 종료");
		return "boardView";
	}
	
	@RequestMapping(value="deleteBoard", method=RequestMethod.POST)
	public String deleteBoard(Board board){
		logger.info("리뷰삭제 시작");
		Board b = dao.selectOneBoard(board.getNum());
		int result = dao.deleteBoard(board);
		if(result == 1){
			logger.info("리뷰삭제 첨부파일 삭제 시작");
			FileService.deleteFile(uploadPath+"/"+b.getSavedfile());
			logger.info("리뷰삭제 첨부파일 삭제 시작");
		}
		logger.info("리뷰삭제 종료");
		return "redirect:productView?productCode="+board.getProductcode();
	}
	
	@RequestMapping(value="updateBoardForm", method=RequestMethod.POST)
	public String updateBoardForm(int num, Model model){
		logger.info("리뷰수정폼 시작");
		Board board = dao.selectOneBoard(num);
		model.addAttribute("board", board);
		logger.info("리뷰수정폼 종료");
		return "updateBoardForm";
	}
	
	@RequestMapping(value="updateBoard", method=RequestMethod.POST)
	public String updateBoard(Board board, MultipartFile upload){
		logger.info("리뷰수정 시작");
		Board b = dao.selectOneBoard(board.getNum());
		if(!upload.isEmpty()){
			logger.info("리뷰수정 첨부파일 추가 시작");
			FileService.deleteFile(uploadPath+"/"+b.getSavedfile());
			String savedfile = FileService.saveFile(upload, uploadPath);
			board.setSavedfile(savedfile);
			board.setOriginalfile(upload.getOriginalFilename());
			logger.info("리뷰수정 첨부파일 추가 종료");
		}
		int result = dao.updateBoard(board);
		logger.info("리뷰수정 종료");
		return "redirect:boardView?num="+board.getNum();
	}
	
	@RequestMapping(value="download", method=RequestMethod.GET)
	public void fileDownload(int num, HttpServletResponse response){
		Board board = dao.selectOneBoard(num);
		
		//원래 파일명 response Header에 인코딩해서 등록
		String orinalfile = board.getOriginalfile();
		if(orinalfile == null)
			return;
		
		try{
			//필수! 복붙해서 사용.
			response.setHeader("Content-Disposition", 
					"attachment;filename="+URLEncoder.encode(orinalfile, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//outputstream을 연결
		//저장된 파일 경로
		String fullPath = uploadPath + "/" + board.getSavedfile();
		//서버의 파일을 읽을 입력 스트림과 클라이언트에게 전달할 출력스트림
		FileInputStream fis = null;
		ServletOutputStream sos = null;
		
		try{
			fis = new FileInputStream(fullPath);
			sos = response.getOutputStream();
			
			FileCopyUtils.copy(fis, sos);
			
			fis.close();
			sos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
