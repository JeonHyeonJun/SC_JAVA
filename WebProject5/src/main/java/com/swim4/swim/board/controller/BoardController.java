package com.swim4.swim.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.swim4.swim.board.dao.BoardDAO;
import com.swim4.swim.board.vo.Board;
import com.swim4.swim.board.vo.Reply;
import com.swim4.swim.common.util.FileService;
import com.swim4.swim.common.util.PageNavigator;

@Controller
@RequestMapping(value="board/")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardDAO dao;
	
	final String uploadPath = "/boardfile";	//파일 업로드 경로
	final int countPage = 10;	// 페이지당 글개수
	final int pagePerGroup = 10;	//한번에 나타내는 페이지수
	
	@RequestMapping(value="boardList", method=RequestMethod.GET)
	public String boardList(Model model, 
			@RequestParam(value="searchText", defaultValue="") String searchText
			, String searchType
			,@RequestParam(value="page", defaultValue="1") int page
			,HttpServletRequest request){
		logger.info(request.getRemoteAddr());
		logger.info(new Date().toString());
		logger.info("글 목록 이동 시작");
		HashMap<String, Object> params = new HashMap<>();
		params.put("searchText", searchText);
		params.put("searchType", searchType);
		//전체 게시글 수 구하기
		int total = dao.boardCount(params);
		//페이징에 필요한거 구하는 함수
		PageNavigator pn = new PageNavigator(countPage, pagePerGroup, page, total);
		params.put("startRecord", pn.getStartRecord());
		params.put("countPerPage", pn.getCountPerPage());
		ArrayList<Board> list = dao.boardList(params);
		
		model.addAttribute("searchText", searchText);
		model.addAttribute("searchType", searchType);
		model.addAttribute("boardList", list);
		model.addAttribute("page", pn);
		logger.info("글 목록 이동 종료");
		return "board/boardList";
	}
	
	@RequestMapping(value="boardWriteForm", method=RequestMethod.GET)
	public String boardWriteForm(){
		logger.info("글쓰기 폼 이동 시작");
		logger.info("글쓰기 폼 이동 종료");
		return "board/boardWriteForm";
	}
	
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String boardWrite(Board board, MultipartFile upload){
		logger.info("글쓰기 시작");
		
		//첨부파일이 있는경우
		if(!upload.isEmpty()){
			//Board객체에 originalFileName과 savedfileName을 저장
			logger.info("글쓰기 첨부파일 추가 시작");
			String savedfile = FileService.saveFile(upload, uploadPath);
			board.setSavedfile(savedfile);
			board.setOriginalfile(upload.getOriginalFilename());
			logger.info("글쓰기 첨부파일 추가 종료");
		}
		dao.boardWrite(board);
		logger.info("글쓰기 종료");
		return "redirect:boardList";
	}
	
	@RequestMapping(value="boardRead", method=RequestMethod.GET)
	public String boardRead(int boardnum, Model model
			, HttpSession session, HttpServletResponse response, HttpServletRequest request
			, @RequestParam(value="searchText", defaultValue="") String searchText
			, String searchType
			,@RequestParam(value="page", defaultValue="1") int page){
		
		logger.info("글읽기 시작");
		Board board = dao.selectOneBoard(boardnum);
		if(board == null){
			return "redirect:boardList";
		}
		
		Cookie cookies[] = request.getCookies();
		Cookie readCookie = null;
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("readCookie")){
				readCookie = cookies[i];
			}
		}
		
		if(readCookie == null){
			 logger.info("readCookie 없음");
			 Cookie newCookie = new Cookie("readCookie","|"+boardnum+"|"); 
			 response.addCookie(newCookie);
			 dao.updateHits(boardnum);
		} else {
			logger.info("readCookie 있음");
			String value = readCookie.getValue(); 
			
			if(value.indexOf("|"+boardnum+"|") <  0){ 
				logger.info("안읽은 게시판");
				value = value+"|"+boardnum+"|";
				readCookie.setValue(value);
				response.addCookie(readCookie);
				dao.updateHits(boardnum);
			}
		}
		
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("searchText", searchText);
		params.put("searchType", searchType);
		params.put("page", page);
		ArrayList<Reply> reply = dao.replyList(boardnum);
		model.addAttribute("board", board);
		model.addAttribute("reply", reply);
		model.addAttribute("replyCnt", reply.size());
		model.addAttribute("params", params);
		logger.info("글읽기 종료");
		return "board/boardRead";
	}
	
	@RequestMapping(value="boardDelete", method=RequestMethod.POST)
	public String boardDelete(Board board){
		logger.info("글삭제 시작");
		Board b = dao.selectOneBoard(board.getBoardnum());
		int result = dao.boardDelete(board);
		if(result == 1){
			logger.info("글삭제 첨부파일 삭제 시작");
			FileService.deleteFile(uploadPath+"/"+b.getSavedfile());
			logger.info("글삭제 첨부파일 삭제 시작");
		}
		logger.info("글삭제 종료");
		return "redirect:boardList";
	}
	
	@RequestMapping(value="boardDelete", method=RequestMethod.GET)
	public String boardDeleteFormGet(HttpServletRequest request){
		logger.info("게시글삭제시도!");
		logger.info(request.getRemoteAddr());
		logger.info(new Date().toString());
		return "redirect:../resources/img/podol.gif";
	}
	
	@RequestMapping(value="boardUpdateForm", method=RequestMethod.GET)
	public String boardUpdateFormGet(HttpServletRequest request){
		logger.info("게시글수정시도!");
		logger.info(request.getRemoteAddr());
		logger.info(new Date().toString());
		return "redirect:../resources/img/podol.gif";
	}
	
	@RequestMapping(value="boardUpdateForm", method=RequestMethod.POST)
	public String boardUpdateForm(int boardnum, String id, Model model){
		logger.info("글 수정 폼 시작");
		Board b = dao.selectOneBoard(boardnum);
		if(!b.getId().equals(id)){
			return "redirect:boardList";
		}
		model.addAttribute("board", b);
		logger.info("글수정 폼 종료");
		return "board/boardUpdateForm";
	}
	
	@RequestMapping(value="boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(Board board, MultipartFile upload
			, @RequestParam(value="searchText", defaultValue="") String searchText
			, String searchType
			,@RequestParam(value="page", defaultValue="1") int page){
		logger.info("글 수정 시작");
		if(!upload.isEmpty()){
			logger.info("글수정 첨부파일 추가 시작");
			Board b = dao.selectOneBoard(board.getBoardnum());
			FileService.deleteFile(uploadPath+"/"+b.getSavedfile());
			
			String savedfile = FileService.saveFile(upload, uploadPath);
			board.setOriginalfile(upload.getOriginalFilename());
			board.setSavedfile(savedfile);
			logger.info("글수정 첨부파일 추가 종료");
		}
		dao.boardUpdate(board);
		logger.info("글 수정 종료");
		return "redirect:boardRead?boardnum="+board.getBoardnum()+"&page="+page+"&searchText="+searchText+"&searchType="+searchType;
	}
	
	@RequestMapping(value="download", method=RequestMethod.GET)
	public void fileDownload(int boardnum, HttpServletResponse response){
		Board board = dao.selectOneBoard(boardnum);
		
		//원래 파일명 response Header에 인코딩해서 등록
		String orinalfile = board.getOriginalfile();
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
	
	@RequestMapping(value = "imageShow/{boardnum}", method = RequestMethod.GET)
	public void imageShow(@PathVariable("boardnum") int boardnum , HttpServletResponse response) throws IOException, SerialException, SQLException {
		Board board = dao.selectOneBoard(boardnum);
		String savedfile = board.getSavedfile();
		response.setContentType("images/jpg; utf-8");
		String filename = new String(savedfile.getBytes("UTF-8"),"ISO-8859-1");
		response.setHeader("Content-Disposition", "inline;filename=\"" + filename + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream outputStream = response.getOutputStream();
	
		File file = new File(uploadPath + "/" + savedfile);
	
		FileInputStream inputStream = new FileInputStream(file);
	
		IOUtils.copy(inputStream, outputStream);
	
		outputStream.flush();
		outputStream.close();
	}
	
	@RequestMapping(value="insertReply", method=RequestMethod.POST)
	public String insertReply(Reply reply, HttpSession session
			, @RequestParam(value="searchText", defaultValue="") String searchText
			, String searchType
			,@RequestParam(value="page", defaultValue="1") int page){
		
		logger.info("댓글 등록 시작");
		String id = (String)session.getAttribute("id");
		reply.setId(id);
		
		reply.setText(reply.getText().replace("<", "&lt;"));
		reply.setText(reply.getText().replace(">", "&gt;"));
		reply.setText(reply.getText().replace("\"", "&quot;"));
		reply.setText(reply.getText().replace("\'", "&acute;"));
		dao.insertReply(reply);
		
		if(reply.getParentnum() == 0){
			reply.setGroupnum(reply.getReplynum());
			dao.updateReplyGroup(reply);			
		}
		
		logger.info("댓글 등록 종료");
		return "redirect:boardRead?boardnum="+reply.getBoardnum()+"&page="+page+"&searchText="+searchText+"&searchType="+searchType;
	}
	
	@RequestMapping(value="deleteReply", method=RequestMethod.POST)
	public String deleteReply(Reply reply, HttpSession session
			, @RequestParam(value="searchText", defaultValue="") String searchText
			, String searchType
			,@RequestParam(value="page", defaultValue="1") int page){
		logger.info("댓글 삭제 시작");
		String id = (String) session.getAttribute("id");
		reply.setId(id);
		dao.updateReplyDel(reply);
		logger.info("댓글 삭제 종료");
		return "redirect:boardRead?boardnum="+reply.getBoardnum()+"&page="+page+"&searchText="+searchText+"&searchType="+searchType;
	}
	
	@RequestMapping(value="deleteReply", method=RequestMethod.GET)
	public String deleteReplyGet(HttpServletRequest request){
		logger.info("댓글삭제시도!");
		logger.info(request.getRemoteAddr());
		logger.info(new Date().toString());
		return "redirect:../resources/img/podol.gif";
	}
	
	@RequestMapping(value="updateReply", method=RequestMethod.POST)
	public String updateReply(Reply reply, HttpSession session
			, @RequestParam(value="searchText", defaultValue="") String searchText
			, String searchType
			,@RequestParam(value="page", defaultValue="1") int page){
		logger.info("댓글 수정 시작");
		String id = (String) session.getAttribute("id");
		reply.setId(id);
		reply.setText(reply.getText().replace("<", "&lt;"));
		reply.setText(reply.getText().replace(">", "&gt;"));
		reply.setText(reply.getText().replace("\"", "&quot;"));
		reply.setText(reply.getText().replace("\'", "&acute;"));
		dao.updateReply(reply);
		logger.info("댓글 수정 종료");
		return "redirect:boardRead?boardnum="+reply.getBoardnum()+"&page="+page+"&searchText="+searchText+"&searchType="+searchType;
	}
}
