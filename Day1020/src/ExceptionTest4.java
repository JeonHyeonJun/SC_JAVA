import java.util.Scanner;

public class ExceptionTest4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a,b;
		int n;
		
		
		
		while(true) {
			try {
				System.out.print("�����Է�: ");
				a = scan.nextLine();
				n = Integer.parseInt(a);
				break;
			} catch (NumberFormatException e) {
				System.out.println("���� �ƴѵ���");
				continue;
			}
		}
		
		while(true) {
			try {
				System.out.print("�����Է�: ");
				b = scan.nextLine();
				n += Integer.parseInt(b);
				break;
			} catch (NumberFormatException e) {
				System.out.println("���� �ƴѵ���");
				continue;
			}
		}
		System.out.println(n);
		
	}
}
