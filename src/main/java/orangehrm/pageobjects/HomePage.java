package orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy (xpath="//span[text()='My Info']") WebElement myInfoLink;
	@FindBy (xpath="//span[contains(text(),'Recruitment')]") WebElement recruitmentLink;

	public void clickMyInfoLink() {
		myInfoLink.click();
	}

	public void clickRecruitmentLink() {
		recruitmentLink.click();
	}
}
