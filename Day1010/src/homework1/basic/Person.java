/*
Hw4 Ŭ�������� ���.
ȸ���ּҷ� ���α׷����� �Ѹ��� ȸ�������� ��Ÿ���� Ŭ����.
ȸ����ȣ, �̸�, ��ȭ��ȣ, �ּ� �̷��� 3������ �Ӽ��� ������.
��� �ʵ�� ���� �����ڰ� private�̸�, 
�� �ʵ��� ���� �����ϴ� Setter�� �� �ʵ��� ���� �о �����ϴ� Getter�� ������.
�⺻�����ڿ� ��� �ʵ尪�� ���޹޾� �ʱ�ȭ�ϴ� �����ڸ� ������.
�� �ʵ��� ���� ������ ���� ����ϴ� print()�޼ҵ带 �����Ѵ�.   
 */
package homework1.basic;

public class Person {
	private int num;		//ȸ����ȣ
	private String name;	//�̸�
	private String phone;	//��ȭ��ȣ
	private String address;	//�ּ�

	//������
	public Person() {
	}
	
	public Person(int num, String name, String phone, String address) {
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	//Getters & Setters
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	//��¿� �޼ҵ�
	public void print() {
		System.out.println("��ȣ:" + num + "\t" + "�̸�:" + name + "\t" 
					+ "��ȭ��ȣ:" + phone + "\t" + "�ּ�:" + address);
	}
	
}
