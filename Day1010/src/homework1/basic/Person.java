/*
Hw4 클래스에서 사용.
회원주소록 프로그램에서 한명의 회원정보를 나타내는 클래스.
회원번호, 이름, 전화번호, 주소 이렇게 3가지의 속성을 가진다.
모든 필드는 접근 지정자가 private이며, 
각 필드의 값을 변경하는 Setter와 각 필드의 값을 읽어서 리턴하는 Getter를 가진다.
기본생성자와 모든 필드값을 전달받아 초기화하는 생성자를 가진다.
각 필드의 값을 다음과 같이 출력하는 print()메소드를 정의한다.   
 */
package homework1.basic;

public class Person {
	private int num;		//회원번호
	private String name;	//이름
	private String phone;	//전화번호
	private String address;	//주소

	//생성자
	public Person() {
	}
	
	public Person(int num, String name, String phone, String address) {
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	//Getters & Setters
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	//출력용 메소드
	public void print() {
		System.out.println("번호:" + num + "\t" + "이름:" + name + "\t" 
					+ "전화번호:" + phone + "\t" + "주소:" + address);
	}
	
}
