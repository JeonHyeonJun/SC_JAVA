package mkdir;

import java.util.Scanner;

public class SESUI {
	private static Scanner sc = new Scanner(System.in);
	private SESManager manager = new SESManager();
	
	public SESUI() {
		while(true) {
			printMainMenu();
	
			int select = sc.nextInt();
	
			switch (select) {
			case 1:
				insertHuman();
				break;
			case 2:
				find_human();
				break;
			case 3:
				delete_human();
				break;
			case 4:
				manager.showAll();
				break;
			case 9:
				return;
			default:
				break;
			}
		}
	}

	private void insertHuman() {
		while(true) {
			printInsertMenu();
	
			int select = sc.nextInt();
	
			switch (select) {
			case 1:
			case 2:
			case 3:
				Human h = makeHuman(select);
				if(manager.insertHuman(h))
					System.out.println("��ϿϷ�");
				else
					System.out.println("�ֹι�ȣ�ߺ�");
				break;
			case 4:
				return;
			default:
				break;
			}
		}
	}

	private Human makeHuman(int select) {
		Human h = null;
		sc.nextLine();
		String name = getUserName();
		int age = getUserAge();
		sc.nextLine();
		String jumin = getUserJumin();
		switch (select) {
		case 1:
			System.out.print("|����| ");
			String major = sc.nextLine();
			h = new Professor(name, age, jumin, major);
			break;
		case 2:
			System.out.print("|�й�| ");
			String stuNum = sc.nextLine();
			h = new Trainee(name, age, jumin, stuNum);
			break;
		case 3:
			System.out.print("|�μ�| ");
			String field = sc.nextLine();
			h = new Staff(name, age, jumin, field);
			break;
		}
		return h;
	}
	
	private void find_human() {
		sc.nextLine();
		String jumin = getUserJumin();
		Human h = manager.find_h(jumin);
		if(h == null)
			System.out.println("�˻� ����� �����ϴ�.");
		else
			System.out.println(h);
	}
	
	private void delete_human() {
		sc.nextLine();
		String jumin = getUserJumin();
		if(manager.deleteHuman(jumin))
			System.out.println("�����Ǿ����ϴ�.");
		else
			System.out.println("���������ʴ� �ֹι�ȣ�Դϴ�.");
	}
	
	private String getUserName() {
		System.out.print("|�̸�| ");
		String name = sc.nextLine();
		return name;
	}
	
	private int getUserAge() {
		while(true) {
			try {
				System.out.print("|����| ");
				int age = sc.nextInt();
				return age;
			} catch (Exception e) {
				System.out.println("������ �Է����ּ���");
				sc.nextLine();
			}
		}
	}
	
	private String getUserJumin() {
		while(true) {
			System.out.print("|�ֹι�ȣ(���ڸ�)| ");
			String jumin = sc.nextLine();
			if(jumin.length() == 13)
				return jumin;
			System.out.println("�ֹι�ȣ ������ ��ġ���� �ʽ��ϴ�.");
		}
	}
	private void printMainMenu() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("�� Soft Engineer School ���� �ý��ۦ�");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1.���                                                  ��");
		System.out.println("��2.ã��                                                  ��");
		System.out.println("��3.����                                                  ��");
		System.out.println("��4.��ü���                                            ��");
		System.out.println("��9.����                                                  ��");
		System.out.println("����������������������������������������������������������������");
		System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");
	}

	private void printInsertMenu() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("��        SES �����ο� ���                 ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��1.����                                                  ��");
		System.out.println("��2.������                                               ��");
		System.out.println("��3.���                                               ��");
		System.out.println("��4.�����޴�                                            ��");
		System.out.println("����������������������������������������������������������������");
		System.out.print(" �޴� ��ȣ�� �����ϼ���=> ");
	}
}
