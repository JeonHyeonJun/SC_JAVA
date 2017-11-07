import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		//ArrayList<String> list = new ArrayList<>(); // 뒤<>는 비워도 됨
		
		while(true) {
			System.out.print("문자열입력: ");
			String s = scan.nextLine();
			if(s.isEmpty()) {
				System.out.println("입력이 완료 되었습니다.");
				break;
			}
			list.add(s);	//저장시 String의 하위타입은 가능하나 다른타입이나 상위타입은 안됨
		}
		
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.contains("aaa"));
		System.out.println(list.indexOf("aaa"));
		System.out.println(list.remove(0));
		System.out.println(list);
		
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
		Collections.sort(list);
		System.out.println(list);
	}
}
