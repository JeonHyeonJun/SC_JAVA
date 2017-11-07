import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
//		Date d = new Date();
//		
//		System.out.println(d);
//		System.out.println(d.getTime());
		
		String days[] = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		Calendar c = Calendar.getInstance();
		
//		System.out.println(c);
//		System.out.println(c.getTime());
		
		//Calandar클래스는 get변수로 원하는걸 모두 알아볼수 있다.
		int year = c.get(c.YEAR);
		int month = c.get(c.MONTH)+1;
		int date = c.get(c.DATE);
		int hour = c.get(c.HOUR);
		int minute = c.get(c.MINUTE);
		int second = c.get(c.SECOND);
		
		int ampm = c.get(c.AM_PM);
		String ap;
		if(ampm == Calendar.AM) 
			ap = "오전";
		else
			ap = "오후";
		
		int day = c.get(c.DAY_OF_WEEK);
		
		System.out.println(year+"년 "+month+"월 "+date+"일 "+days[day-1]+" "
							+ap+" "+hour+"시 "+minute+"분 "+second+"초");
	}
}
