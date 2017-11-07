import javax.swing.JFrame;

public class AbstractTest {
	public static void main(String[] args) {
		A ob = new B();
		ob.test();
		
		A ob2 = new C();
		ob2.test();
	}
	
	//���� Ŭ������ private ������ ��밡��.(�Ϲ� Ŭ������ public �̳� ������ ���°͸� ����)
	private class Inner{
		
	}
}

//�߻�Ŭ���� : �߻�޼ҵ带 �ϳ��� ������ �ִٸ� �߻�Ŭ������ �ȴ�. �߻�Ŭ������ ��ü�� ����� ���� ( A a = new A() �� �ȵ�)
//abstract class A{
//	public abstract void test(); //�߻�޼ҵ� : ����� ���� ���Ǹ� �Ǿ��ִ� �޼ҵ�
//	//abstract �� final�� ���� ��������.
//	//* final�� �޼ҵ� �տ� ���̸� ��ӱ����� �ǹ���.
//	
//}

//�������̽��� �߻�޼ҵ�� ����� �����ִ�.
//abstract�� ���� �ʾƵ� �ڵ����� �߻�޼ҵ�� ��.
//�������̽��� ���߻���� ���� �� �ִ�.
//�������̽��� �߻�Ŭ������ ��������� �߻�Ŭ������ �Ϲݸ޼ҵ嵵 ���������� �������̽��� �߻�޼ҵ常 �����ִ�.
interface A{
	public void test();
}

class B extends JFrame implements A{
	public void test() {
		System.out.println("B���� ����");
	}
}

class C extends JFrame implements A{
	//�θ� �߻�Ŭ������� �߻�޼ҵ带 ��� �������̵� �ؾ��Ѵ�.
	public void test() {
		System.out.println("C���� ����");
	}
}
