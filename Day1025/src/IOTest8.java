import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class IOTest8 {
	public static void main(String[] args) {
		String fileName = "test.dat";
		ArrayList<String> list = null;
		ObjectInputStream in = null;
		
		try {
			in = new ObjectInputStream(new FileInputStream(fileName));
			list = (ArrayList<String>)in.readObject();
			System.out.println(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
