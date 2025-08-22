package UsingUtilityPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.LoginPage;
import utility.FileUtility;
import utility.JavaUtility;
import utility.WebDriverUtility;

public class Login {
	public static void main(String[] args) throws IOException {
		
		FileUtility futil=new FileUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility webutil=new WebDriverUtility();

		
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
		
	
		
	}

}
