
public class PersonTest {
	public static void main(String[] args) {
		Person a = new Person(new String("��"), "�ҿ�", "1111");
		Customer b = new Customer("��", "�׻�", "222", 1, 1000);
		Person c = new Person(new String("��"), "�ҿ�", "1111");
		Customer d = new Customer("��", "�׻�", "222", 2, 1000);
		
		System.out.println(a == c);
		System.out.println(a.equals(c));
		
		System.out.println(a.equals(new Integer(1)));
		System.out.println(a.equals(a));
		
		System.out.println(b == d);
		System.out.println(b.equals(d));
	}
	
	
	public static void output(Object ob) {
		if(ob instanceof Person) {
			System.out.println("Person��ü��");
		}
		
		System.out.println(ob.toString());
	}
}
