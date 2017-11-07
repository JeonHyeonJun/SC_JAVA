import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MapTest {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		
		map.put("Seoul", "����");
		map.put("Busan", "�λ�");
		map.put("Set", "������ ���� �ڷᱸ��");
		map.put("List", "������ �ִ� �ڷᱸ��");
		map.put("Map", "Key�� Value�� �� ������ ����");
		
		System.out.println(map);
		
		String value = map.get("Map");
		System.out.println(value);
		
		System.out.println(map.size());	//map�� ����Ǿ��ִ� ��ü��
		
		System.out.println(map.get("aaa"));	//"aaa"��� key�� ���� value �˻�
		
		System.out.println(map.containsKey("List")); //List��� Key�� �ִ°�
		
		map.clear();	//�ʾ��� ���� ��� �����
		
		System.out.println(map.isEmpty());	//map�� ����ִ°�
		
		System.out.println(map);	//map�� ���� ��ü ���
		
		HashMap<String, Object> map2 = new HashMap<>();
		ArrayList<String> cartList = new ArrayList<>();
		
		map2.put("id", "abc");
		map2.put("level", "�Ϲ�ȸ��");
		map2.put("login", new Date());
		map2.put("cart", cartList);
		map2.put("etc", new Student("�̸�", "�ּ�", "���͹��"));
		
		System.out.println(map2);
		
		Student s = (Student)map2.get("etc");
		System.out.println(s.getName());
		
		map2.remove("level");
		System.out.println(map2);
	}
}
