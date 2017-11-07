
public class Phone{
	private String made;
	private int money;
	private String type;
	
	public Phone() {}
	
	public Phone(String made, int money, String type) {
		this.made = made;
		this.money = money;
		this.type = type;
	}

	public String getMade() {
		return made;
	}

	public void setMade(String made) {
		this.made = made;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Phone [made=" + made + ", money=" + money + ", type=" + type + "]";
	}

	
	
	
}
