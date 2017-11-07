import java.io.IOException;
import java.util.Scanner;

public class ExTest1 {
	public static void main(String[] args) {
		int a, b;
		
		try {
			a = input();
			b = input();
			System.out.println(a + "+" + b + "=" + (a + b));
		} catch (NumberFormatException e) {
			System.out.println("정수아님");
		} catch (IOException e) {
			System.out.println("1~100사이의 정수만 입력가능");
		}
		

	}
	
	//throws를 사용하면 이 메소드를 불러낸 곳에서 예외를 처리해도 됨.
	//NumberFormatException처럼 RuntimeException의 하위Exception은 throws를 안써도 알아서 넣기때문에 생략해도됨
	//그 외 예외는 throws를 붙이거나 여기서 try catch로 처리해 줘야함.
	//throws가 붙어있는 메소드를 overriding할때 더 추가는x, 지우는건o, 더 상위타입예외x
	static int input() throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		int n = 0;
		System.out.print("정수입력: ");
		n = Integer.parseInt(scan.nextLine());
		if(n < 0 || n > 100) { 
			//n이 0보다작고 100보다 크다면 IOException을 만들어서 던짐
			throw new IOException();
		}
		
		return n;
	}
}
