package Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePurchaseOrder {
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
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Contact']/parent::button")).click();
		//testscript
		
		FileInputStream f2=new FileInputStream("C:\\Users\\User\\eclipse-workspace\\FireFlink.NINZACRM.AutomationFrameWork\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(f2);
		
		Sheet sh=wb.getSheet("Sheet1");
		Row row=sh.getRow(4);
		String  contactname=row.getCell(4).toString();
		String organization=row.getCell(2).toString();
		String mobile=row.getCell(5).toString();
		String title=row.getCell(4).toString();
		String email=row.getCell(3).toString();
		String Department=row.getCell(2).toString();
		
		driver.findElement(By.xpath("//input[@name='contactName']")).sendKeys(contactname);
		driver.findElement(By.xpath("//input[@name='organizationName']")).sendKeys(organization);
		int r=(int)(Math.random()*10)+1;
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobile+r);
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys(title);
		
		
		StringBuilder mail=new StringBuilder();
		for(int i=0;i<email.length();i++) {
			int rans=(int)(Math.random()*101)+1;
			if(i==3) {
				mail.append(rans);
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
		Actions act=new Actions(driver);
		
		driver.findElement(By.xpath("(//button[@class='select-btn'])[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d->driver.getWindowHandles().size() == 1);
    	driver.switchTo().window(mainwindow);

		WebElement ele1=driver.findElement(By.xpath("//label[contains(normalize-space(),'Office Phone')]/following-sibling::input"));
		act.scrollByAmount(300,300).perform();
		act.sendKeys(ele1,mobile+r).perform();
		
		driver.findElement(By.xpath("//button[text()='Create Contact']"));
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		WebElement mess=driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		wait.until(ExpectedConditions.elementToBeClickable(mess));
		System.out.println(mess.getText());
		
		
		System.out.println("============executed==========");
		

				
	}

}
