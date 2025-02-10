package orangehrm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage extends BasePage {
	
	public MyInfoPage(WebDriver driver) {
		super(driver);	
	}
	
	//Left panel links
	@FindBy (linkText="Contact Details") WebElement contactDetailsLink;
	@FindBy (linkText="Dependents") WebElement dependentsLink;
	
	
	//Contact details section
	public void clickContactDetailsLink() {
		contactDetailsLink.click();
	}
	
	
	//Dependents section
	public void clickDependentsLink() {
		dependentsLink.click();
	}
	

	
	
	
}
