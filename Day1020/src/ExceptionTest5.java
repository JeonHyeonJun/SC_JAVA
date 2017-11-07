import java.util.InputMismatchException;
import java.util.Scanner;

//정수를 입력받다가 정수 아닌거 입력받으면 지금까지 받은 정수 합 구하기
public class ExceptionTest5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;

		try {
			//탈출 못할거 같지만 예외 발생하면  try가 끝나므로 안에 있던 while도 끝남
			while (true) {
				System.out.print("정수입력: ");
				int a = scan.nextInt();
				sum += a;
			}
		} catch (InputMismatchException e) {
			System.out.println(sum);
		}

	}// main
}// class
