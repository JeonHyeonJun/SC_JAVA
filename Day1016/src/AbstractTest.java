import javax.swing.JFrame;

public class AbstractTest {
	public static void main(String[] args) {
		A ob = new B();
		ob.test();
		
		A ob2 = new C();
		ob2.test();
	}
	
	//내부 클래스는 private 접근자 사용가능.(일반 클래스는 public 이나 접근자 없는것만 가능)
	private class Inner{
		
	}
}

//추상클래스 : 추상메소드를 하나라도 가지고 있다면 추상클래스가 된다. 추상클래스는 객체를 만들수 없다 ( A a = new A() 가 안됨)
//abstract class A{
//	public abstract void test(); //추상메소드 : 기능이 없고 정의만 되어있는 메소드
//	//abstract 와 final은 같이 쓸수없다.
//	//* final을 메소드 앞에 붙이면 상속금지의 의미임.
//	
//}

//인터페이스는 추상메소드와 상수만 쓸수있다.
//abstract를 쓰지 않아도 자동으로 추상메소드로 됨.
//인터페이스는 다중상속을 받을 수 있다.
//인터페이스와 추상클래스는 비슷하지만 추상클래스는 일반메소드도 쓸수있지만 인터페이스는 추상메소드만 쓸수있다.
interface A{
	public void test();
}

class B extends JFrame implements A{
	public void test() {
		System.out.println("B에서 정의");
	}
}

class C extends JFrame implements A{
	//부모가 추상클래스라면 추상메소드를 모두 오버라이딩 해야한다.
	public void test() {
		System.out.println("C에서 정의");
	}
}
