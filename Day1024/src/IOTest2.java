import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//BufferdWriter테스트
public class IOTest2 {
	public static void main(String[] args) {
//		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
//			fw = new FileWriter("b.txt");
//			bw = new BufferedWriter(fw);
			bw = new BufferedWriter(new FileWriter("b.txt")); //위에 두줄과 동일함
		} catch (IOException e) {
			System.out.println("파일생성오류");
			e.printStackTrace();
		}
		
		try {
			bw.write("실험용b");
//			bw.write("\r\n");	//줄바꿈이지만 java에선 사용하지 않는게 좋다.
								//다른 환경에선 동작하지 않을수 있기 때문에!
			bw.newLine();	//줄바꿈
			bw.write("みんなの　日本語");
//			bw.flush();	//Bufferd에서 지금까지 모은 데이터를 밀어냄
			bw.close();	//다 밀어내고 종료
		} catch (IOException e) {
			System.out.println("파일쓰기오류");
			e.printStackTrace();
		}
		
		System.out.println("파이리 생성되었습니다.");
	}//main
}//class
