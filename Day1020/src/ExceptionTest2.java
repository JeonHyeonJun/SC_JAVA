
public class ExceptionTest2 {
	public static void main(String[] args) {
		String sa[] = {"10", "2"};
		int a,b,c;
		
		try {
			a = Integer.parseInt(sa[0]);
			b = Integer.parseInt(sa[1]);
			c = a/b;
			System.out.println("���: " +c);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭 ���� �ƴϴ�");
		} catch (ArithmeticException e) {
			System.out.println("0�� ���� �� ����");
		} catch (NumberFormatException e) {
			System.out.println("������ �ƴϴ�");
		} finally {
			System.out.println("ó���Ϸ�");
		}
		
		
	}
}
