package utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.math3.exception.NullArgumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains generic methods related to WebDriver
 * @author Charle Maro J
 * 
 */

public class WebDriverUtility {
	
	//=======  maximize,minimize,fullscreen ==========
	/*
	 * maximize
	 * void return
	 *
	 */
	
	public WebDriver getBrowser(String browser) {
		switch(browser) {
		case "Chrome":
			return new ChromeDriver();
		case "Edge":
			return new EdgeDriver();	
			
		case "FireFox":
			return new FirefoxDriver();	
		default:
			throw new NullPointerException();
		}
		
	}
	/**
	 * 
	 * @param driver
	 * @param url
	 */
	public void loadWebsite(WebDriver driver,String url) {
		driver.get(url);
	}
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/*
	 *minimize
	 *void return 
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/*
	 * fullscreen
	 * void return
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	
	//=======  ImplicitWait ,ExplicitWait -visible,clickable ========
	/*
	 * 
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/*
	 * 
	 */
	public void explicitWaitByClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * 
	 */
	public void explicitWaitByVisbility(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//handleDropdown
	/**
	 * 
	 */
	public void handleDropDownByValue(WebDriver driver,WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	/*
	 * 
	 */
	public void handleDropDownByIndex(WebDriver driver,WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/*
	 * 
	 */
	public void handleDropDownByVisibleText(WebDriver driver,WebElement element,String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}
	
	//Actions class-mouseHovering,drag and drop,click'n'hold,release
	//move by offset,double click,context click
	
	/*
	 * hoverthe element
	 */
	public void performMouseHovering(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/*
	 *hovering element and offset to x and y 
	 */
	
	public void mouseHovering(WebDriver driver,WebElement element,int x,int y) {
		Actions act=new Actions(driver);
		act.moveToElement(element,x,y).perform();
	}
	public void scrollDown(WebDriver driver,int x,int y) {
		Actions act=new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}
	/*
	 * dragNdrop form source to target
	 */
	public void DragNDrop(WebDriver driver,WebElement source,WebElement target) {
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	
    
	public void click(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.click(element).click().perform();
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffset(WebDriver driver,int x,int y) {
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).perform();
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickNhold(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void release(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.release(element).perform();
	}
	
	public void handleVerticalScrollBar(WebDriver driver,WebElement element,int y ) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();;
		act.moveByOffset(0,y).perform();
		act.release().perform();
	}
	
	public void handleHorizontalScrollBar(WebDriver driver,WebElement element,int x ) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();;
		act.moveByOffset(x,0).perform();
		act.release().perform();
	}
	
	
	//alerts 
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public Alert moveToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		moveToAlert(driver).accept();;
	}
	/**
	 * 
	 * @param driver
	 */
	public void declineAlert(WebDriver driver) {
		moveToAlert(driver).dismiss();
	}
	
	//frames
	/**
	 * 
	 * @param driver
	 * @param index
	 * @return
	 */
	public WebDriver moveToFrameByIndex(WebDriver driver,int index) {
		return driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param name
	 * @return
	 */
	public WebDriver moveToFrameBy(WebDriver driver,String name) {
		return driver.switchTo().frame(name);
	}
	
	
	
	
	
	
     //=============  handle windows  ===================
	/**
	 * 
	 * @param driver
	 * @param title
	 */
	public void handleWindows(WebDriver driver,String title) {
		String mainWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			String temptitle=driver.switchTo().window(window).getTitle();
			if(temptitle.contains(title)) {
				break;
			}
		}
	}
	
	public void handleTwoWindows(WebDriver driver) {
		String mainWindow=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows) {
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}
	}
	
	
	public void ImplicitWaitTillOneMainWindow(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(d->driver.getWindowHandles().size()==1);
	}
	
	public String captureScreenShot(WebDriver driver,String screenshot) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\ScreenShot\\"+screenshot+".png");
		FileHandler.copy(src,dst);
	    return dst.getAbsolutePath();//for extend report
	}
	
	
	
			
	
	
	
	


}
