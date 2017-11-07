import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//�����о����
public class IOTest4 {
	public static void main(String[] args) {
		FileReader fr = null;
		int ch = 0;	//read�޼ҵ带 �����ϱ����� int����
		
		try {
			fr = new FileReader("C:\\docs\\index.html");
		} catch (FileNotFoundException e) {
			System.out.println("NO����NO����");
			return;
		}
		
		try {
			//�Ʒ� �ּ��� ���̸� �̷��� �ȴ�.
			while((ch = fr.read()) != -1) {
//				ch = fr.read();	//�ϳ�����
//				//�������� -1(������ ������ ��ȯ�Ǵ� ��)�̸� �ݺ�������
//				if(ch == -1) 
//					break;	
				System.out.print((char)ch);	//�������� ���
			}
		} catch (IOException e) {
			System.out.println("�б����");
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				System.out.println("�ݱ����");
				e.printStackTrace();
			}
		}
		
	}//main
}//class
