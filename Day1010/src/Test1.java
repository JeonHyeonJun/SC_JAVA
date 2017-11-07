import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		if(num%3==0 && num%5==0) {
			System.out.println("3과 5의 배수입니다.");
		}
		else if(num%3==0) {
			System.out.println("3의 배수입니다.");
		}
		else if(num%5==0) {
			System.out.println("5의 배수입니다.");
		}
		else {
			System.out.println("3의 배수도 5의 배수도 아닙니다.");
		}
	}
}
