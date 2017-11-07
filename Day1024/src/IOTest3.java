import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//���ϻ����ؼ� �����Է��ϰ� �����ϱ�
public class IOTest3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = null;
		int cnt = 1;
		String fileName, fileContent;

		while (true) {
			System.out.print("������ ���ϸ�: ");
			fileName = scan.nextLine();
			File f = new File(fileName);
			if (f.isFile())
				System.out.println("�̹� ������� �̸��Դϴ�.");
			else
				break;
		} // while

		try {
			bw = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e) {
			System.out.println("���� ���� ����");
			e.printStackTrace();
		}
		System.out.println("������ �Է��ϼ���.");

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
			System.out.println("���Ͼ������");
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
