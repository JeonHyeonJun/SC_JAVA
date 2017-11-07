/*
[문제] for문을 이용한  Fibonacci 수열
피보나치 수열이란 처음 두 항을 1과 1로 한 후, 그 다음 항부터는 바로 앞의 두 개의 항을 더해 만드는 수열을 말한다.
다음 수열을 for문을 사용하여 출력한다.
1  1  2  3  5  8  13  21  34  55   
*/

package homework1.basic;

public class Hw1 {

	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 1;
		int i;
		int next = 0;
		for(i = 0; i < 10; i++) {
			System.out.print(num1 + "  ");
			next = num1 + num2;
			num1 = num2;
			num2 = next;
		}
	}

}
