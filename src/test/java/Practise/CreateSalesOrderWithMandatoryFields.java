package Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSalesOrderWithMandatoryFields {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream f1=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(f1);
		//common datas
		String browser=prop.getProperty("browser");
		//load driver
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String url=prop.getProperty("url");
		driver.get(url);
		
		
		
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//create contact
		       createContact(driver);
		//create opportunity
		       createOppurtunity(driver);
		//create quote
		  createQuote(driver);
		//create salesorder
		  createSalesOrder(driver);
		
	}
	
	//==============================createcontant method1========================================//
	public static void createContact(WebDriver driver) throws EncryptedDocumentException, IOException {
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Contact']/parent::button")).click();
		//testscript
		
		FileInputStream f2=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(f2);
		
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(4);
		String  contactname=row.getCell(4).toString();
		
		String organization=row.getCell(3).toString();
		String mobile=row.getCell(5).toString()+Createrandom()+Createrandom()+Createrandom()+Createrandom()+ Createrandom();
		String title=row.getCell(4).toString();
		String email=row.getCell(3).toString();
		String Department=row.getCell(2).toString();
		
		driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(contactname);
		driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organization+Createrandom());
		
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		//mailrandomness
		StringBuilder mail=new StringBuilder();
		for(int i=0;i<email.length();i++) {
			int rans=(int)(Math.random()*101)+1;
			if(i==3) {
				mail.append(rans);
				mail.append(Createrandom());
				mail.append(Createrandom());
				}else {
				mail.append(email.charAt(i));
			}
		}
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(mail);
		
		driver.findElement(By.xpath("//input[@name='department']")).sendKeys(Department);
		
		driver.findElement(By.xpath("(//div/child::button)[last()]")).click();
		String mainwindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			if(!(window.equals(mainwindow))) {
				driver.switchTo().window(window);
				break;
			}
		}
		//actions
		Actions act=new Actions(driver);
		
		driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
		//webdriverwait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d->driver.getWindowHandles().size() == 1);
    	driver.switchTo().window(mainwindow);

		WebElement ele1=driver.findElement(By.xpath("//label[contains(normalize-space(),'Office Phone')]/following-sibling::input"));
		act.scrollByAmount(300,300).perform();
		act.sendKeys(ele1,mobile+Createrandom()).perform();
		
		driver.findElement(By.xpath("//button[text()='Create Contact']"));
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		WebElement mess=driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(mess));
		System.out.println(mess.getText());
		
		
		System.out.println("============createdContact==========");
	}
	//===================================create oportunity method 2=========================//
	public static void createOppurtunity(WebDriver driver) throws InterruptedException, EncryptedDocumentException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	   WebElement createoportunity= driver.findElement(By.xpath("//a[text()='Opportunities']"));
	   
	   
	   if(createoportunity.isDisplayed()) {
		   System.out.println("Create oportunity page displayed");
	   }else {
		   System.out.println("not Displayed");
	   }
	   createoportunity.click();
	    
	    Thread.sleep(6000);
	    WebElement ele1 =driver.findElement(By.xpath("//span[text()='Create Opportunity']/parent::button"));
	    ele1.click();
	    FileInputStream f2=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(f2);
		
		Sheet sh=wb.getSheet("Sheet1");
		Row r=sh.getRow(13);
		String nextstep="Opportunity"+Createrandom()+Createrandom();
		String OpportunityName=r.getCell(2).toString()+Createrandom();
		String SalesStage=r.getCell(3).toString()+Createrandom();
		String amount=""+Createrandom()+Createrandom()+Createrandom()+Createrandom()+Createrandom();
		String Prob=r.getCell(9).toString();
		String Buisness=r.getCell(7).toString();
		String CloseDate=r.getCell(8).toString();
		
		
		driver.findElement(By.xpath("//input[@name='nextStep']")).sendKeys(nextstep);
		
		driver.findElement(By.xpath("//input[@name='opportunityName']")).sendKeys(OpportunityName);
		driver.findElement(By.xpath("//input[@name='salesStage']")).sendKeys(SalesStage);
		driver.findElement(By.xpath("//input[@name='amount']")).sendKeys(amount);
		driver.findElement(By.xpath("//input[@name='probability']")).sendKeys(Prob);
		driver.findElement(By.xpath("//input[@name='businessType']")).sendKeys(Buisness);
		driver.findElement(By.xpath("//input[@name='assignedTo']")).sendKeys(OpportunityName);
		driver.findElement(By.xpath("//input[@name='expectedCloseDate']")).sendKeys(CloseDate);
		
		//actions
		Actions act=new Actions(driver);
		act.scrollByAmount(200,200).perform();
		
		//handlepopup
		driver.findElement(By.xpath("(//div/child::button)[last()]")).click();
		String mainwindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			if(!(window.equals(mainwindow))) {
				driver.switchTo().window(window);
				break;
			}
		}
		driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
		//webdriverwait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(d->driver.getWindowHandles().size() == 1);
    	driver.switchTo().window(mainwindow);
		
		driver.findElement(By.xpath("//button[text()='Create Opportunity']")).click();
		
		WebElement mess=driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		wait.until(ExpectedConditions.elementToBeClickable(mess));
		System.out.println(mess.getText());
		System.out.println("===============created oportunity===============");   
	}
	//===================================Method2CreateQuote=========================
	private static void createQuote(WebDriver driver) throws InterruptedException, EncryptedDocumentException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement createoportunity= driver.findElement(By.xpath("//a[text()='Quotes']"));
		if(createoportunity.isDisplayed()) {
			   System.out.println("Create oportunity page displayed");
		   }else {
			   System.out.println("not Displayed");
		   }
		   createoportunity.click();
		   Thread.sleep(6000);
		   

		 WebElement ele1 =driver.findElement(By.xpath("//span[text()='Create Quote']/parent::button"));
		 ele1.click();
		 
		  FileInputStream f2=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
	      Workbook wb=WorkbookFactory.create(f2);
			
		  Sheet sh=wb.getSheet("Sheet1");
		  Row r=sh.getRow(13);
		  
		  String quotestage=r.getCell(11).toString();
		  String Subject=r.getCell(12).toString();
		  String opportunity=r.getCell(13).toString();
		  String validTill=r.getCell(14).toString();
		  
		  driver.findElement(By.xpath("//input[@name='quoteStage']")).sendKeys(quotestage);
		 
		  driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(Subject);
		  driver.findElement(By.xpath("//input[@name='validTill']")).sendKeys(validTill);
		//handlepopup
			driver.findElement(By.xpath("//label[text()='Opportunity']/parent::div/descendant::button")).click();
			String mainwindow=driver.getWindowHandle();
			Set<String> windows=driver.getWindowHandles();
			for(String window:windows) {
				if(!(window.equals(mainwindow))) {
					driver.switchTo().window(window);
					break;
				}
			}
			driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
			//webdriverwait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(d->driver.getWindowHandles().size() == 1);
	    	driver.switchTo().window(mainwindow);
	    //handle2
	    	
	    	//handlepopup
			driver.findElement(By.xpath("//label[text()='Contact']/parent::div/descendant::button")).click();
			 mainwindow=driver.getWindowHandle();
			windows=driver.getWindowHandles();
			for(String window:windows) {
				if(!(window.equals(mainwindow))) {
					driver.switchTo().window(window);
					break;
				}
			}
			driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
			//webdriverwait
			wait.until(d->driver.getWindowHandles().size() == 1);
	    	driver.switchTo().window(mainwindow);
	    	
	    	
	    	Actions act=new Actions(driver);
			act.scrollByAmount(400,400).perform();
		
			Row r2=sh.getRow(7);
			
			String duedate=r2.getCell(2).toString();
			String subject=r2.getCell(3).toString();
			String status=r2.getCell(4).toString();
			String billaddress=r2.getCell(4).toString();
			String shippingaddress=r2.getCell(10).toString();
			String billingPo=r2.getCell(8).toString();
			String adrressPo=r2.getCell(14).toString();
			String billingcity=r2.getCell(6).toString();
			String city=r2.getCell(12).toString();
			String state=r2.getCell(13).toString();
			String country=r2.getCell(20).toString();
			
			
			driver.findElement(By.xpath("//label[text()='Billing Address']/parent::div/descendant::textarea")).sendKeys(billaddress);
	    	driver.findElement(By.xpath("//label[text()='Shipping Address']/parent::div/descendant::textarea")).sendKeys(shippingaddress);
	    	driver.findElement(By.xpath("//label[text()='Billing PO Box']/parent::div/descendant::input")).sendKeys(billingPo);
	    	driver.findElement(By.xpath("//label[text()='Shipping PO Box']/parent::div/descendant::input")).sendKeys(adrressPo);
	    	driver.findElement(By.xpath("//label[text()='Billing City']/parent::div/descendant::input")).sendKeys(billingcity);
	    	driver.findElement(By.xpath("//label[text()='Shipping City']/parent::div/descendant::input")).sendKeys(city);
	    	
	    	driver.findElement(By.xpath("//label[text()='Billing State']/parent::div/descendant::input")).sendKeys(state);
	    	driver.findElement(By.xpath("//label[text()='Shipping State']/parent::div/descendant::input")).sendKeys(state);
	    	driver.findElement(By.xpath("//label[text()='Billing Postal Code']/parent::div/descendant::input")).sendKeys(billingPo);
	    	driver.findElement(By.xpath("//label[text()='Shipping Postal Code']/parent::div/descendant::input")).sendKeys(billingPo);
	    	act.scrollByAmount(300,300).perform();
	    	driver.findElement(By.xpath("//label[text()='Billing Country']/parent::div/descendant::input")).sendKeys(country);
	    	
	    	driver.findElement(By.xpath("//label[text()='Shipping Country']/parent::div/descendant::input")).sendKeys(country);
	    	
	    	driver.findElement(By.xpath("//button[text()='Add Product']")).click();
			 mainwindow=driver.getWindowHandle();
			windows=driver.getWindowHandles();
			for(String window:windows) {
				if(!(window.equals(mainwindow))) {
					driver.switchTo().window(window);
					break;
				}
			}
			driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
			//webdriverwait
			wait.until(d->driver.getWindowHandles().size() == 1);
	    	driver.switchTo().window(mainwindow);
	    	
			
	    	act.scrollByAmount(600,600).perform();
			
	    	driver.findElement(By.xpath("//button[text()='Create Quote']")).click();
		  
		  
	    	WebElement mess=driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
			wait.until(ExpectedConditions.elementToBeClickable(mess));
			System.out.println(mess.getText());
			System.out.println("===============created Quote==============="); 
		
	}
	//====================================method3==============================//
	public static void createSalesOrder(WebDriver driver) throws InterruptedException, EncryptedDocumentException, IOException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement createoportunity= driver.findElement(By.xpath("//a[text()='Sales Order']"));
		if(createoportunity.isDisplayed()) {
			   System.out.println("Create oportunity page displayed");
		   }else {
			   System.out.println("not Displayed");
		   }
		   createoportunity.click();
		   Thread.sleep(6000);
		   
			WebElement ele1 =driver.findElement(By.xpath("//span[text()='Create Order']/parent::button"));
			 ele1.click();
			 
			
			FileInputStream f2=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
			Workbook wb=WorkbookFactory.create(f2);
			
			Sheet sh=wb.getSheet("Sheet1");
			Row row=sh.getRow(13);
			String subject=row.getCell(15).toString()+Createrandom();
			String status=row.getCell(16).toString();
			String validTill=row.getCell(14).toString();
			
			 driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
			 driver.findElement(By.xpath("//input[@name='status']")).sendKeys(subject);
			 driver.findElement(By.xpath("//input[@name='validTill']")).sendKeys(validTill);
			 
			 Row r2=sh.getRow(7);
			 String billaddress=r2.getCell(4).toString();
			 String shippingaddress=r2.getCell(10).toString();
			 String billingPo=r2.getCell(8).toString();
			 String adrressPo=r2.getCell(14).toString();
			 String billingcity=r2.getCell(6).toString();
			 String city=r2.getCell(12).toString();
			 String state=r2.getCell(13).toString();
			 String country=r2.getCell(20).toString();
			 
			 
		//popup1	
			driver.findElement(By.xpath("//label[text()='Opportunity']/parent::div/descendant::button")).click();
			String mainwindow=driver.getWindowHandle();
			Set<String> windows=driver.getWindowHandles();
			for(String window:windows) {
				if(!(window.equals(mainwindow))) {
					driver.switchTo().window(window);
					break;
				}
			}
			driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
			//webdriverwait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(d->driver.getWindowHandles().size() == 1);
	    	driver.switchTo().window(mainwindow);
	    	
	    	//popup2
	    	driver.findElement(By.xpath("//label[text()='Quote']/parent::div/descendant::button")).click();
	    	 mainwindow=driver.getWindowHandle();
			 windows=driver.getWindowHandles();
			for(String window:windows) {
				if(!(window.equals(mainwindow))) {
					driver.switchTo().window(window);
					break;
				}
			}
			driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
			//webdriverwait
			wait.until(d->driver.getWindowHandles().size() == 1);
	    	driver.switchTo().window(mainwindow);
	    	
	    	
	    	//popup3
	    	driver.findElement(By.xpath("//label[text()='Contact']/parent::div/descendant::button")).click();
	    	 mainwindow=driver.getWindowHandle();
			 windows=driver.getWindowHandles();
			for(String window:windows) {
				if(!(window.equals(mainwindow))) {
					driver.switchTo().window(window);
					break;
				}
			}
			driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
			//webdriverwait
			wait.until(d->driver.getWindowHandles().size() == 1);
	    	driver.switchTo().window(mainwindow);
	    	
	    	Actions act=new Actions(driver);
	    	act.scrollByAmount(400,400).perform();
	    	driver.findElement(By.xpath("//label[text()='Billing Address']/parent::div/descendant::textarea")).sendKeys(billaddress);
	    	driver.findElement(By.xpath("//label[text()='Shipping Address']/parent::div/descendant::textarea")).sendKeys(shippingaddress);
	    	driver.findElement(By.xpath("//label[text()='Billing PO Box']/parent::div/descendant::input")).sendKeys(billingPo);
	    	driver.findElement(By.xpath("//label[text()='Shipping PO Box']/parent::div/descendant::input")).sendKeys(adrressPo);
	    	driver.findElement(By.xpath("//label[text()='Billing City']/parent::div/descendant::input")).sendKeys(billingcity);
	    	driver.findElement(By.xpath("//label[text()='City']/parent::div/descendant::input")).sendKeys(city);
	    	driver.findElement(By.xpath("//label[text()='Billing State']/parent::div/descendant::input")).sendKeys(city);
	    	driver.findElement(By.xpath("//label[text()='State']/parent::div/descendant::input")).sendKeys(state);
	    	act.scrollByAmount(300,300).perform();
	    	driver.findElement(By.xpath("//label[text()='Billing Postal Code']/parent::div/descendant::input")).sendKeys(billingPo);
	    	driver.findElement(By.xpath("//label[text()='Postal Code']/parent::div/descendant::input")).sendKeys(adrressPo);
	    	driver.findElement(By.xpath("//label[text()='Billing Country']/parent::div/descendant::input")).sendKeys(country);
	    	driver.findElement(By.xpath("//label[text()='Country']/parent::div/descendant::input")).sendKeys(country);
	    	
	    	act.scrollByAmount(400,400).perform();
	    	
	    	driver.findElement(By.xpath("//button[text()='Add Product']")).click();
			 mainwindow=driver.getWindowHandle();
			windows=driver.getWindowHandles();
			for(String window:windows) {
				if(!(window.equals(mainwindow))) {
					driver.switchTo().window(window);
					break;
				}
			}
			driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
			//webdriverwait
			wait.until(d->driver.getWindowHandles().size() == 1);
	    	driver.switchTo().window(mainwindow);
	    	
	    	driver.findElement(By.xpath("//button[text()='Create Sales Order']")).click();
	    	
	    	WebElement mess=driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
			wait.until(ExpectedConditions.elementToBeClickable(mess));
			System.out.println(mess.getText());
	    	
	    	System.out.println("=====================Created sales order====================================");
	}
	
	//=====********************************=helpermethods************************************//
	
	public static int Createrandom() {
		int r=(int)(Math.random()*1000)+1;
		return r;
		
	}

}
