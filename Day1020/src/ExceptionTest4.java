import java.util.Scanner;

public class ExceptionTest4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a,b;
		int n;
		
		
		
		while(true) {
			try {
				System.out.print("정수입력: ");
				a = scan.nextLine();
				n = Integer.parseInt(a);
				break;
			} catch (NumberFormatException e) {
				System.out.println("정수 아닌데요");
				continue;
			}
		}
		
		while(true) {
			try {
				System.out.print("정수입력: ");
				b = scan.nextLine();
				n += Integer.parseInt(b);
				break;
			} catch (NumberFormatException e) {
				System.out.println("정수 아닌데요");
				continue;
			}
		}
		System.out.println(n);
		
	}
}
