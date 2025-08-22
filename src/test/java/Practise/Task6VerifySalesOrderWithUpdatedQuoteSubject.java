package Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task6VerifySalesOrderWithUpdatedQuoteSubject {

	public static void main(String[] args) throws IOException, InterruptedException {
	
		
FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\CommonData.properties");
		
		Properties pobj= new Properties();
		pobj.load(fis);
		String Url=pobj.getProperty("url");
		String UserName =pobj.getProperty("username");
		String Password=pobj.getProperty("password");
		
		FileInputStream fis1= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
	      Workbook wb=	WorkbookFactory.create(fis1);
	      Sheet sheet=wb.getSheet("Sheet1");
	      Row r=sheet.getRow(16);
	     
	      
	      String subject = r.getCell(1).toString();
	      String ValidTill = r.getCell(2).toString();
	      String OpportunityId = r.getCell(3).toString();
	      String QuoteId = r.getCell(4).toString();
	      String OrganizationName = r.getCell(5).toString();
	      String BillingAddress = r.getCell(6).toString();
	      String BillingPoBox = r.getCell(7).toString();
	      String BillingCity = r.getCell(8).toString();
	      String BillingState = r.getCell(9).toString();
	      String BillingPostelCode = r.getCell(10).toString();
	      String BillingCountry = r.getCell(11).toString();
	      String ShippingAddress = r.getCell(12).toString();
	      String ShippingPoBox = r.getCell(13).toString();
	      String city = r.getCell(14).toString();
	      String state = r.getCell(15).toString();
	      String postelCode = r.getCell(16).toString();
	      String Country = r.getCell(17).toString();
	      String AddProducts = r.getCell(18).toString();
	      String SearchQuoteId = r.getCell(19).toString();
	      String UpdatedSubjectName = r.getCell(20).toString();
	      
	      
	      
		  WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			Actions act = new Actions(driver);
			
			driver.get(Url);
			driver.findElement(By.id("username")).sendKeys(UserName);
			driver.findElement(By.id("inputPassword")).sendKeys(Password);
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			
			//Step 2
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//a[text()='Sales Order']")).click();
			driver.findElement(By.xpath("//span[text()='Create Order']")).click();
			
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@name='subject']")).click();
			
		act.sendKeys(subject,Keys.TAB,ValidTill).perform();
		
		driver.findElement(By.xpath("(//button[@class='action-button'])[1]")).click();
		
		String window=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		
		for(String win:windows) {
			if(!win.equals(window)) {
				
				driver.switchTo().window(win);
				driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(OpportunityId);
				driver.findElement(By.xpath("//button[@class='select-btn']")).click();
			}
		}
		
		driver.switchTo().window(window);
		
		driver.findElement(By.xpath("(//button[@class='action-button'])[2]")).click();	
		
		Set<String> windows1=driver.getWindowHandles();
		
		for(String win:windows1) {
			if(!win.equals(window)) {
				
				driver.switchTo().window(win);
				driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(QuoteId);
				driver.findElement(By.xpath("//button[@class='select-btn']")).click();
			}
		}
		
		driver.switchTo().window(window);
		
        driver.findElement(By.xpath("(//button[@class='action-button'])[3]")).click();	
		
		Set<String> windows2=driver.getWindowHandles();
		
		for(String win:windows2) {
			if(!win.equals(window)) {
				
				driver.switchTo().window(win);
				driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(OrganizationName);
				driver.findElement(By.xpath("(//button[@class='select-btn'])[2]")).click();
			}
		}
		
		driver.switchTo().window(window);
		
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB,BillingAddress,Keys.TAB,BillingPoBox,Keys.TAB,BillingCity,Keys.TAB,BillingState,Keys.TAB,BillingPostelCode,Keys.TAB,BillingCountry,Keys.TAB,ShippingAddress,Keys.TAB,ShippingPoBox,Keys.TAB,city,Keys.TAB,state,Keys.TAB,postelCode,Keys.TAB,Country).perform();
		
		
		driver.findElement(By.xpath("//button[text()='Add Product']")).click();

			
       Set<String> windows3=driver.getWindowHandles();
		
		for(String win:windows3) {
			if(!win.equals(window)) {
				
				driver.switchTo().window(win);
				driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(AddProducts);
				driver.findElement(By.xpath("//button[@class='select-btn']")).click();
			}
		}
		
		driver.switchTo().window(window);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Create Sales Order']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search by Quote Id']")).sendKeys(SearchQuoteId);
		driver.findElement(By.xpath("//i[@title='Edit']")).click();
		WebElement element=driver.findElement(By.xpath("//input[@name='subject']"));
			element.clear();
			element.sendKeys(UpdatedSubjectName);
			
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[text()='Update Quote']")).click();
	  Thread.sleep(2000);
	  
		driver.findElement(By.xpath("//a[text()='Sales Order']")).click();
		driver.findElement(By.xpath("//select[@class='form-control']")).click();
		driver.findElement(By.xpath("//option[text()='Search by Subject']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search by Subject']")).sendKeys(UpdatedSubjectName);
		driver.findElement(By.xpath("(//i[@title='Edit'])[1]")).click();
		String expectedResult=UpdatedSubjectName;
		String result=driver.findElement(By.xpath("//input[@name='subject']")).getAttribute("value");
		
		
		if(result.equals(expectedResult)) {
			System.out.println("TestCase is passed");
		}
		
		else {
			System.out.println("TestCase is not passed");
		}
		
		
		
		Thread.sleep(8000);
		
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		act.moveToElement(icon).perform();
		driver.findElement(By.xpath("//div[text()='Logout ']")).click();
	}

}