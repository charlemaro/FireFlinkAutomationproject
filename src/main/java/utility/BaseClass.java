package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

import ObjectRepository.DashBoardPage;
import ObjectRepository.LoginPage;
import utility.FileUtility;
import utility.JavaUtility;
import utility.WebDriverUtility;

public class BaseClass {
	
	public WebDriverUtility weutil=new WebDriverUtility();
	public FileUtility futil=new FileUtility();
	public JavaUtility jutil=new JavaUtility();
	public WebDriver driver;
	
	//for listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("===================== DB conncetion Successfull===============");
	}
	//@Parameters("browser") 1
	//@BeforeTest 1
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*1 String BROWSER*/) throws IOException {
		String BROWSER=futil.readDataFromPropertyFile("browser"); //comment this line when using 1
		String URL= futil.readDataFromPropertyFile("url");
		// driver = new EdgeDriver();
		driver=weutil.getBrowser(BROWSER);
		weutil.maximizeWindow(driver);
		weutil.implicitWait(driver);
		weutil.loadWebsite(driver, URL);
		
		System.out.println(BROWSER);
		//forlisteners
				sdriver=driver;
		
		System.out.println("============= "+BROWSER+" browser Launched Successfully==============");
		
	}
	//@AfterTest 1
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("============= Browser Closed Successfully ===========================");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME= futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
		System.out.println("=============  Login to App ==========================================");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		 DashBoardPage dboard=new DashBoardPage(driver);
		//for logout
		dboard.logout(driver);
		System.out.println("=============  Successfully Logged Out ================================");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("=============  DB Closed Successfully==============================");
	}

}
