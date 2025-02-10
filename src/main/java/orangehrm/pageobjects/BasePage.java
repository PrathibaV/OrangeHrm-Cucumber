package orangehrm.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Date Picker
	@FindBy (xpath="//div[@class='oxd-calendar-selector-year-selected']/p") WebElement dobYear;
	@FindBy (className="oxd-calendar-dropdown") WebElement yearMonthDD;
	@FindBy (xpath="//div[@class='oxd-calendar-selector-month-selected']/p") WebElement dobMonth;
	@FindBy (xpath="//div[@class='oxd-calendar-dates-grid']/div/div") List<WebElement> dobDatesList;
	
	//Dashboard page
	@FindBy (xpath="//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]") WebElement pageHeader;
	
	//Save button on all pages
	@FindBy (xpath="//button[contains(.,'Save')]") WebElement saveBtn;

	//Success message on clicking Save button
	@FindBy (xpath="//p[contains(@class,'oxd-text--toast-message')]") WebElement SuccessMsg;

	
	public void datePicker(String dob) {
		//yyyy-dd-mm
		String[] DOB = dob.split("/");
		String year=DOB[0];
		String date=DOB[1];
		String month=DOB[2];
		
		String monthName = null;
		
		switch (month) {
		case "01": monthName="January"; break;
		case "02": monthName="February"; break;
		case "03": monthName="March"; break;
		case "04": monthName="April"; break;
		case "05": monthName="May"; break;
		case "06": monthName="June"; break;
		case "07": monthName="July"; break;
		case "08": monthName="August"; break;
		case "09": monthName="September"; break;
		case "10": monthName="October"; break;
		case "11": monthName="November"; break;
		case "12": monthName="December"; break;
		default: System.out.println("Enter a valid month");
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(dobYear)).click();
		//dobYear.click();
		//WebElement yearInput = yearMonthDD.findElement(By.xpath("//li[text()='"+year+"']"));
		wait.until(ExpectedConditions.elementToBeClickable(yearMonthDD.findElement(By.xpath("//li[text()='"+year+"']")))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(dobMonth)).click();

		//dobMonth.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(yearMonthDD.findElement(By.xpath("//li[text()='"+monthName+"']")))).click();

		//yearMonthDD.findElement(By.xpath("//li[text()='"+monthName+"']")).click();
		
		for (WebElement dobDate: dobDatesList) {
			if(Integer.parseInt(dobDate.getText()) == Integer.parseInt(date)) {
				wait.until(ExpectedConditions.elementToBeClickable(dobDate)).click();

				//dobDate.click();
				break;				
			}
		}
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
	public String getSuccessMsg() {
		return SuccessMsg.getText();
	}
}
