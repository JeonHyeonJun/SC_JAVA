package mkdir;

public class Trainee extends Human{
	private String stuNum;
	
	public Trainee() {}

	public Trainee(String name, int age, String jumin, String stuNum) {
		super(name, age, jumin);
		this.stuNum = stuNum;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	@Override
	public String toString() {
		return super.toString()+", ÇÐ¹ø: " + stuNum;
	}
	
	
}
