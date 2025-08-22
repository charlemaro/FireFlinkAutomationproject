package utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {
	 ExtentReports report=null;
	 ExtentTest test=null;

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("-------TestFinished--------");
		//report generations
		report.flush();
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("--------Suite Started-------------");
		
		//Extent report configuration
		ExtentSparkReporter esr=new ExtentSparkReporter(".//ExtentReport//extendReport"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Ninza Crm Automation");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Web Automation Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(esr);
		//it is custom reports key value
		report.setSystemInfo("BaseBrowser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Author name", "Charle");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname=result.getName();
		System.out.println("-----------"+methodname+" TEst failed ---------------");
		System.out.println(result.getThrowable());
		//capture screenshot
		JavaUtility j=new JavaUtility();
		WebDriverUtility wu=new WebDriverUtility();
		
		//screenshotname=> methodname +currentdate and time
		String screenshotname=methodname+j.getSystemDate();
		try {
			String path=wu.captureScreenShot(BaseClass.sdriver, screenshotname);//why we use sdriver do research
			//attach screenshot to report 
			test.addScreenCaptureFromPath(path);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//log the Extent report on @Test is failed
		test.log(Status.FAIL,"-----------"+methodname+" TEst failed ---------------");
		System.out.println(result.getThrowable());
		//log the throwble
		test.log(Status.WARNING,result.getThrowable());
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname=result.getName();
		System.out.println("-----------"+methodname+"  TEst skipped ---------------");
		System.out.println(result.getThrowable());
		//log the skipped status
		
		test.log(Status.SKIP,"-----------"+methodname+"  TEst skipped ---------------");
		System.out.println(result.getThrowable());
		test.log(Status.WARNING,result.getThrowable());
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodname=result.getName();
		System.out.println(methodname+"-----------TEst started ---------------");
				//intimate extend reports for @Test start
				 test=report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname=result.getName();
		System.out.println(" -------------------"+methodname+" started execution-----------------");
		//capture screenshot
				JavaUtility j=new JavaUtility();
				WebDriverUtility wu=new WebDriverUtility();
				//screenshotname=> methodname +currentdate and time
				String screenshotname=methodname+j.getSystemDate();
				
				
				
				try {
					String path =wu.captureScreenShot(BaseClass.sdriver, screenshotname);//why we use return path in get screenshot webdriver utility method do research=>==>because we can use them in reports
					//attach the screen shot to the report
					test.addScreenCaptureFromPath(path);
					
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				//log the status of @Test as pass in extent report
				test.log(Status.PASS," -------------------"+methodname+" started execution-----------------");
		
		
	}

}
