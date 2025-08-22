package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule 1:
	 //rule2:
	@FindBy(id="username")
	private WebElement usernameTF; 
	
	@FindBy(id="inputPassword")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//button[.='Sign In']")
	private WebElement signInBtn;
	
	//rule3
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	rule4

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}
	
	
	//rule5
	//buisnesslogic
	
	public void loginToApp(String username,String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signInBtn.click();
	}

     	 
	
}
