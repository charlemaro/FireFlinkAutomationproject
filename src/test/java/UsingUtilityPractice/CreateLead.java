package UsingUtilityPractice;

import org.openqa.selenium.WebDriver;

import ObjectRepository.CreateLeadPage;
import ObjectRepository.DashBoardPage;
import ObjectRepository.LoginPage;
import utility.FileUtility;
import utility.JavaUtility;
import utility.WebDriverUtility;

public class CreateLead {
	public static void main(String[] args) throws Throwable {
		FileUtility futil=new FileUtility();
		WebDriverUtility webutil=new WebDriverUtility();
		JavaUtility javutil=new JavaUtility();
		String SHEET="Sheet1";
		String ID=futil.readStringDataFromExcel(SHEET,4,6);
		String LEADNAME=futil.readStringDataFromExcel(SHEET,4,7);
		String PHONENO=futil.readStringDataFromExcel(SHEET,4,5)+javutil.getRandomNumber()+javutil.getRandomNumber()+javutil.getRandomNumber()+javutil.getRandomNumber()+9;
		String LEADSTATUS=futil.readStringDataFromExcel(SHEET,7,4);
		String COMPANY=futil.readStringDataFromExcel(SHEET,13,7);
		String INDUSTRY=futil.readStringDataFromExcel(SHEET,13,7);
		
		String BROWSER=futil.readDataFromPropertyFile("browser");
		String URL= futil.readDataFromPropertyFile("url");
		String USERNAME= futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		
		WebDriver driver=webutil.getBrowser(BROWSER);
		webutil.maximizeWindow(driver);
		webutil.implicitWait(driver);
		webutil.loadWebsite(driver, URL);
		
		LoginPage log=new LoginPage(driver);
		log.loginToApp(USERNAME, PASSWORD);
		
		DashBoardPage dboard=new DashBoardPage(driver);
		dboard.enterLead();
		dboard.enterCreateLead();
		
		CreateLeadPage lp=new CreateLeadPage(driver);
		lp.enterLeadName(LEADNAME);
		lp.enterLeadSource(LEADSTATUS);
		lp.enterLeadStatus(LEADSTATUS);
		lp.enterCompany(COMPANY);
	    webutil.scrollDown(driver,300,300);
	    lp.enterIndustrt(INDUSTRY);
		lp.enterPhoneNo(PHONENO);
		lp.enterCampaign(driver,ID);
		
		lp.createLead();
		
	
	}

}
