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
			int select = getNum("* �޴���ȣ ����> ");

			switch (select) {
			case 1:	//�۾���
				insertBoard();
				break;
			case 2:	//��ü�۸��
				printBoard();
				break;
			case 3:	//�� �б�
				readBoard();
				break;
			case 4:	//�� ����
				deleteBoard();
				break;
			case 5:	//�� �˻�
				searchBoard();
				break;
			case 6:	//�� ����
				updateBoard();
				break;
			case 9:	//����
				return;
			default:	//�׿ܹ�ȣ�Է�
				System.out.println("�ٽ��Է�");
				break;
			}
		}
	}
	
	//�⺻�޴�
	void printMainMenu() {
		System.out.println("[ �Խ���  ]");
		System.out.println("1. �۾���");
		System.out.println("2. ��ü�۸��");
		System.out.println("3. �� �б�");
		System.out.println("4. �� ����");
		System.out.println("5. �� �˻�");
		System.out.println("6. �� ����");
		System.out.println("9. ���α׷�����");
	}
	
	//�����Է�+����ó��
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
	
	//�۾���
	public void insertBoard() {
		System.out.println("[ ����  ]");
		System.out.print("�̸�: ");
		String name = scan.nextLine();
		System.out.print("����: ");
		String title = scan.nextLine();
		System.out.print("����: ");
		String content = scan.nextLine();
		
		Board b = new Board(name, title, content);
		boolean result = boardDao.insertBoard(b);
		if(result)
			System.out.println("��ϿϷ�");
		else
			System.out.println("��Ͻ���");
	}
	
	//��ü�۸��
	public void printBoard() {
		System.out.println("[ ���  ]");
		ArrayList<Board> list = boardDao.selectAllBoard();
		for (Board board : list) {
			System.out.println(board);
		}
	}
	
	//�� �б�
	public void readBoard() {
		System.out.println("[ �б�  ]");
		int boardnum = getNum("�۹�ȣ: ");
		Board b = boardDao.selectBoard(boardnum);
		if(b != null) {
			boardDao.updateHits(boardnum);
			System.out.println("�۹�ȣ: " +b.getBoardnum());
			System.out.println("�ۼ���: " +b.getName());
			System.out.println("����: " +b.getTitle());
			System.out.println("����: " +b.getContent());
			System.out.println("��ȸ��: " +b.getHits());
			System.out.println("�ۼ���: " +b.getIndate());
			
			ArrayList<Reply> replyList = replyDao.selectAllReply(boardnum);
			System.out.println("------------------------------------------");
			System.out.println("��� "+replyList.size()+"��");
			for (Reply reply : replyList) {
				System.out.println("�ۼ���:" +reply.getName()+ "|����:"+reply.getRetext());
			}
			insertReply(boardnum);
		}
		else
			System.out.println("�������� �ʴ� �۹�ȣ�Դϴ�.");
	}
	
	//�� ����
	public void deleteBoard() {
		System.out.println("[ ����  ]");
		int boardnum = getNum("�۹�ȣ: ");
		Board b = boardDao.selectBoard(boardnum);
		if(b != null) {
			boardDao.deleteBoard(boardnum);
			System.out.println("�����Ǿ����ϴ�.");
		}
		else
			System.out.println("�������� �ʴ� �۹�ȣ�Դϴ�.");
	}
	
	//�� �˻�
	public void searchBoard() {
		System.out.println("[ �˻�  ]");
		int col = getNum("�˻���� (1.���� 2.���� 3.�ۼ��� 4.����)> ");
		
		ArrayList<Board> list = null;
		System.out.print("�˻���: ");
		String word = scan.nextLine();
		list = boardDao.search(col, word);
		if(list.size() == 0) {
			System.out.println("�˻������ �����ϴ�.");
			return;
		}
		for (Board b : list) {
			System.out.println(b);
		}
	}
	
	//�� ����
	public void updateBoard() {
		System.out.println("[ ����  ]");
		int boardnum = getNum("�۹�ȣ: ");
		Board b = boardDao.selectBoard(boardnum);
		if(b != null) {
			System.out.print("����: ");
			String title = scan.nextLine();
			System.out.print("����: ");
			String content = scan.nextLine();
			b.setTitle(title);
			b.setContent(content);
			boardDao.updateBoard(b);
			System.out.println("�����Ϸ�");
		}
		else
			System.out.println("�������� �ʴ� �۹�ȣ�Դϴ�.");
	}
	
	public void insertReply(int boardnum) {
		System.out.println("1. ��۾���");
		System.out.println("2. ����");
		int select = getNum("����> ");
		
		switch (select) {
		case 1:
			System.out.print("�ۼ���: ");
			String name = scan.nextLine();
			System.out.print("��۳���: ");
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
