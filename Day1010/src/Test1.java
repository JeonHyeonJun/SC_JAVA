import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� : ");
		int num = scan.nextInt();
		
		if(num%3==0 && num%5==0) {
			System.out.println("3�� 5�� ����Դϴ�.");
		}
		else if(num%3==0) {
			System.out.println("3�� ����Դϴ�.");
		}
		else if(num%5==0) {
			System.out.println("5�� ����Դϴ�.");
		}
		else {
			System.out.println("3�� ����� 5�� ����� �ƴմϴ�.");
		}
	}
}
