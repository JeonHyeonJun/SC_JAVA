import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest1 {
	public static void main(String[] args) {
		FileOutputStream fout;	//byte단위로 프로그램에서 하드디스크로 보내기 위한 메소드
		FileWriter writer;	//문자단위로 프로그램에서 하드디스크로 보내기 위한 메소드
		
		try {
			fout = new FileOutputStream("./a1.txt");
			//앞에거 다 짤라먹고 뒤에 1byte 씩만 저장한다.
			fout.write(65);
			fout.write('B');
			fout.write('거');	//한글은 2byte기 때문에 짤려서 영어p의 코드값이 나와서 p로 저장됨.
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
		try {
			writer = new FileWriter("./a2.txt");
			writer.write(65);	//영어,숫자는 1byte로 저장
			writer.write('B');
			writer.write('\r');	//windows에선 얘랑
			writer.write('\n');	//얘를같이 써야 줄바꿈
			writer.write('거');	//한글은 2byte로 저장해줌.
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}//main
}//class
