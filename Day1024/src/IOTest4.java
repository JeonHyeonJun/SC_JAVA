import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//파일읽어오기
public class IOTest4 {
	public static void main(String[] args) {
		FileReader fr = null;
		int ch = 0;	//read메소드를 저장하기위한 int변수
		
		try {
			fr = new FileReader("C:\\docs\\index.html");
		} catch (FileNotFoundException e) {
			System.out.println("NO파일NO실행");
			return;
		}
		
		try {
			//아래 주석을 줄이면 이렇게 된다.
			while((ch = fr.read()) != -1) {
//				ch = fr.read();	//하나읽음
//				//읽은값이 -1(읽을거 없을때 반환되는 값)이면 반복문종료
//				if(ch == -1) 
//					break;	
				System.out.print((char)ch);	//읽은문자 출력
			}
		} catch (IOException e) {
			System.out.println("읽기오류");
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				System.out.println("닫기오류");
				e.printStackTrace();
			}
		}
		
	}//main
}//class
