import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//BufferdWriter�׽�Ʈ
public class IOTest2 {
	public static void main(String[] args) {
//		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
//			fw = new FileWriter("b.txt");
//			bw = new BufferedWriter(fw);
			bw = new BufferedWriter(new FileWriter("b.txt")); //���� ���ٰ� ������
		} catch (IOException e) {
			System.out.println("���ϻ�������");
			e.printStackTrace();
		}
		
		try {
			bw.write("�����b");
//			bw.write("\r\n");	//�ٹٲ������� java���� ������� �ʴ°� ����.
								//�ٸ� ȯ�濡�� �������� ������ �ֱ� ������!
			bw.newLine();	//�ٹٲ�
			bw.write("�ߪ�ʪΡ�������");
//			bw.flush();	//Bufferd���� ���ݱ��� ���� �����͸� �о
			bw.close();	//�� �о�� ����
		} catch (IOException e) {
			System.out.println("���Ͼ������");
			e.printStackTrace();
		}
		
		System.out.println("���̸� �����Ǿ����ϴ�.");
	}//main
}//class
