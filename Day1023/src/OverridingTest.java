import java.io.EOFException;
import java.io.IOException;

public class OverridingTest {
	int test(int a) throws IOException {
		return 0;
	}
}

class A extends OverridingTest {
//	int test(int a) throws IOException { return 0; }			//o. �Ȱ��� ���°� ����
//	public int test(int a) throws IOException { return 0; }		//o. public�� �� �������̹Ƿ� ����
//	int test() throws IOException { return 0; }					//�����ε���
//	int test(int a) { return 0; }								//o. throws ������ ����
//	int test(int a) throws Exception { return 0; }				//x. Exception�� �� ����Ÿ���̹Ƿ� �ȵ�
//	int test(int a) throws EOFException { return 0; }			//o. EOFException�� �� ����Ÿ���̹Ƿ� ����
}
