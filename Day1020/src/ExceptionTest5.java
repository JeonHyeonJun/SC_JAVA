import java.util.InputMismatchException;
import java.util.Scanner;

//������ �Է¹޴ٰ� ���� �ƴѰ� �Է¹����� ���ݱ��� ���� ���� �� ���ϱ�
public class ExceptionTest5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;

		try {
			//Ż�� ���Ұ� ������ ���� �߻��ϸ�  try�� �����Ƿ� �ȿ� �ִ� while�� ����
			while (true) {
				System.out.print("�����Է�: ");
				int a = scan.nextInt();
				sum += a;
			}
		} catch (InputMismatchException e) {
			System.out.println(sum);
		}

	}// main
}// class
