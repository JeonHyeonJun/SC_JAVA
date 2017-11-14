package board.ui;

import java.util.ArrayList;
import java.util.Scanner;

import board.dao.BoardDAO;
import board.dao.ReplyDAO;
import board.vo.Board;
import board.vo.Reply;

public class BoardUI {
	BoardDAO boardDao = new BoardDAO();
	ReplyDAO replyDao = new ReplyDAO();
	Scanner scan = new Scanner(System.in);

	public BoardUI() {
		while (true) {
			printMainMenu();
			int select = getNum("* 메뉴번호 선택> ");

			switch (select) {
			case 1:	//글쓰기
				insertBoard();
				break;
			case 2:	//전체글목록
				printBoard();
				break;
			case 3:	//글 읽기
				readBoard();
				break;
			case 4:	//글 삭제
				deleteBoard();
				break;
			case 5:	//글 검색
				searchBoard();
				break;
			case 6:	//글 수정
				updateBoard();
				break;
			case 9:	//종료
				return;
			default:	//그외번호입력
				System.out.println("다시입력");
				break;
			}
		}
	}
	
	//기본메뉴
	void printMainMenu() {
		System.out.println("[ 게시판  ]");
		System.out.println("1. 글쓰기");
		System.out.println("2. 전체글목록");
		System.out.println("3. 글 읽기");
		System.out.println("4. 글 삭제");
		System.out.println("5. 글 검색");
		System.out.println("6. 글 수정");
		System.out.println("9. 프로그램종료");
	}
	
	//숫자입력+예외처리
	public int getNum(String msg) {
		while (true) {
			try {
				System.out.print(msg);
				int select = scan.nextInt();
				scan.nextLine();
				return select;
			} catch (Exception e) {
				scan.nextLine();
			}
		}
	}
	
	//글쓰기
	public void insertBoard() {
		System.out.println("[ 쓰기  ]");
		System.out.print("이름: ");
		String name = scan.nextLine();
		System.out.print("제목: ");
		String title = scan.nextLine();
		System.out.print("내용: ");
		String content = scan.nextLine();
		
		Board b = new Board(name, title, content);
		boolean result = boardDao.insertBoard(b);
		if(result)
			System.out.println("등록완료");
		else
			System.out.println("등록실패");
	}
	
	//전체글목록
	public void printBoard() {
		System.out.println("[ 목록  ]");
		ArrayList<Board> list = boardDao.selectAllBoard();
		for (Board board : list) {
			System.out.println(board);
		}
	}
	
	//글 읽기
	public void readBoard() {
		System.out.println("[ 읽기  ]");
		int boardnum = getNum("글번호: ");
		Board b = boardDao.selectBoard(boardnum);
		if(b != null) {
			boardDao.updateHits(boardnum);
			System.out.println("글번호: " +b.getBoardnum());
			System.out.println("작성자: " +b.getName());
			System.out.println("제목: " +b.getTitle());
			System.out.println("내용: " +b.getContent());
			System.out.println("조회수: " +b.getHits());
			System.out.println("작성일: " +b.getIndate());
			
			ArrayList<Reply> replyList = replyDao.selectAllReply(boardnum);
			System.out.println("------------------------------------------");
			System.out.println("댓글 "+replyList.size()+"개");
			for (Reply reply : replyList) {
				System.out.println("작성자:" +reply.getName()+ "|내용:"+reply.getRetext());
			}
			insertReply(boardnum);
		}
		else
			System.out.println("존재하지 않는 글번호입니다.");
	}
	
	//글 삭제
	public void deleteBoard() {
		System.out.println("[ 삭제  ]");
		int boardnum = getNum("글번호: ");
		Board b = boardDao.selectBoard(boardnum);
		if(b != null) {
			boardDao.deleteBoard(boardnum);
			System.out.println("삭제되었습니다.");
		}
		else
			System.out.println("존재하지 않는 글번호입니다.");
	}
	
	//글 검색
	public void searchBoard() {
		System.out.println("[ 검색  ]");
		int col = getNum("검색대상 (1.제목 2.내용 3.작성자 4.전부)> ");
		
		ArrayList<Board> list = null;
		System.out.print("검색어: ");
		String word = scan.nextLine();
		list = boardDao.search(col, word);
		if(list.size() == 0) {
			System.out.println("검색결과가 없습니다.");
			return;
		}
		for (Board b : list) {
			System.out.println(b);
		}
	}
	
	//글 수정
	public void updateBoard() {
		System.out.println("[ 수정  ]");
		int boardnum = getNum("글번호: ");
		Board b = boardDao.selectBoard(boardnum);
		if(b != null) {
			System.out.print("제목: ");
			String title = scan.nextLine();
			System.out.print("내용: ");
			String content = scan.nextLine();
			b.setTitle(title);
			b.setContent(content);
			boardDao.updateBoard(b);
			System.out.println("수정완료");
		}
		else
			System.out.println("존재하지 않는 글번호입니다.");
	}
	
	public void insertReply(int boardnum) {
		System.out.println("1. 댓글쓰기");
		System.out.println("2. 이전");
		int select = getNum("선택> ");
		
		switch (select) {
		case 1:
			System.out.print("작성자: ");
			String name = scan.nextLine();
			System.out.print("댓글내용: ");
			String retext = scan.nextLine();
			Reply r = new Reply(boardnum, name, retext);
			replyDao.insertReply(r);
			break;
		case 2:
			return;
		default:
			break;
		}
	}
}
