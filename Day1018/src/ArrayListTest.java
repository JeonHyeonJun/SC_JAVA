import java.util.ArrayList;
import java.util.Scanner;

/*
0을 입력받을때까지 정수를 입력받아 합계를 구하는 프로그램
[실행 예]
정수입력: 1
정수입력: 2
정수입력: 3
정수입력: 0
합계: 6
 */
public class ArrayListTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		
		while(true) {
			System.out.print("정수입력: ");
			int num = scan.nextInt();
			if(num == 0)
				break;
			list.add(num);	//int형을 넣어도 자동으로 Integer로 변환해주기 때문에
							//new Integer(num) 을 넣어 준 것과 같다.
		}
		
		System.out.println(list);
		System.out.println(list.get(0));	//list.get(0).intValue() 를 자동으로 해준다.
		System.out.println(list.get(0) instanceof Integer);
		System.out.println(list.get(0).getClass());	//list.get(0)의 class를 알려준다.
		
		int sum = 0;	//합계를 저장할 변수
		
		for(int i=0; i<list.size(); i++) {
			sum += list.get(i);	//list에 있는 값을 하나씩 받아서 sum에 더함
		}
		System.out.println("합계: "+sum);
	}
}

