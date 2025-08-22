package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WebDriverUtility;

public class CreateLeadPage extends WebDriverUtility {
	
	@FindBy(xpath="//input[@name='leadStatus']")
	private WebElement leadStatusTf;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement leadNameTF;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement companyNameTf;
	
	
	@FindBy(xpath="//input[@name='leadSource']")
	private WebElement leadSourceTf;
	
	@FindBy(xpath="//input[@name='industry']")
	private WebElement industryTf;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneNumTf;
	
	//
	@FindBy(xpath="//select[@id='search-criteria']")
	private WebElement selectCampaignDd;
	@FindBy(id="search-input")
	private WebElement searchCampaignTf;
	@FindBy(xpath="//button[text()='Select']")
	private WebElement selectBtn;
	
	//
	@FindBy(xpath="//label[text()='Campaign']/parent::div/descendant::button")
	private WebElement campaignBtn;
	
	@FindBy(xpath="//button[text()='Create Lead']")
	private WebElement createLeadBtn;
	
	public CreateLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getLeadStatusTf() {
		return leadStatusTf;
	}

	public WebElement getLeadNameTF() {
		return leadNameTF;
	}

	public WebElement getCompanyNameTf() {
		return companyNameTf;
	}

	public WebElement getLeadSourceTf() {
		return leadSourceTf;
	}

	public WebElement getIndustryTf() {
		return industryTf;
	}

	public WebElement getPhoneNumTf() {
		return phoneNumTf;
	}

	public WebElement getCampaignBtn() {
		return campaignBtn;
	}

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}
	
    //buisness logic
	public void enterLeadStatus(String status) {
		leadStatusTf.sendKeys(status);
	}
	
	public void enterLeadName(String name) {
		leadNameTF.sendKeys(name);
	}
	
	public void enterLeadSource(String source) {
		leadSourceTf.sendKeys(source);
	}
	
	public void enterPhoneNo(String number) {
		phoneNumTf.sendKeys(number);
	}
	
	/**
	 * to return the company field
	 * @param driver
	 * @param companyname
	 */
	public void enterCompany(String companyname) {
		companyNameTf.sendKeys(companyname);
	}
	
	/**
	 * 
	 * @param driver
	 * @param industryname
	 */
	public void enterIndustrt(String industryname) {
		industryTf.sendKeys(industryname);
	}
	/**
	 * 
	 * @param driver
	 * @param id
	 */
	public void enterCampaign(WebDriver driver,String id) {
		campaignBtn.click();
		String main=driver.getWindowHandle();
		handleTwoWindows(driver);
		handleDropDownByVisibleText(driver,selectCampaignDd,"Campaign ID");
		searchCampaignTf.sendKeys(id);
		selectBtn.click();
		ImplicitWaitTillOneMainWindow(driver);
		driver.switchTo().window(main);
	}
	
	public void createLead() {
		createLeadBtn.click();
	}
	

	

	
}
