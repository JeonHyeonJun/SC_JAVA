/*
[����] ȸ���� ��ȭ��ȣ�� �ּҸ� ���, �˻��� �� �ִ� ���α׷��� �ۼ��Ͻÿ�.

[����]
- ������ ���� Person Ŭ������ �����Ͽ� ȸ�� 1���� ������ ���� �� �ְ� �Ѵ�.
	ȸ���ּҷ� ���α׷����� �Ѹ��� ȸ�������� ��Ÿ���� Ŭ����.
	ȸ����ȣ, �̸�, ��ȭ��ȣ, �ּ� �̷��� 3������ �Ӽ��� ������.
	��� �ʵ�� ���� �����ڰ� private�̸�, 
	�� �ʵ��� ���� �����ϴ� Setter�� �� �ʵ��� ���� �о �����ϴ� Getter�� ������.
	�⺻�����ڿ� ��� �ʵ尪�� ���޹޾� �ʱ�ȭ�ϴ� �����ڸ� ������.
	�� �ʵ��� ���� ������ ���� ����ϴ� print()�޼ҵ带 �����Ѵ�.   
	
- �޴��� ����ϰ� �޴� ��ȣ�� �Է¹޾� �ش� ����� �����Ѵ�.
- 0�� �޴��� ������ ������ ���α׷��� �ݺ��ȴ�.
- ȸ�������� ���� 10��¥��  Person�迭�� �����Ͽ� �����Ѵ�.
	��) Person p[] = new Person[10];
	    p[0] = new Person(1, "ȫ�浿", "010-111-2222", "�����");
	    p[0].print();
	    
- 10���� ��ϵǸ� 1�� �޴��� �������� ��, ���̻� ����� �� ���ٴ� �޽����� ����Ѵ�.
- �˻� ����� ȸ�� �̸��� �Է¹޾�, ��ϵ� ��� ȸ���� ���� �� ã���� ȸ�� ������ ����Ѵ�.

[���� ��]

[ ȸ�� �ּҷ� ]
1. ȸ�� ���� ���
2. ��ü ȸ�� ����
3. ȸ�� ���� �˻�
0. ���α׷� ����
�޴� ��ȣ ����> 1

ȸ�� ��ȣ : 1
�̸� : ȫ�浿
��ȭ��ȣ : 010-111-1111
�ּ� : �����

[ ȸ�� �ּҷ� ]
1. ȸ�� ���� ���
2. ��ü ȸ�� ����
3. ȸ�� ���� �˻�
0. ���α׷� ����
�޴� ��ȣ ����> 1

ȸ�� ��ȣ : 2
�̸� : ��ö��
��ȭ��ȣ : 010-222-2222
�ּ� : �λ��

[ ȸ�� �ּҷ� ]
1. ȸ�� ���� ���
2. ��ü ȸ�� ����
3. ȸ�� ���� �˻�
0. ���α׷� ����
�޴� ��ȣ ����> 2

[ ��ü ȸ�� ��� ]
��ȣ:1	�̸�:ȫ�浿	��ȭ��ȣ:010-111-1111	�ּ�:�����
��ȣ:2	�̸�:��ö��	��ȭ��ȣ:010-222-2222	�ּ�:�λ��

[ ȸ�� �ּҷ� ]
1. ȸ�� ���� ���
2. ��ü ȸ�� ����
3. ȸ�� ���� �˻�
0. ���α׷� ����
�޴� ��ȣ ����> 3

[ ȸ�� �˻� ]
�˻��� ȸ�� �̸� : ��ö��
��ȣ:2	�̸�:��ö��	��ȭ��ȣ:010-222-2222	�ּ�:�λ��

[ ȸ�� �ּҷ� ]
1. ȸ�� ���� ���
2. ��ü ȸ�� ����
3. ȸ�� ���� �˻�
0. ���α׷� ����
�޴� ��ȣ ����> 0
���α׷��� �����մϴ�.

 */

package homework1.basic;

import java.util.Scanner;

public class Hw4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Person addrBook[] = new Person[10];
		int num;
		String name, phone, address;
		int cnt = 0;
		int menu;
		
		while (true) {
			System.out.println("[ ȸ�� �ּҷ� ]");
			System.out.println("1. ȸ�� ���� ���");
			System.out.println("2. ��ü ȸ�� ����");
			System.out.println("3. ȸ�� ���� �˻�");
			System.out.println("0. ���α׷� ����");
			System.out.print("�޴� ��ȣ ����> ");
			
			menu = scan.nextInt();
			switch (menu) {
				case 1:
					if (cnt == addrBook.length) {
						System.out.println("�� �̻� ����� �� �����ϴ�.");
						break;
					}
					System.out.print("ȸ�� ��ȣ : ");
					num = scan.nextInt();
					scan.nextLine();	//���๮�� �ǳʶ�
					System.out.print("�̸� : ");
					name = scan.nextLine();
					System.out.print("��ȭ��ȣ : ");
					phone = scan.nextLine();
					System.out.print("�ּ� : ");
					address = scan.nextLine();
					
					addrBook[cnt] = new Person(num, name, phone, address);
					cnt++;
					break;
					
				case 2:
					System.out.println("[ ��ü ȸ�� ��� ]");
					for (int i = 0; i < cnt; i++) {
						addrBook[i].print();
					}
					break;
				case 3:
					System.out.println("[ ȸ�� �˻� ]");
					System.out.print("�˻��� ȸ�� �̸� : ");
					scan.nextLine();
					name = scan.nextLine();
					
					for (int i = 0; i < cnt; i++) {
						if (addrBook[i].getName().equals(name)) {
							addrBook[i].print();
						}
					}
					break;
					
				case 0:
					System.out.println("���α׷��� �����մϴ�.");
					return;
					
				default:
					System.out.println("�޴� ��ȣ�� �ٽ� �����ϼ���.");
					break;
			}
		}
	}
}
