package generic_Utility;

import java.util.Date;
import java.util.Random;

/** This class consists of basic java utility methods
 * 
 * @author D.sarveswararao
 *
 */
public class Java_Utility {
	/**
	 * This method returns a random number after every run
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
	return	r.nextInt(1000);
	}
	/**
	 * This method gives the current system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
	return	d.toString();
	}
	/** This method gives current System date in specific format
	 * 
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String da[]=d.toString().split(" ");
		String date=da[2];
		String  month=da[1];
		String year=da[5];
		String time=da[3].replace(":","-");
		String dateFormat=date+"-"+month+"-"+year+"-"+time;
		return dateFormat;
	}  
}
