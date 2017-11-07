import java.util.ArrayList;
import java.util.Scanner;

//p.577 6������
//�л��������α׷�. �߰�,��ü����,�˻�,����,���� ���
//�л������� �̸�,�ּ�,��ȭ��ȣ
//�˻� ������ �̸��� �������� ��
public class Pro22_6 {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> list = new ArrayList<>();
	
	public Pro22_6() {
		list.add(new Student("��ö��", "����", "x"));
		list.add(new Student("��ö��", "�뱸", "010-1234-5678"));
		list.add(new Student("��ö��", "�λ�", "011-123-4567"));
	}
	
	public static void main(String[] args) {
		
		Pro22_6 obj = new Pro22_6();	//Pro22_6 �� �ִ� �޼ҵ���� main���� ����ϱ� ���� ����
		
		while(true) {
			System.out.println("[�л�����]");
			System.out.println("1. �߰�");
			System.out.println("2. ��ü �л� ����");
			System.out.println("3. �˻�");
			System.out.println("4. ����");
			System.out.println("0. ����");
			System.out.print("����> ");
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
				System.out.println("����.");
				return;
			default:
				break;
			}//switch
		}//while
	}//main
	
	//1.�߰� ����� �ϴ� �޼ҵ�
	void input() {
		System.out.print("�̸�: ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.print("�ּ�: ");
		String addr = scan.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String phone = scan.nextLine();
		
		list.add(new Student(name, addr, phone));
	}
	
	//2.��ü�л����� ����� �ϴ� �޼ҵ�
	void print() {
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	//3.�˻� ����� �ϴ� �޼ҵ�
	void search() {
		System.out.print("�̸��˻�: ");
		scan.nextLine();
		String search = scan.nextLine();
		for (Student student : list) {
			if(search.equals(student.getName()))
				System.out.println(student);
		}
	}
	
	//4.���� ����� �ϴ� �޼ҵ�
	void delete() {
		System.out.print("�̸��˻�: ");
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
