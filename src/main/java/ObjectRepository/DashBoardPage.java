package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WebDriverUtility;

public class DashBoardPage extends WebDriverUtility {
     @FindBy(xpath="//a[text()='Campaigns']")
     private WebElement campaignLink;
      
     @FindBy(xpath="//a[text()='Contacts']")
     private WebElement contactLink;
     /**
      * 
      */
     @FindBy(xpath="//a[text()='Leads']")
     private WebElement leadLink;
     
     @FindBy(xpath=" //span[.='Create Lead']/parent::button")
     private WebElement createLeatBtn;
     
     @FindBy(xpath="//a[text()='Opportunities']")
     private WebElement opportunityLink;
     
     @FindBy(xpath="//a[text()='Products']")
     private WebElement productLink;
     
     @FindBy(xpath="//a[text()='Quotes']")
     private WebElement quoteLink;
     
     @FindBy(xpath="//a[text()='Purchase Order']")
     private WebElement purchaseLink;
     
     @FindBy(xpath="//a[text()='Sales Order']")
     private WebElement salesLink;
     
     @FindBy(xpath="//a[text()='Invoice']")
     private WebElement invoiceLink;
     
     @FindBy(xpath="//li[text()='Admin Console']")
     private WebElement adminLink;
     
     @FindBy(xpath="//span[text()='Create Campaign']/parent::button")
     private WebElement createCampaignBtn;
  
    //logout
     
     @FindBy(xpath="(//div[@class='user-icon-container'])[last()]")
     private WebElement usericonBtn;

     @FindBy(xpath="//div[@class='dropdown-item logout']")
     private WebElement logoutBtn;

	 /**
      *
      * @param driver
      */
     public DashBoardPage(WebDriver driver){
    	 PageFactory.initElements(driver, this);
     }
     
     public WebElement getusericonBtn() {
    	 return usericonBtn;
     }
     
     public WebElement getCreateCampaignBtn() {
 		return createCampaignBtn;
 	}
     public WebElement getcreateLeatBtn() {
    	 return createLeatBtn;
     }
     
	 public WebElement getCampaignLink() {
		 return campaignLink;
	 }

	 public WebElement getContactLink() {
		 return contactLink;
	 }

	 public WebElement getLeadLink() {
		 return leadLink;
	 }

	 public WebElement getOpportunityLink() {
		 return opportunityLink;
	 }

	 public WebElement getProductLink() {
		 return productLink;
	 }

	 public WebElement getQuoteLink() {
		 return quoteLink;
	 }

	 public WebElement getPurchaseLink() {
		 return purchaseLink;
	 }

	 public WebElement getSalesLink() {
		 return salesLink;
	 }

	 public WebElement getInvoiceLink() {
		 return invoiceLink;
	 }

	 public WebElement getAdminLink() {
		 return adminLink;
	 }
	 
	 //buisnesslogic
	 
	 public void enterCampaign() {
		 campaignLink.click();
	 }
	 
	 public void enterContact() {
		 contactLink.click();
	 }
	 //
	 public void enterLead() {
		 leadLink.click();
	 }
	 public void enterCreateLead() {
		 createLeatBtn.click();
	 }
	 
	 //
	 public void enterOpportunity() {
		 opportunityLink.click();
	 }
	 
	 public void enterProducts() {
		 productLink.click();
	 }
	 
	 public void enterQuotes() {
		 quoteLink.click();
	 }
	 
	 public void enterPurchaseOrder() {
		 purchaseLink.click();
	 }
	 
	 public void enterSalesOrder() {
		 salesLink.click();
	 }
	 public void enterInvoice() {
		 invoiceLink.click();
	 }
	 public void enterAdminConsole() {
		 adminLink.click();
	 }
	 
	 //buisness
	 
	 public void logout(WebDriver driver) throws InterruptedException {
		 Thread.sleep(6000);
		 performMouseHovering(driver,usericonBtn);
		 logoutBtn.click();
		 
	 }
	 
	 

	
     
     
     
     
     
     
     
     
     
     
     
     
   
     

}
