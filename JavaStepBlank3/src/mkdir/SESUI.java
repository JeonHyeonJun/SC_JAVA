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
					System.out.println("등록완료");
				else
					System.out.println("주민번호중복");
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
			System.out.print("|전공| ");
			String major = sc.nextLine();
			h = new Professor(name, age, jumin, major);
			break;
		case 2:
			System.out.print("|학번| ");
			String stuNum = sc.nextLine();
			h = new Trainee(name, age, jumin, stuNum);
			break;
		case 3:
			System.out.print("|부서| ");
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
			System.out.println("검색 결과가 없습니다.");
		else
			System.out.println(h);
	}
	
	private void delete_human() {
		sc.nextLine();
		String jumin = getUserJumin();
		if(manager.deleteHuman(jumin))
			System.out.println("삭제되었습니다.");
		else
			System.out.println("존재하지않는 주민번호입니다.");
	}
	
	private String getUserName() {
		System.out.print("|이름| ");
		String name = sc.nextLine();
		return name;
	}
	
	private int getUserAge() {
		while(true) {
			try {
				System.out.print("|나이| ");
				int age = sc.nextInt();
				return age;
			} catch (Exception e) {
				System.out.println("정수로 입력해주세요");
				sc.nextLine();
			}
		}
	}
	
	private String getUserJumin() {
		while(true) {
			System.out.print("|주민번호(숫자만)| ");
			String jumin = sc.nextLine();
			if(jumin.length() == 13)
				return jumin;
			System.out.println("주민번호 형식이 일치하지 않습니다.");
		}
	}
	private void printMainMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│ Soft Engineer School 관리 시스템│");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.등록                                                  │");
		System.out.println("│2.찾기                                                  │");
		System.out.println("│3.삭제                                                  │");
		System.out.println("│4.전체출력                                            │");
		System.out.println("│9.종료                                                  │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}

	private void printInsertMenu() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│        SES 관리인원 등록                 │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│1.교수                                                  │");
		System.out.println("│2.연수생                                               │");
		System.out.println("│3.운영진                                               │");
		System.out.println("│4.상위메뉴                                            │");
		System.out.println("└──────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}
}
