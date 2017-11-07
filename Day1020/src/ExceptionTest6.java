import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		int sum = 0;
		
		while(cnt < 10) {
			try {
				System.out.print("정수입력: ");
				int a = scan.nextInt();
				sum += a;
				cnt++;
			} catch (InputMismatchException e) {
				scan.nextLine();	//이거 안써주면 무한반복됨.
			}
		}
		
		System.out.println(sum);
	}
}
