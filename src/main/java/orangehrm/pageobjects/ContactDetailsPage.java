package orangehrm.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage extends BasePage {
	
	public ContactDetailsPage(WebDriver driver) {
		super(driver);	
	}
	
	
	//Contact Details
	@FindBy (xpath="//label[text()='Street 1']/../following-sibling::div/input") WebElement street1Field;
	@FindBy (xpath="//label[text()='City']/../following-sibling::div/input") WebElement cityField;
	@FindBy (xpath="//label[text()='State/Province']/../following-sibling::div/input") WebElement stateField;
	@FindBy (xpath="//label[text()='Zip/Postal Code']/../following-sibling::div/input") WebElement zipField;
	@FindBy (xpath="//label[text()='Mobile']/../following-sibling::div/input") WebElement mobilePhField;
	@FindBy (xpath="//label[text()='Other Email']/../following-sibling::div/input") WebElement otherEmailField;
	
	@FindBy (className="oxd-select-text-input") WebElement countryDropDown;
	@FindBy (className="oxd-select-dropdown") WebElement countryDDSection;
	@FindBy (xpath="//*[contains(@class,'orangehrm-horizontal-padding')]//button[contains(.,'Save')]") WebElement saveContactDetailsBtn;
	
	@FindBy (xpath="//button[contains(.,'Add')]") WebElement addButton;
	@FindBy (xpath="//i[contains(@class,'oxd-file-input-icon')]") WebElement fileBrowseButton;
	@FindBy (xpath="//*[@class='orangehrm-attachment']//button[contains(.,'Save')]") WebElement saveAttachmentBtn;
	@FindBy (xpath="//p[contains(@class,'oxd-text--toast-message')]") WebElement SuccessMsg;
	@FindBy (xpath="//div[contains(@class,'oxd-table-cell')][2]/div") WebElement attachedFile;

	public void enterContactDetails(String street1, String city, String state, String zip, String mobilePh, String otherEmail) {
		street1Field.clear();
		street1Field.sendKeys(street1);
		
		cityField.clear();
		cityField.sendKeys(city);
		
		stateField.clear();
		stateField.sendKeys(state);
		
		zipField.clear();
		zipField.sendKeys(zip);
		
		mobilePhField.clear();
		mobilePhField.sendKeys(mobilePh);
		
		otherEmailField.clear();
		otherEmailField.sendKeys(otherEmail);
		
	}

	public void selectCountry(String countryName) {
		countryDropDown.click();
		countryDDSection.findElement(By.xpath("//span[text()='"+countryName+"']")).click();
	}
	
	public void clickSaveContactDetailsBtn() {
		saveContactDetailsBtn.click();
	}
	
	public void clickAddBtn() {
		addButton.click();
	}
	
	public void uploadFileinContacts(String filePath) {
		fileBrowseButton.sendKeys(filePath);
	}
	
	public void clickSaveAttachmentBtn() {
		saveAttachmentBtn.click();
	}

	/*public String checkSuccessMsg() {
		return SuccessMsg.getText();
	} */
	
	public Boolean checkAttachedFileName(String fileName) {
		return attachedFile.getText().equals(fileName);
	}
}
