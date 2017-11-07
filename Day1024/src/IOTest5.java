import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//�����о����
public class IOTest5 {
	public static void main(String[] args) {
		BufferedReader br = null;
		String s = null;
		int line = 0;	
		
		try {
			br = new BufferedReader(new FileReader("C:\\docs\\index.html"));
		} catch (FileNotFoundException e) {
			System.out.println("NO����NO����");
			return;
		}
		
		try {
			//���پ� �д� �޼ҵ� readLine()
			while((s = br.readLine()) != null){
				System.out.println(++line+": "+s);	//����Ű ģ���� ���� �����Ƿ� println���� ����ؾ��Ѵ�.
			}
		} catch (IOException e) {
			System.out.println("�б����");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("�ݱ����");
				e.printStackTrace();
			}
		}
		
	}//main
}//class
