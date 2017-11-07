import java.util.ArrayList;
import java.util.Collections;

public class DataArrayList {
	public static void main(String[] args) {
		ArrayList<Data> list = new ArrayList<>();
		
		list.add(new Data(10, "컴퓨타"));
		list.add(new Data(5, "키보드"));
		list.add(new Data(7, "모니터"));
		list.add(new Data(5, "마우스"));
		list.add(new Data(6, "스피커"));
		
		Data tmp = new Data(5, "키보드");
		
		System.out.println(list);	//Data클래스에 toString()이 Overriding되어야함
		System.out.println(list.size());
		System.out.println(list.get(0));	//Data클래스에 toString()이 Overriding되어야함
		System.out.println(list.contains(tmp));	//Data클래스에 equals()가 Overriding되어야함
		System.out.println(list.indexOf(tmp));	//Data클래스에 equals()가 Overriding되어야함
		
		Collections.sort(list);	//정렬. Data클래스에 Comparable<Data> 인터페이스를 상속받아야하고
								//해당 인터페이스의 추상메소드를 정의해줘야한다.
		System.out.println(list);
	}
}
