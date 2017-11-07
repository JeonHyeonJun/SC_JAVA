import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File a = new File("c:\\RHDSetup.log");
		File b = new File("C:\\Windows");
		File c = new File(".");	//������ġ
		File d = new File("./sub");	// ������ġ�� sub��� ���丮 ./�� ��������
		File e = new File("a.txt");
		
		System.out.println("�����������մϱ�? "+a.exists());
		System.out.println("�����ΰ�? "+a.isFile());
		System.out.println("���丮�ΰ�? "+a.isDirectory());
		System.out.println("�������ִ°�? "+a.canRead());
		System.out.println("�����ִ°�? "+a.canWrite());
		System.out.println("���ϸ�: "+a.getName());
		System.out.println("���+����: "+a.getPath());
		System.out.println("ũ��: "+a.length());
		
		try {
			System.out.println("����ǰ� �ִ� ��ġ: "+a.getCanonicalPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(d.isDirectory());
		d.mkdir();	// sub��������
		System.out.println(d.isDirectory());
		
		try {
			e.createNewFile();	//a.txt���ϻ���
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}//main
}//class
