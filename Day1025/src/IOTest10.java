import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IOTest10 {
	public static void main(String[] args) {
		String fileName = "TestData.dat";
		ArrayList<TestData> list = new ArrayList<>();
		
		ObjectInputStream in = null;
		
		try {
			in = new ObjectInputStream(new FileInputStream(fileName));
			while(true) {
				list.add((TestData)in.readObject());	//�� �̻� ������ ���ٸ� EOFException�� �߻��Ѵ�.
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println(list);	//EOFException�� �߻��ϸ� ���� list ���
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}//main
}//class
