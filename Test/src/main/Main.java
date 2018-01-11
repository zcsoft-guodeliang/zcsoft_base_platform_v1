package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

 

public class Main {
	public static void main(String[] args) throws Exception{
		String str="2010-5-27";
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

		Date date =sdf.parse(str);

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		
		long l1=calendar.getTimeInMillis();
		long l2=date.getTime();
		System.out.println(l1);
		System.out.println(l2);
		
		System.out.println(new SimpleDateFormat(
					"yyyy-MM-dd").format(calendar.getTime()));
	 
	 
		
}
	 
}
