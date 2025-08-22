package Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyPurchaseOrderWithUpdatedProduct {
	public static void main(String[] args) throws IOException {
		FileInputStream f1=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(f1);
		//common datas
		String browser=prop.getProperty("browser");
		
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
		driver.findElement(By.xpath("//a[text()='Purchase Order']")).click();
		driver.findElement(By.xpath("//span[text()='Create Order']/parent::button")).click();
		
		
		//testscript
		
		FileInputStream f2=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(f2);
		Sheet sh=wb.getSheet("Sheet1");
		Row r=sh.getRow(7);
		
		String duedate=r.getCell(2).toString();
		String subject=r.getCell(3).toString();
		String status=r.getCell(4).toString();
		String billaddress=r.getCell(4).toString();
		String shippingaddress=r.getCell(10).toString();
		String billingPo=r.getCell(8).toString();
		String adrressPo=r.getCell(14).toString();
		String billingcity=r.getCell(6).toString();
		String city=r.getCell(12).toString();
		String state=r.getCell(13).toString();
		String country=r.getCell(20).toString();
		
		driver.findElement(By.xpath("//input[@name='dueDate']")).sendKeys(duedate);
		
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@name='status']")).sendKeys(status);
		
		driver.findElement(By.xpath("//label[text()='Contact']/parent::div/descendant::button")).click();
		
		//handle popup
		
		String mainwindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		//v
		if(windows.size()>1) {
			System.out.println("Pop up is displayed ");
		}
		for(String window:windows) {
			if(!(window.equals(mainwindow))) {
				driver.switchTo().window(window);
				break;
			}
			
		}
		Actions act=new Actions(driver);
		
		driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(d->driver.getWindowHandles().size() == 1);
    	driver.switchTo().window(mainwindow);
    	
    	act.scrollByAmount(300,300).perform();
    	
    	driver.findElement(By.xpath("//label[text()='Billing Address']/parent::div/descendant::textarea")).sendKeys(billaddress);
    	driver.findElement(By.xpath("//label[text()='Shipping Address']/parent::div/descendant::textarea")).sendKeys(shippingaddress);
    	driver.findElement(By.xpath("//label[text()='Billing PO Box']/parent::div/descendant::input")).sendKeys(billingPo);
    	driver.findElement(By.xpath("//label[text()='Shipping PO Box']/parent::div/descendant::input")).sendKeys(adrressPo);
    	driver.findElement(By.xpath("//label[text()='Billing City']/parent::div/descendant::input")).sendKeys(billingcity);
    	driver.findElement(By.xpath("//label[text()='City']/parent::div/descendant::input")).sendKeys(city);
    	act.scrollByAmount(200,200).perform();
    	driver.findElement(By.xpath("//label[text()='Billing State']/parent::div/descendant::input")).sendKeys(state);
    	driver.findElement(By.xpath("//label[text()='State']/parent::div/descendant::input")).sendKeys(state);
    	driver.findElement(By.xpath("//label[text()='Billing Postal Code']/parent::div/descendant::input")).sendKeys(billingPo);
    	act.scrollByAmount(300,300).perform();
    	driver.findElement(By.xpath("//label[text()='Postal Code']/parent::div/descendant::input")).sendKeys(adrressPo);
    	driver.findElement(By.xpath("//label[text()='Billing Country']/parent::div/descendant::input")).sendKeys(country);
    	driver.findElement(By.xpath("//label[text()='Country']/parent::div/descendant::input")).sendKeys(country);
    	act.scrollByAmount(300,300).perform();
    	driver.findElement(By.xpath("(//button[@class='action-button']/parent::div/descendant::*[local-name()='svg'])[last()]")).click();
    	
    	
    	//handle pop
    	 windows=driver.getWindowHandles();
		//v
		if(windows.size()>1) {
			System.out.println("Pop up is displayed ");
		}
		for(String window:windows) {
			if(!(window.equals(mainwindow))) {
				driver.switchTo().window(window);
				break;
			}
			
		}
		
		driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
		wait.until(d->driver.getWindowHandles().size() == 1);
    	driver.switchTo().window(mainwindow);
		
    	driver.findElement(By.xpath("//button[text()='Create Purchase Order']")).click();
    	
    	WebElement mess=driver.findElement(By.xpath("//div[@class='Toastify__toast-container Toastify__toast-container--top-right']/descendant::div[@role='alert']"));
    	wait.until(ExpectedConditions.elementToBeClickable(mess));
    	System.out.println(mess.getText());
		System.out.println("=====executed======");	
		
	}
	

}
