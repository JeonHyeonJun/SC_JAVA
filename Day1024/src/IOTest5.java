import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//파일읽어오기
public class IOTest5 {
	public static void main(String[] args) {
		BufferedReader br = null;
		String s = null;
		int line = 0;	
		
		try {
			br = new BufferedReader(new FileReader("C:\\docs\\index.html"));
		} catch (FileNotFoundException e) {
			System.out.println("NO파일NO실행");
			return;
		}
		
		try {
			//한줄씩 읽는 메소드 readLine()
			while((s = br.readLine()) != null){
				System.out.println(++line+": "+s);	//엔터키 친것은 읽지 않으므로 println으로 출력해야한다.
			}
		} catch (IOException e) {
			System.out.println("읽기오류");
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("닫기오류");
				e.printStackTrace();
			}
		}
		
	}//main
}//class
