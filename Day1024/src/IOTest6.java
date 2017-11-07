import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//�ǽ�
/* [���� ��]
 * 1. abc
 * 2. ������
 * 3. a1b2
 * 4.
 * �����Ͻðڽ��ϱ�? (y/n) y
 * ���ϸ�: a.txt
 * �̹� �����ϴ� ���ϸ��Դϴ�. ����ðڽ��ϱ�? (y/n) y
 * a.txt ������ ����Ǿ����ϴ�.
 */
public class IOTest6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = null;	//���� ���Ͽ� �����ϱ� ���� writer
		String fileName, fileContent;	//���ϸ�, ���ϳ��� ������ String����
		File tmp = null;	//�ӽ����� ������ 
		int line = 0;		//��

		System.out.println("������ �Է��ϼ���.");
//		File tmp = new File("tmp.txt");
		
		try {
			tmp = File.createTempFile("tmp", "txt");	//�ӽ����� ����. ���� �Ⱥ��̳�
			bw = new BufferedWriter(new FileWriter(tmp));	//���� ���� ���� ����
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			while (true) {
				System.out.print(++line + ": ");	
				fileContent = scan.nextLine();	//���뾲��
				
				if (fileContent.isEmpty()) break;	//���ϳ����� ��ĭ�̶�� �ݺ�����
				
				bw.write(fileContent);	//�� ���� ���Ͽ� ��Ƴ���(���� �����Ѱ� �ƴ�)
				bw.newLine();	//�ٹٲ�
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();	//�� ���� �� �ӽ����Ͽ� ���� �� writer ����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		while(true) {
			System.out.print("�����Ͻðڽ��ϱ�? (y/n) ");
			String select = scan.nextLine();	//���弱��
			
			//�����ҽ�
			if(select.equals("y")) {
				System.out.print("���ϸ� : ");
				fileName = scan.nextLine();	//���ϸ��Է�
				File f = new File(fileName);
				//���ϸ��� �����Ѵٸ�
				if(f.isFile()) {
					while(true) {
						System.out.print("�̹� �����ϴ� ���ϸ��Դϴ�. ����ðڽ��ϱ�? (y/n) ");
						select = scan.nextLine();	//����⼱��
						//�����
						if(select.equals("y")) {
							f.delete();	//���� �ִ� ���ϸ��� ���ϻ���
							tmp.renameTo(f);	//�ӽ������� �Է��� ���ϸ����� ����
							System.out.println(fileName+" ������ ����Ǿ����ϴ�.");
							break;
						}
						//�ȵ����
						else if(select.equals("n")) 
							break;
					}
					break;
				}
				//���ϸ��� ������Ѵٸ�
				else {
					tmp.renameTo(f);	//�ӽ������� �Է��� ���ϸ����� ����
					System.out.println(fileName+" ������ ����Ǿ����ϴ�.");
					break;
				}
			} 
			//������ҽ�
			else if(select.equals("n")) 
				break;
		}

	}// main
}// class
