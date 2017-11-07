
public class Account {
	private int num;
	private String name;
	private int balance;
	
	public Account(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	public Account(int num, String name, int balance) {
		this.num = num;
		this.name = name;
		this.balance = balance;
	}

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
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int balance) {
		this.balance += balance;
	}
	
	public void withdraw(int balance) {
		this.balance -= balance;
	}
	
	public void print() {
		System.out.println("번호:"+num+" 이름:"+name+" 잔액:"+balance);
	}
	
}
