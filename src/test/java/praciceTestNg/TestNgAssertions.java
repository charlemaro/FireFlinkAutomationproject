package praciceTestNg;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgAssertions {
	//HardAssert
	@Test
	public void sampleTest() {
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals(1,1);
		System.out.println("Step3");
		System.out.println("Step4");
		Assert.assertEquals(0,1);
		System.out.println("Step5");
	}
	
	//SoftAssert
	@Test
	public void sampleTest2() {
		SoftAssert sa=new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		sa.assertEquals(1,1);
		System.out.println("Step3");
		System.out.println("Step4");
		sa.assertEquals(0,1);
		//needs assertAll to show failures
		sa.assertAll();
		System.out.println("Step5");
	}

}
