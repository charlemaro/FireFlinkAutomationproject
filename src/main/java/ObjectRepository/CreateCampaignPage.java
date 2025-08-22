package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage  {
	
	
	@FindBy(xpath ="//input[@name='expectedCloseDate']")
	private WebElement expectedDateDF;
	
	@FindBy(xpath="//input[@name='campaignName']")
	private WebElement campaignNameTf;
	
	@FindBy(xpath="//input[@name='targetAudience']")
	private WebElement targetAudienceTf;
	
	@FindBy(xpath="//input[@name='targetSize']")
	private WebElement targetSizeTf;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createCampaignBtn;
	
	@FindBy(xpath="//span[text()='Create Campaign']/parent::button")
	private WebElement campaignBtn;

	
	
	/**
	 * 
	 * @param driver
	 */
	

	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getCampaignBtn() {
		return campaignBtn;
	}
	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}
	
	public WebElement getExpectedDateDF() {
		return expectedDateDF;
	}

	public WebElement getCampaignNameTf() {
		return campaignNameTf;
	}

	public WebElement getTargetAudienceTf() {
		return targetAudienceTf;
	}

	public WebElement getTargetSizeTf() {
		return targetSizeTf;
	}

	
	
	//buisness
	public void enterCampaignField() {
		campaignBtn.click();
	}
	
	public void createCampaign() {
		createCampaignBtn.click();
	}
	
	public void enterCampaignName(String campaignName) {
		campaignNameTf.sendKeys(campaignName);
	}
	
	 public void enterTargetSize(String target) {
		 targetSizeTf.sendKeys(target);
	 }
	 	

	

}
