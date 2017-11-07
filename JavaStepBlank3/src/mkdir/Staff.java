package mkdir;

public class Staff extends Human{
	private String field;
	
	public Staff() {}

	public Staff(String name, int age, String jumin, String field) {
		super(name, age, jumin);
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return super.toString()+", ºÎ¼­: " + field;
	}
	
	
}
