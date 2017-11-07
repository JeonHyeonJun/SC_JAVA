import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//파일생성해서 내용입력하고 저장하기
public class IOTest3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = null;
		int cnt = 1;
		String fileName, fileContent;

		while (true) {
			System.out.print("저장할 파일명: ");
			fileName = scan.nextLine();
			File f = new File(fileName);
			if (f.isFile())
				System.out.println("이미 사용중인 이름입니다.");
			else
				break;
		} // while

		try {
			bw = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e) {
			System.out.println("파일 생성 오류");
			e.printStackTrace();
		}
		System.out.println("내용을 입력하세요.");

		try {
			while (true) {
				System.out.print(cnt + ": ");
				fileContent = scan.nextLine();
				if (fileContent.isEmpty())
					break;
				bw.write(fileContent);
				bw.newLine();
				bw.flush();
				cnt++;
			}
			
		} catch (IOException e) {
			System.out.println("파일쓰기오류");
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}// main
}// class
