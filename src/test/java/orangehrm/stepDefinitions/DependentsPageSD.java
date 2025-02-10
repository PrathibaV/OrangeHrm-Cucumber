package orangehrm.stepDefinitions;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.*;
import orangehrm.dependencyInjection.TestContext;
import orangehrm.webDriverManager.DriverManager;


public class DependentsPageSD {
	
	TestContext testContext;
	private SoftAssert softAssert = new SoftAssert();

	public DependentsPageSD (TestContext testContext) {
		this.testContext = testContext;
	}
	
	@Given("User is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {

		Properties prop = testContext.getConfigReader().initProperties();
		String userName = prop.getProperty("username");
		String passWord = prop.getProperty("password");
		testContext.getLoginPage().enterUsername(userName);
		testContext.getLoginPage().enterpassword(passWord);
		testContext.getLoginPage().clickLoginButton();
	}

	@Given("user is in My Info page")
	public void user_is_in_my_info_page() {
		testContext.getHomePage().clickMyInfoLink();
	}

	@Given("User is in Dependents page")
	public void user_is_in_dependents_page() {
		testContext.getMyInfoPage().clickDependentsLink();
	}

	@When("User clicks Add button under Assigned Dependents section")
	public void user_clicks_add_button_under_assigned_dependents_section() {
		testContext.getDependentsPage().clickAddBtn();
	}

	@When("User enters all the dependents details from {string} and {int}")
	public void user_enters_all_the_dependents_details_from_dependents_data_and(String sheetName, int rowNum)
			throws IOException, InterruptedException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		String dependentName = data.get("name");
		String relationship = data.get("relationship");
		String DOB = data.get("dob");

		testContext.getDependentsPage().enterDependentName(dependentName);
		testContext.getDependentsPage().selectRelationship(relationship);
		testContext.getDependentsPage().selectDOB(DOB);
	}

	@When("User clicks Save button")
	public void user_clicks_save_button() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		testContext.getDependentsPage().clickSaveBtn();
	}

	@Then("User gets the success message {string}")
	public void user_gets_the_success_message(String expectedMessage) {

		if (testContext.getDependentsPage().getSuccessMsg().equals(expectedMessage)) {
			softAssert.assertTrue(true);
		} else {
			softAssert.assertTrue(false);
			testContext.getLogger().error("Success message not displayed due to an error");

		}

	}
}