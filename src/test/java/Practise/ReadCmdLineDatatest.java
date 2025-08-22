package Practise;

import org.testng.annotations.Test;

public class ReadCmdLineDatatest {
	
	@Test
	public void readCmdtest() {
		String Brow=System.getProperty("browser");
		System.out.println(Brow);
		String un=System.getProperty("username");
		System.out.println(un);
		String pas=System.getProperty("password");
		System.out.println(pas);
	}
}


  