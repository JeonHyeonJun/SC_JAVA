/*
[����] ���ڿ��� ������ �Է¹޾� ����Ͽ� ����� ����Ѵ�.

[����]
- ���ڸ� ���� ������� ��Ģ������ ���Ե� ������ ���ڿ��� �Է¹޴´�.
- ������ �������� �ݵ�� '=' ���ڷ� ������ �Ѵ�.
- ������ �켱 ���� ������� �ʰ� �Էµ� ������� ����Ѵ�.
- 0~9, +, -, *, / �̿��� ���ڰ� ǥ�ԵǾ� ������ �����޽��� ����ϰ� ���α׷��� �����Ѵ�.

[����]
- ���ڿ� Ÿ���� ���ڸ� int������ ��ȯ�ϴ� ����� ������ ����.
  String�� int�� ��ȯ���ִ� IntegerŬ������ �޼ҵ带 �̿��Ѵ�.
  
	String s = "1";
	int i = Integer.parseInt(s);	//i�� 1
	
- ���� Ÿ���� ���ڸ� int������ ��ȯ�ϴ� ����� ������ ����.
  �ش� ������ �����ڵ尪���� ���� '0'�� �����ڵ尪�� ����.
	char c = '1';
	int i = c - '0';		//i�� 1

[���� ��1]
�����Է� : 1+a
������ �߸��Ǿ����ϴ�.

[���� ��2]
�����Է� : 1+2*3
������ �߸��Ǿ����ϴ�.

[���� ��3]
�����Է� : 1+2*3=
����� 9
 */
package homework1.basic;

import java.util.Scanner;

public class Hw3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String exp = null; 		//�Է¹��� ����
		int res = 0; 			//���� ���
		int num = 0; 			//���꿡 ����� ��
		char op = 0; 			//�ֱٿ� ���� ������
		char ch = 0;
		int i;

		//���� �Է¹ޱ�
		System.out.print("�����Է� : ");
		exp = scan.nextLine();
		
		//=��ȣ�� ������ ������ ����
		if (exp.charAt(exp.length() - 1) != '=') {
			System.out.println("������ �߸��Ǿ����ϴ�.");
			return;
		}
		
		//���� ���ڿ��� �ѹ��ھ� �о ó��
		for (i = 0; i < exp.length(); i++) {
			ch = exp.charAt(i); 				//�ѹ��� �б�
			if (ch >= '0' && ch <= '9') { 		//�����̸�
				num = ch - '0'; 				//���ڷ� ��ȯ 
			}
			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=') {
				switch (op) { 					//������ ���� ������
					case 0: res = num; break; 	//���ʿ����ΰ��
					case '+': res += num; break;
					case '-': res -= num; break;
					case '*': res *= num; break;
					case '/': res /= num; break;
				}
				
				if (ch == '=') break; //=���� ������ ����
				op = ch; //���� ���� �����ڸ� ������ ����ϱ� ���� ����
			}
			else {
				System.out.println("������ �߸��Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println("����� " + res);
	}
}
