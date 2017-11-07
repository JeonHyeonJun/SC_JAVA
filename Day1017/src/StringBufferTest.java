
public class StringBufferTest {
	public static void main(String[] args) {
		String a = new String("abc");
		String b = new String("abc");
		StringBuffer c = new StringBuffer("abc");
		StringBuffer d = new StringBuffer("abc");
		
		System.out.println(c.toString().equals(d.toString()));
		
		String e = c.toString();
		
		b = a.concat("def");	//a�� def�� �ٿ��� ���ο� String��ü�� �����. a�� �״�� abc, b�� abcdef
		d.append("def");	//d�� def�� ����. d�� abcdef�� �ȴ� 
		d.insert(1, "?");	//0�� ��ó���̹Ƿ� 1�� �ι�°�ڸ��� ?�� �߰�	d�� a?bcdef
		c.delete(1, 3);
		d.reverse();	//�¿����. d�� fedcb?a
		d.replace(0, 2, "999");	//0���� 2�������� ���ڸ� 999�� ��ü. d�� 999dcb?a
		
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
