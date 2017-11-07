import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		
		map.put("Seoul", "서울");
		map.put("Busan", "부산");
		map.put("Set", "순서가 없는 자료구조");
		map.put("List", "순서가 있는 자료구조");
		map.put("Map", "Key와 Value의 한 쌍으로 저장");
		
		System.out.println(map);
		
		String value = map.get("Map");
		System.out.println(value);
		
		System.out.println(map.size());	//map에 저장되어있는 객체수
		
		System.out.println(map.get("aaa"));	//"aaa"라는 key를 가진 value 검색
		
		System.out.println(map.containsKey("List")); //List라는 Key가 있는가
		
		map.clear();	//맵안의 내용 모두 지우기
		
		System.out.println(map.isEmpty());	//map이 비어있는가
		
		System.out.println(map);	//map의 내용 전체 출력
		
		HashMap<String, Object> map2 = new HashMap<>();
		ArrayList<String> cartList = new ArrayList<>();
		
		map2.put("id", "abc");
		map2.put("level", "일반회원");
		map2.put("login", new Date());
		map2.put("cart", cartList);
		map2.put("etc", new Student("이름", "주소", "뎅와방고"));
		
		System.out.println(map2);
		
		Student s = (Student)map2.get("etc");
		System.out.println(s.getName());
		
		map2.remove("level");
		System.out.println(map2);
	}
}
