import java.util.ArrayList;
import java.util.Collections;

public class PhoneArrayTest {
	public static void main(String[] args) {
		ArrayList<SmartPhone> list = new ArrayList<>();
		
		list.add(new SmartPhone("Samsung",500,"3G", "Android", "7.0", 128, true, true));
		list.add(new SmartPhone("Apple",700,"4G", "IOS", "7.0", 128, true, true));
		list.add(new SmartPhone("Samsung",900,"5G", "IOS", "7.0", 128, true, true));
		list.add(new SmartPhone("Apple",100,"6G", "Android", "7.0", 128, true, true));
		list.add(new SmartPhone("Apple",300,"7G", "Android", "7.0", 128, true, true));
		System.out.println(list);
		
		Collections.sort(list);
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
}
