import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		//ArrayList<String> list = new ArrayList<>(); // ��<>�� ����� ��
		
		while(true) {
			System.out.print("���ڿ��Է�: ");
			String s = scan.nextLine();
			if(s.isEmpty()) {
				System.out.println("�Է��� �Ϸ� �Ǿ����ϴ�.");
				break;
			}
			list.add(s);	//����� String�� ����Ÿ���� �����ϳ� �ٸ�Ÿ���̳� ����Ÿ���� �ȵ�
		}
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.contains("aaa"));
		System.out.println(list.indexOf("aaa"));
		System.out.println(list.remove(0));
		System.out.println(list);
		
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
		Collections.sort(list);
		System.out.println(list);
	}
}
