package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * To have java functions like randomnumber and convert date
 * @author Charle Maro J
 */

public class JavaUtility {
	/**
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date d=new Date();
		SimpleDateFormat s=new SimpleDateFormat("DD-MM-YYYY_hh-mm-ss");
		String date=s.format(d);
		return date;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getRandomNumber() {	
		return (int)(Math.random()*1001)+1;
	}

}
