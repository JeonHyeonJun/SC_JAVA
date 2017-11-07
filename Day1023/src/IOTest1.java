import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest1 {
	public static void main(String[] args) {
		FileOutputStream fout;	//byte������ ���α׷����� �ϵ��ũ�� ������ ���� �޼ҵ�
		FileWriter writer;	//���ڴ����� ���α׷����� �ϵ��ũ�� ������ ���� �޼ҵ�
		
		try {
			fout = new FileOutputStream("./a1.txt");
			//�տ��� �� ©��԰� �ڿ� 1byte ���� �����Ѵ�.
			fout.write(65);
			fout.write('B');
			fout.write('��');	//�ѱ��� 2byte�� ������ ©���� ����p�� �ڵ尪�� ���ͼ� p�� �����.
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
		try {
			writer = new FileWriter("./a2.txt");
			writer.write(65);	//����,���ڴ� 1byte�� ����
			writer.write('B');
			writer.write('\r');	//windows���� ���
			writer.write('\n');	//�긦���� ��� �ٹٲ�
			writer.write('��');	//�ѱ��� 2byte�� ��������.
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//main
}//class
