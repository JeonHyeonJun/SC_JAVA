import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//실습
/* [실행 예]
 * 1. abc
 * 2. 가나다
 * 3. a1b2
 * 4.
 * 저장하시겠습니까? (y/n) y
 * 파일명: a.txt
 * 이미 존재하는 파일명입니다. 덮어쓰시겠습니까? (y/n) y
 * a.txt 파일이 저장되었습니다.
 */
public class IOTest6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = null;	//쓴거 파일에 저장하기 위한 writer
		String fileName, fileContent;	//파일명, 파일내용 저장할 String변수
		File tmp = null;	//임시파일 생성용 
		int line = 0;		//줄

		System.out.println("내용을 입력하세요.");
//		File tmp = new File("tmp.txt");
		
		try {
			tmp = File.createTempFile("tmp", "txt");	//임시파일 생성. 눈엔 안보이네
			bw = new BufferedWriter(new FileWriter(tmp));	//파일 쓰기 위해 생성
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			while (true) {
				System.out.print(++line + ": ");	
				fileContent = scan.nextLine();	//내용쓰기
				
				if (fileContent.isEmpty()) break;	//파일내용이 빈칸이라면 반복종료
				
				bw.write(fileContent);	//쓴 내용 파일에 담아놓기(아직 저장한거 아님)
				bw.newLine();	//줄바꿈
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();	//쓴 내용 다 임시파일에 저장 후 writer 닫음
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		while(true) {
			System.out.print("저장하시겠습니까? (y/n) ");
			String select = scan.nextLine();	//저장선택
			
			//저장할시
			if(select.equals("y")) {
				System.out.print("파일명 : ");
				fileName = scan.nextLine();	//파일명입력
				File f = new File(fileName);
				//파일명이 존재한다면
				if(f.isFile()) {
					while(true) {
						System.out.print("이미 존재하는 파일명입니다. 덮어쓰시겠습니까? (y/n) ");
						select = scan.nextLine();	//덮어쓰기선택
						//덮어쓸시
						if(select.equals("y")) {
							f.delete();	//원래 있던 파일명의 파일삭제
							tmp.renameTo(f);	//임시파일을 입력한 파일명으로 변경
							System.out.println(fileName+" 파일이 저장되었습니다.");
							break;
						}
						//안덮어쓸시
						else if(select.equals("n")) 
							break;
					}
					break;
				}
				//파일명이 존재안한다면
				else {
					tmp.renameTo(f);	//임시파일을 입력한 파일명으로 변경
					System.out.println(fileName+" 파일이 저장되었습니다.");
					break;
				}
			} 
			//저장안할시
			else if(select.equals("n")) 
				break;
		}

	}// main
}// class
