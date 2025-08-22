package praciceTestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	@Test(retryAnalyzer = utility.RetryAnalyserImplementation.class)
	public void sample() {
		Assert.fail();
		System.out.println("sample");
	}

}
