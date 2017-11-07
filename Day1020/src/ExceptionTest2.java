
public class ExceptionTest2 {
	public static void main(String[] args) {
		String sa[] = {"10", "2"};
		int a,b,c;
		
		try {
			a = Integer.parseInt(sa[0]);
			b = Integer.parseInt(sa[1]);
			c = a/b;
			System.out.println("결과: " +c);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 아니다");
		} catch (ArithmeticException e) {
			System.out.println("0은 나눌 수 없다");
		} catch (NumberFormatException e) {
			System.out.println("정수가 아니다");
		} finally {
			System.out.println("처리완료");
		}
		
		
	}
}
