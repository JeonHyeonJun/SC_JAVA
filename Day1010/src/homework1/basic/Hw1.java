/*
[����] for���� �̿���  Fibonacci ����
�Ǻ���ġ �����̶� ó�� �� ���� 1�� 1�� �� ��, �� ���� �׺��ʹ� �ٷ� ���� �� ���� ���� ���� ����� ������ ���Ѵ�.
���� ������ for���� ����Ͽ� ����Ѵ�.
1  1  2  3  5  8  13  21  34  55   
*/

package homework1.basic;

public class Hw1 {

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 1;
		int i;
		int next = 0;
		for(i = 0; i < 10; i++) {
			System.out.print(num1 + "  ");
			next = num1 + num2;
			num1 = num2;
			num2 = next;
		}
	}

}
