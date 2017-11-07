import java.util.ArrayList;
import java.util.Scanner;

//p.576 5번문제
//심사위원 10명의 점수를 입력받아서 최고,최저점수를 제외한 합을 구하는 프로그램
//점수는 double타입
public class Pro22_5 {
	static final int CNT = 10;	//10명을 상수로 정의해 놓음.
								//여기에 public을 붙이면 다른 클래스에서도 이 상수를 사용할 수 있다.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<>();
		
		//10명의 점수를 입력받음
		for(int i=0; i<CNT; i++) {
			System.out.print("심사위원의 점수: ");
			Double d = new Double(scan.nextDouble());
			list.add(d);
		}
		
		double max = list.get(0);	//최고점수를 담을 변수. 초기값은 list의 0번지에 있는 값으로 설정
		double min = list.get(0);	//최저점수를 담을 변수. 초기값은 list의 0번지에 있는 값으로 설정
		double sum = 0;				//총합을 담을 변수
		
		//최고,최저,총합을 구함
		for(int i=0; i<CNT; i++) {
			if(list.get(i) > max)
				max = list.get(i);	//list.get(i)가 현재max값보다 크다면 max에 list.get(i)를 대입
			if(list.get(i) < min)
				min = list.get(i);	//list.get(i)가 현재min값보다 작다면 min에 list.get(i)를 대입
			sum += list.get(i);		//sum에 list.get(i)를 더함
		}
		
		sum = sum-max-min;	//총합에서 최고,최저 점수를 뺌
		
		System.out.println("점수의  합: "+sum);
		
	}
}
