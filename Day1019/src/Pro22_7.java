import java.util.HashSet;

public class Pro22_7 {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() < 6) {
			int lotto = (int)(Math.random()*45)+1;
			if(set.contains(lotto)) {
				System.out.println(set+"ม฿บน "+lotto);
			}
			set.add(lotto);
		}
		
		System.out.println(set);
	}
}
