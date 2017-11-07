import java.util.ArrayList;
import java.util.Scanner;

/*
0�� �Է¹��������� ������ �Է¹޾� �հ踦 ���ϴ� ���α׷�
[���� ��]
�����Է�: 1
�����Է�: 2
�����Է�: 3
�����Է�: 0
�հ�: 6
 */
public class ArrayListTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		
		while(true) {
			System.out.print("�����Է�: ");
			int num = scan.nextInt();
			if(num == 0)
				break;
			list.add(num);	//int���� �־ �ڵ����� Integer�� ��ȯ���ֱ� ������
							//new Integer(num) �� �־� �� �Ͱ� ����.
		}
		
		System.out.println(list);
		System.out.println(list.get(0));	//list.get(0).intValue() �� �ڵ����� ���ش�.
		System.out.println(list.get(0) instanceof Integer);
		System.out.println(list.get(0).getClass());	//list.get(0)�� class�� �˷��ش�.
		
		int sum = 0;	//�հ踦 ������ ����
		
		for(int i=0; i<list.size(); i++) {
			sum += list.get(i);	//list�� �ִ� ���� �ϳ��� �޾Ƽ� sum�� ����
		}
		System.out.println("�հ�: "+sum);
	}
}

