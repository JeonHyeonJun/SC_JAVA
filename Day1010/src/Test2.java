import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수1 입력 : ");
		int num1 = scan.nextInt();
		System.out.print("정수2 입력 : ");
		int num2 = scan.nextInt();
		
		if(num1 >= num2) {
			for(int i=num2; i<=num1; i++) {
				System.out.print(i+" ");
			}
		}
		else {
			for(int i=num1; i<=num2; i++) {
				System.out.print(i+" ");
			}
		}
	}
}
