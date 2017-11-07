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
			System.out.println("������ �Է� �����մϴ�.");
		} catch (ArithmeticException e) {
			System.out.println("0�� ���� �� �����ϴ�.");
			return;	//return���� ���� �޼ҵ带 �����Ű���� finally�� �ִ°� �����ϰ� �����Ѵ�.
		} catch (Exception e) {
			// ��Ӱ��谡 �ִ� ���ܰ�ü�� ������ ����Ŭ������ �ؿ� �־�� �Ѵ�.
			// �׷��� �ؾ� �տ��� �Ÿ��� ���� �͵��� �ɷ� �� �� �ִ�.
			System.out.println("��Ÿ����");
		} finally {
			System.out.println("���α׷��� ����˴ϴ�.");
		}
		
		
		System.out.println("��");
		
		
	}
}
