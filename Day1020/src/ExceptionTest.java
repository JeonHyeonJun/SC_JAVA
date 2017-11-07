import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a, b, c;
		
		try {
			a = scan.nextInt();
			b = scan.nextInt();
			c = a/b;
			System.out.println(c);
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력 가능합니다.");
		} catch (ArithmeticException e) {
			System.out.println("0은 나눌 수 없습니다.");
			return;	//return으로 현재 메소드를 종료시키더라도 finally에 있는건 실행하고 종료한다.
		} catch (Exception e) {
			// 상속관계가 있는 예외객체를 놓을땐 상위클래스가 밑에 있어야 한다.
			// 그렇게 해야 앞에서 거르고 남은 것들을 걸러 줄 수 있다.
			System.out.println("기타예외");
		} finally {
			System.out.println("프로그램이 종료됩니다.");
		}
		
		
		System.out.println("끝");
		
		
	}
}
