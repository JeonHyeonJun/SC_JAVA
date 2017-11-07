
public class StringBufferTest {
	public static void main(String[] args) {
		String a = new String("abc");
		String b = new String("abc");
		StringBuffer c = new StringBuffer("abc");
		StringBuffer d = new StringBuffer("abc");
		
		System.out.println(c.toString().equals(d.toString()));
		
		String e = c.toString();
		
		b = a.concat("def");	//a에 def를 붙여서 새로운 String객체를 만든다. a는 그대로 abc, b는 abcdef
		d.append("def");	//d에 def를 붙임. d는 abcdef가 된다 
		d.insert(1, "?");	//0이 맨처음이므로 1은 두번째자리에 ?를 추가	d는 a?bcdef
		c.delete(1, 3);
		d.reverse();	//좌우반전. d는 fedcb?a
		d.replace(0, 2, "999");	//0부터 2전까지의 문자를 999로 대체. d는 999dcb?a
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<100; i++)
			sb.append(i);
		System.out.println(sb);
	}
}
