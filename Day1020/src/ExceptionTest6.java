import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		int sum = 0;
		
		while(cnt < 10) {
			try {
				System.out.print("�����Է�: ");
				int a = scan.nextInt();
				sum += a;
				cnt++;
			} catch (InputMismatchException e) {
				scan.nextLine();	//�̰� �Ƚ��ָ� ���ѹݺ���.
			}
		}
		
		System.out.println(sum);
	}
}
