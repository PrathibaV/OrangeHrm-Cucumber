package orangehrm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy (name="username") WebElement username;
	@FindBy (name="password") WebElement password;
	@FindBy (xpath="//button[contains(.,'Login')]") WebElement loginButton;
	@FindBy (xpath="//p[contains(@class,'oxd-alert-content-text')]") WebElement errorMessage;
	
	
	public void enterUsername(String userName) {
		username.sendKeys(userName);
	}
	
	public void enterpassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public Boolean checkErrorMsg(String expectedMessage) {
		return errorMessage.getText().equals(expectedMessage);
	}

}
