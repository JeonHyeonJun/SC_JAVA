package mkdir;

public class Professor extends Human{
	private String major;
	
	public Professor() {}

	public Professor(String name, int age, String jumin, String major) {
		super(name, age, jumin);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return super.toString()+", Àü°ø:" + major + "]";
	}
	
	
	
	
}
