import java.io.Serializable;

//Serializable은 직렬화 해달라고 하는것.
public class TestData implements Serializable{
	private static final long serialVersionUID = -751385407213892709L;	//확인할수 있는 비밀번호같은것
	String name;
	int age;
	
	public TestData() {}
	
	public TestData(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "TestData [name=" + name + ", age=" + age + "]";
	}
	
	
}
