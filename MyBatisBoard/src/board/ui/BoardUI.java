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
		System.out.println("[ �Խ��� ]");
		System.out.println("1. �۾���");
		System.out.println("2. ��ü�۸��");
		System.out.println("3. �� �б�");
		System.out.println("4. �� ����");
		System.out.println("5. �� �˻�");
		System.out.println("6. �� ����");
		System.out.println("9. ���α׷�����");
		System.out.print("* �޴���ȣ ����> ");
	}
	
	//�����Է�+����ó��
	public int getNum() {
		while (true) {
			try {
				int select = scan.nextInt();
				scan.nextLine();
				return select;
			} catch (Exception e) {
				scan.nextLine();
				System.out.println("���ڷ��Է�");
			}
		}
	}
	
	//�۾���
	public void insertBoard() {
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
		ArrayList<Board> list = boardDao.selectAllBoard();
		for (Board board : list) {
			System.out.println(board);
		}
	}
	
	//�� �б�
	public void readBoard() {
		System.out.print("�۹�ȣ: ");
		int boardnum = getNum();
		Board b = boardDao.selectBoard(boardnum);
		if(b != null) {
			boardDao.updateHits(boardnum);
			System.out.println(b.getContent());
		}
		else
			System.out.println("�������� �ʴ� �۹�ȣ�Դϴ�.");
	}
	
	//�� ����
	public void deleteBoard() {
		System.out.print("�۹�ȣ: ");
		int boardnum = getNum();
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
		System.out.print("�۹�ȣ: ");
		int boardnum = getNum();
		Board b = boardDao.selectBoard(boardnum);
		if(b != null)
			System.out.println(b);
		else
			System.out.println("�������� �ʴ� �۹�ȣ�Դϴ�.");
	}
	
	//�� ����
	public void updateBoard() {
		System.out.print("�۹�ȣ: ");
		int boardnum = getNum();
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
}
