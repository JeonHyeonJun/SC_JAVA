import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File a = new File("c:\\RHDSetup.log");
		File b = new File("C:\\Windows");
		File c = new File(".");	//현재위치
		File d = new File("./sub");	// 현재위치에 sub라는 디렉토리 ./는 생략가능
		File e = new File("a.txt");
		
		System.out.println("파일이존재합니까? "+a.exists());
		System.out.println("파일인가? "+a.isFile());
		System.out.println("디렉토리인가? "+a.isDirectory());
		System.out.println("읽을수있는가? "+a.canRead());
		System.out.println("쓸수있는가? "+a.canWrite());
		System.out.println("파일명: "+a.getName());
		System.out.println("경로+파일: "+a.getPath());
		System.out.println("크기: "+a.length());
		
		try {
			System.out.println("실행되고 있는 위치: "+a.getCanonicalPath());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(d.isDirectory());
		d.mkdir();	// sub폴더생성
		System.out.println(d.isDirectory());
		
		try {
			e.createNewFile();	//a.txt파일생성
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}//main
}//class
