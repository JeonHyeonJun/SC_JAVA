import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOTest7 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("rrr");
		list.add("ooo");
		
		ArrayList<String> list2 = new ArrayList<>();
		
		ObjectOutputStream out = null;
//		FileOutputStream out = null;
		
		
			try {
				out = new ObjectOutputStream(new FileOutputStream("test.dat"));
				out.writeObject(list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			out = new FileOutputStream("test.dat");
		
	}//main
}//class
