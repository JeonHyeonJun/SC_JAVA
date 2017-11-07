/*
[문제] 연도, 월을 입력받아 해당 월의 달력을 출력한다.

[조건]
- 입력받은 연도가 y, 월이 m인 경우
- 1년 1월 1일 부터 입력받은 y년 m월 1일까지의 날짜수를 구한다.
- 구한 날짜 수를 7로 나눈 나머지가 요일이다. (0이 일요일, 1이 월요일)
- 달력을 출력할 월의 첫날이 무슨 요일인지에 따라 '\t' 또는 스페이스를 이용하여 칸을 띄운다.
- 반복문을 이용하여 1일부터 해당 월의 마지막 날까지 출력한다.
- 토요일을 출력할 때마다 줄을 바꾼다.

[실행 예]
년 : 2017
월 : 1

			2017년 1월


	일	월	화	수	목	금	토
	1	2	3	4	5	6	7
	8	9	10	11	12	13	14
	15	16	17	18	19	20	21
	22	23	24	25	26	27	28
	29	30	31

 */

package homework1.basic;

import java.util.Scanner;

public class Hw2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int y, m, day;
		int i, tot = 0;
		int month[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		System.out.print("년 : ");
		y = scan.nextInt();
		System.out.print("월 : ");
		m = scan.nextInt();
		
		//입력받은 월의 1일까지의 날짜수 구하기
		//입력년도가 윤년이면 2월을 29일로.
		if (y%4==0 && y%100!=0 || y%400==0) month[1] = 29;
		
		//작년까지 날짜
		for (i = 1; i < y ; i++) {
			if (i%4==0 && i%100!=0 || i%400==0) tot += 366;
			else tot += 365;
		}
		
		//전월까지 날짜
		for (i = 0; i < m - 1; i++) {
			tot += month[i];
		}
		
		//해당월의 1일더하기
		tot++;
		
		//해당월 1일의 요일 구하기. 나머지가 1이면 월요일
		day = tot % 7;
		
		//달력제목 출력
		System.out.println("\n\n\t\t\t" + y + "년 " + m + "월\n\n");
		System.out.println("\t일\t월\t화\t수\t목\t금\t토");
		
		//1일의 출력위치를 요일만큼 띄우기
		for (i = 0; i < day; i++) System.out.print("\t");
		
		//해당월 달력 출력
		for (i = 1; i <= month[m - 1]; i++) {
			System.out.print("\t" + i);
			
			if (day++ % 7 == 6) { //토요일까지 출력후 줄바꿈
				System.out.println();
			}
		}
		System.out.println();
	}
}
