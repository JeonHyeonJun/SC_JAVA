/*
[문제] 문자열로 수식을 입력받아 계산하여 결과를 출력한다.

[조건]
- 한자리 양의 정수들과 사칙연산이 포함된 수식을 문자열로 입력받는다.
- 수식의 마지막은 반드시 '=' 문자로 끝나야 한다.
- 연산자 우선 순위 고려하지 않고 입력된 순서대로 계산한다.
- 0~9, +, -, *, / 이외의 문자가 표함되어 있으면 에러메시지 출력하고 프로그램을 종료한다.

[참고]
- 문자열 타입의 숫자를 int형으로 변환하는 방법은 다음과 같다.
  String을 int로 변환해주는 Integer클래스의 메소드를 이용한다.
  
	String s = "1";
	int i = Integer.parseInt(s);	//i는 1
	
- 문자 타입의 숫자를 int형으로 변환하는 방법은 다음과 같다.
  해당 문자의 유니코드값에서 문자 '0'의 유니코드값을 뺀다.
	char c = '1';
	int i = c - '0';		//i는 1

[실행 예1]
수식입력 : 1+a
수식이 잘못되었습니다.

[실행 예2]
수식입력 : 1+2*3
수식이 잘못되었습니다.

[실행 예3]
수식입력 : 1+2*3=
결과는 9
 */
package homework1.basic;

import java.util.Scanner;

public class Hw3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String exp = null; 		//입력받은 수식
		int res = 0; 			//연산 결과
		int num = 0; 			//연산에 사용할 값
		char op = 0; 			//최근에 읽은 연산자
		char ch = 0;
		int i;

		//수식 입력받기
		System.out.print("수식입력 : ");
		exp = scan.nextLine();
		
		//=기호로 끝나지 않으면 오류
		if (exp.charAt(exp.length() - 1) != '=') {
			System.out.println("수식이 잘못되었습니다.");
			return;
		}
		
		//수식 문자열을 한문자씩 읽어서 처리
		for (i = 0; i < exp.length(); i++) {
			ch = exp.charAt(i); 				//한문자 읽기
			if (ch >= '0' && ch <= '9') { 		//숫자이면
				num = ch - '0'; 				//숫자로 변환 
			}
			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=') {
				switch (op) { 					//이전에 읽은 연산자
					case 0: res = num; break; 	//최초연산인경우
					case '+': res += num; break;
					case '-': res -= num; break;
					case '*': res *= num; break;
					case '/': res /= num; break;
				}
				
				if (ch == '=') break; //=문자 나오면 종료
				op = ch; //지금 읽은 연산자를 다음에 사용하기 위해 보관
			}
			else {
				System.out.println("수식이 잘못되었습니다.");
				return;
			}
		}
		System.out.println("결과는 " + res);
	}
}
