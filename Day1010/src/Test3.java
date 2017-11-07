
public class Test3 {
	public static void main(String[] args) {
		//기본생성자 생성불가능
		//Account ac = new Account();
		
		//계좌번호와 이름만 입력받는 생성자
		Account ac1 = new Account(1, "김철수");
		
		//계좌번호,이름,잔액을 입력받는 생성자
		Account ac2 = new Account(2, "이영희", 10000);
		
		//이름을 리턴하는 메소드
		System.out.println(ac2.getName());
		
		//잔액변경불가능
		//ac2.balance = 1000;
		//ac2.setBalance(1000);
		
		//입금
		ac2.deposit(1000);
		System.out.println(ac2.getBalance());
		
		//출금
		ac2.withdraw(2000);
		System.out.println(ac2.getBalance());
		
		//전체정보출력
		ac2.print();
	}
}
