import java.util.ArrayList;
import java.util.Scanner;

//p.577 6번문제
//학생관리프로그램. 추가,전체보기,검색,삭제,종료 기능
//학생정보는 이름,주소,전화번호
//검색 삭제는 이름을 기준으로 함
public class Pro22_6 {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> list = new ArrayList<>();
	
	public Pro22_6() {
		list.add(new Student("김철수", "서울", "x"));
		list.add(new Student("박철수", "대구", "010-1234-5678"));
		list.add(new Student("이철수", "부산", "011-123-4567"));
	}
	
	public static void main(String[] args) {
		
		Pro22_6 obj = new Pro22_6();	//Pro22_6 에 있는 메소드들을 main에서 사용하기 위해 선언
		
		while(true) {
			System.out.println("[학생관리]");
			System.out.println("1. 추가");
			System.out.println("2. 전체 학생 보기");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("0. 종료");
			System.out.print("선택> ");
			int select = obj.scan.nextInt();
			
			switch (select) {
			case 1:
				obj.input();
				break;
			case 2:
				obj.print();
				break;
			case 3:
				obj.search();
				break;
			case 4:
				obj.delete();
				break;
			case 0:
				System.out.println("종료.");
				return;
			default:
				break;
			}//switch
		}//while
	}//main
	
	//1.추가 기능을 하는 메소드
	void input() {
		System.out.print("이름: ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("주소: ");
		String addr = scan.nextLine();
		System.out.print("전화번호: ");
		String phone = scan.nextLine();
		
		list.add(new Student(name, addr, phone));
	}
	
	//2.전체학생보기 기능을 하는 메소드
	void print() {
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	//3.검색 기능을 하는 메소드
	void search() {
		System.out.print("이름검색: ");
		scan.nextLine();
		String search = scan.nextLine();
		for (Student student : list) {
			if(search.equals(student.getName()))
				System.out.println(student);
		}
	}
	
	//4.삭제 기능을 하는 메소드
	void delete() {
		System.out.print("이름검색: ");
		scan.nextLine();
		String search = scan.nextLine();
		for (Student student : list) {
			if(search.equals(student.getName())) {
				list.remove(list.indexOf(student));
				break;
			}
		}
	}
	
}//class
