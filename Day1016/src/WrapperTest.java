
public class WrapperTest {
	public static void main(String[] args) {
		int a = 10;
		//int -> Integer
		Integer b = new Integer(10);
		String c = "10";
		
		//String -> Integer
		Integer d = new Integer("123");
		
		//String -> int
		int e = Integer.parseInt(c);
		
		//int -> String
		String f = Integer.toString(a);
		
		//Integer -> int
		int g = b.intValue();
		
		//Integer -> String
		String h = b.toString();
		
	}
}
