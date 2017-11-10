package board.ui;

import java.util.ArrayList;
import java.util.Scanner;

import board.dao.BoardDAO;
import board.vo.Board;

public class BoardUI {
	BoardDAO boardDao = new BoardDAO();
	Scanner scan = new Scanner(System.in);

	public BoardUI() {
		while (true) {
			printMainMenu();
			int select = getNum();

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
		System.out.println("[ 게시판 ]");
		System.out.println("1. 글쓰기");
		System.out.println("2. 전체글목록");
		System.out.println("3. 글 읽기");
		System.out.println("4. 글 삭제");
		System.out.println("5. 글 검색");
		System.out.println("6. 글 수정");
		System.out.println("9. 프로그램종료");
		System.out.print("* 메뉴번호 선택> ");
	}
	
	//숫자입력+예외처리
	public int getNum() {
		while (true) {
			try {
				int select = scan.nextInt();
				scan.nextLine();
				return select;
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("숫자로입력");
			}
		}
	}
	
	//글쓰기
	public void insertBoard() {
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
		ArrayList<Board> list = boardDao.selectAllBoard();
		for (Board board : list) {
			System.out.println(board);
		}
	}
	
	//글 읽기
	public void readBoard() {
		System.out.print("글번호: ");
		int boardnum = getNum();
		Board b = boardDao.selectBoard(boardnum);
		if(b != null) {
			boardDao.updateHits(boardnum);
			System.out.println(b.getContent());
		}
		else
			System.out.println("존재하지 않는 글번호입니다.");
	}
	
	//글 삭제
	public void deleteBoard() {
		System.out.print("글번호: ");
		int boardnum = getNum();
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
		System.out.print("글번호: ");
		int boardnum = getNum();
		Board b = boardDao.selectBoard(boardnum);
		if(b != null)
			System.out.println(b);
		else
			System.out.println("존재하지 않는 글번호입니다.");
	}
	
	//글 수정
	public void updateBoard() {
		System.out.print("글번호: ");
		int boardnum = getNum();
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
}
