
public class Test3 {
	public static void main(String[] args) {
		//�⺻������ �����Ұ���
		//Account ac = new Account();
		
		//���¹�ȣ�� �̸��� �Է¹޴� ������
		Account ac1 = new Account(1, "��ö��");
		
		//���¹�ȣ,�̸�,�ܾ��� �Է¹޴� ������
		Account ac2 = new Account(2, "�̿���", 10000);
		
		//�̸��� �����ϴ� �޼ҵ�
		System.out.println(ac2.getName());
		
		//�ܾ׺���Ұ���
		//ac2.balance = 1000;
		//ac2.setBalance(1000);
		
		//�Ա�
		ac2.deposit(1000);
		System.out.println(ac2.getBalance());
		
		//���
		ac2.withdraw(2000);
		System.out.println(ac2.getBalance());
		
		//��ü�������
		ac2.print();
	}
}
