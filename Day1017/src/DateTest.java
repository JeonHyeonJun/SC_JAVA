import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
//		Date d = new Date();
//		
//		System.out.println(d);
//		System.out.println(d.getTime());
		
		String days[] = {"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�����"};
		Calendar c = Calendar.getInstance();
		
//		System.out.println(c);
//		System.out.println(c.getTime());
		
		//CalandarŬ������ get������ ���ϴ°� ��� �˾ƺ��� �ִ�.
		int year = c.get(c.YEAR);
		int month = c.get(c.MONTH)+1;
		int date = c.get(c.DATE);
		int hour = c.get(c.HOUR);
		int minute = c.get(c.MINUTE);
		int second = c.get(c.SECOND);
		
		int ampm = c.get(c.AM_PM);
		String ap;
		if(ampm == Calendar.AM) 
			ap = "����";
		else
			ap = "����";
		
		int day = c.get(c.DAY_OF_WEEK);
		
		System.out.println(year+"�� "+month+"�� "+date+"�� "+days[day-1]+" "
							+ap+" "+hour+"�� "+minute+"�� "+second+"��");
	}
}
