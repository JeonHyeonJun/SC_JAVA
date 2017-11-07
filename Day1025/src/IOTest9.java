import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IOTest9{
	public static void main(String[] args) {
		TestData a = new TestData("�ʰ��", 1);
		TestData b = new TestData("�°��", 2);
		TestData c = new TestData("�ٰ��", 3);
		
		ObjectOutputStream out = null;
		
		try {
			out = new ObjectOutputStream(new FileOutputStream("TestData.dat"));
			out.writeObject(a);
			out.writeObject(b);
			out.writeObject(c);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//main
}//class
