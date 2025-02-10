package orangehrm.stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import orangehrm.dependencyInjection.TestContext;
import orangehrm.pageobjects.ContactDetailsPage;
import orangehrm.pageobjects.MyInfoPage;
import orangehrm.utilities.ConfigReader;
import orangehrm.webDriverManager.DriverManager;

public class ContactDetailsSD {

	TestContext testContext;

	public ContactDetailsSD (TestContext testContext) {
		this.testContext = testContext;
	}
	
	@Given("User is in Contact Details page")
	public void user_is_in_contact_details_page() {
		testContext.getLogger().info("User is clicking Contact Details link");
		testContext.getMyInfoPage().clickContactDetailsLink();	    
	}

	@When("User enters all the contact details")
	public void user_enters_all_the_contact_details(DataTable dataTable) throws InterruptedException {
		testContext.getLogger().info("User is in Contact Details page");
		List<Map<String,String>> datatable = dataTable.asMaps(String.class, String.class);
		Map<String,String> data = datatable.get(0);
	   String street1 = data.get("street1");
	   String city = data.get("city");
	   String state = data.get("state");
	   String zip = data.get("zip");
	   String country = data.get("country");
	   String mobilePh = data.get("mobilePh");
	   String otherEmail = data.get("otherEmail");
	   
	   Thread.sleep(5000);
	   testContext.getContactDetailsPage().enterContactDetails(street1, city, state, zip, mobilePh, otherEmail);
	   testContext.getContactDetailsPage().selectCountry(country);
	   testContext.getLogger().info("Entered contact details");
	}

	@When("user clicks Save button")
	public void user_clicks_save_button() {
		testContext.getContactDetailsPage().clickSaveBtn();	    
	}


}
