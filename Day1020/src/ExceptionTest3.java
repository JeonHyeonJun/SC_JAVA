import java.io.IOException;

public class ExceptionTest3 {
	//throws�� ����ó���� ���ѱ�
	public static void main(String[] args) throws IOException {
		char ch;
		
		try {
			ch = (char) System.in.read();	//System.in.read()�� throws IOException�� �پ��ֱ� ������
											//����Ϸ��� IOException�� ����ó�� ����߸� ����� �� �ִ�.
											//RuntimeException�� ����Ÿ���� �ƴ� �ٸ� Exception�� ������ �ܰ���� ������ �߻��Ѵ�.
			System.out.println("�Է��� ����: " + ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	//���� �޽��� ���. ������ ��� �޽���
		}
		
		ch = (char) System.in.read();
	}
}
