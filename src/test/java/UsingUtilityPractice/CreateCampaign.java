package UsingUtilityPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepository.CreateCampaignPage;
import ObjectRepository.DashBoardPage;
import ObjectRepository.LoginPage;
import utility.FileUtility;
import utility.WebDriverUtility;

public class CreateCampaign {
	public static void main(String[] args) throws Throwable {
		FileUtility futil=new FileUtility();
		WebDriverUtility webutil=new WebDriverUtility();
		
		
		String SHEET="Sheet1";
		String BROWSER=futil.readDataFromPropertyFile("browser");
		String URL= futil.readDataFromPropertyFile("url");
		String USERNAME= futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");
		
		String CAMPAIGNNAME=futil.readStringDataFromExcel(SHEET,4,2);
		String TARGETSIZE=futil.readStringDataFromExcel(SHEET,4,5);
		
		WebDriver driver= webutil.getBrowser(BROWSER);
		webutil.loadWebsite(driver, URL);
		webutil.maximizeWindow(driver);
		webutil.implicitWait(driver);
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME,PASSWORD);
		
		DashBoardPage dboard=new DashBoardPage(driver);
		dboard.enterCampaign();
		
		CreateCampaignPage campaign=new CreateCampaignPage(driver);
		campaign.enterCampaignField();
		campaign.enterCampaignName(CAMPAIGNNAME);
		campaign.enterTargetSize(TARGETSIZE);
		campaign.createCampaign();
		
	}

}
