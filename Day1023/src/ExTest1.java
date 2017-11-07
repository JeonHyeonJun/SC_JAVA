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
			System.out.println("�����ƴ�");
		} catch (IOException e) {
			System.out.println("1~100������ ������ �Է°���");
		}
		

	}
	
	//throws�� ����ϸ� �� �޼ҵ带 �ҷ��� ������ ���ܸ� ó���ص� ��.
	//NumberFormatExceptionó�� RuntimeException�� ����Exception�� throws�� �Ƚᵵ �˾Ƽ� �ֱ⶧���� �����ص���
	//�� �� ���ܴ� throws�� ���̰ų� ���⼭ try catch�� ó���� �����.
	//throws�� �پ��ִ� �޼ҵ带 overriding�Ҷ� �� �߰���x, ����°�o, �� ����Ÿ�Կ���x
	static int input() throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		int n = 0;
		System.out.print("�����Է�: ");
		n = Integer.parseInt(scan.nextLine());
		if(n < 0 || n > 100) { 
			//n�� 0�����۰� 100���� ũ�ٸ� IOException�� ���� ����
			throw new IOException();
		}
		
		return n;
	}
}
