package orangehrm.pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DependentsPage extends BasePage{
	
	public DependentsPage(WebDriver driver) {
		super(driver);		
	}
		
	@FindBy (xpath="//label[text()='Name']/../..//input") WebElement nameField;
	@FindBy (xpath="//label[text()='Relationship']/../..//div[@class='oxd-select-text-input']") WebElement relationshipDD;
	@FindBy (xpath="//div[@role='listbox']//span") List<WebElement> relationshipDDList;
	@FindBy (xpath="//div[@class='oxd-date-input']/i") WebElement dobField;
	@FindBy (xpath="//button[contains(.,'Add')]") WebElement addButton;


	public void clickAddBtn() {
		addButton.click();
	}
	
	public void enterDependentName(String dependentName) {
		nameField.sendKeys(dependentName);
	}
	
	
	public void selectRelationship(String relation) {
		relationshipDD.click();
		for (WebElement relationship: relationshipDDList) {
			if (relationship.getText().equalsIgnoreCase(relation)) {
				relationship.click();
				break;
			}
		}
	}
	
	public void selectDOB(String dob) throws InterruptedException {
		dobField.click();
		datePicker(dob);
	}


}
