package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverUtility;

public class CreateOpportunityPage extends WebDriverUtility  {
	
	@FindBy(xpath="//span[text()='Create Opportunity']/parent::button")
	private WebElement opportunityBtn;
	
	@FindBy(xpath="//input[@name='nextStep']")
	private WebElement nextStepTf;
	
	@FindBy(xpath="//input[@name='opportunityName']")
	private WebElement opportunityNameTf;
	
	@FindBy(xpath="//input[@name='salesStage']")
	private WebElement salesStageTf;
	
	@FindBy(xpath="//input[@name='amount']")
	private WebElement amountTf;
	
	@FindBy(xpath="//input[@name='businessType']")
	private WebElement businessTypeTf;
	
	@FindBy(xpath="//label[text()='Lead']/parent::div/descendant::button")
	private WebElement fetchLeadBtn;
	
	@FindBy(xpath="//button[text()='Create Opportunity']")
	private WebElement createOpportunityBtn;
	
		
	/**
	 * when constructor it assigns the locator of (this)instance to the (driver) reference
	 * @param driver
	 */
	public  CreateOpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getOpportunityBtn() {
		return opportunityBtn;
	}


	public WebElement getNextStepTf() {
		return nextStepTf;
	}


	public WebElement getOpportunityNameTf() {
		return opportunityNameTf;
	}


	public WebElement getSalesStageTf() {
		return salesStageTf;
	}


	public WebElement getAmountTf() {
		return amountTf;
	}


	public WebElement getBusinessTypeTf() {
		return businessTypeTf;
	}


	public WebElement getFetchLeadBtn() {
		return fetchLeadBtn;
	}


	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}
	
	
	public void enterLead(WebDriver driver,String id) {
		fetchLeadBtn.click();
		String main=driver.getWindowHandle();
		handleTwoWindows(driver);
//		handleDropDownByVisibleText(driver,selectCampaignDd,"Campaign ID");
//		searchCampaignTf.sendKeys(id);
//		selectBtn.click();
//		ImplicitWaitTillOneMainWindow(driver);
		driver.switchTo().window(main);
	}


	
	
	
	
	
}
