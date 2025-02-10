package orangehrm.stepDefinitions;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import orangehrm.dependencyInjection.TestContext;
import orangehrm.pageobjects.LoginPage;
import orangehrm.utilities.ConfigReader;
import orangehrm.utilities.ExcelReader;
import orangehrm.utilities.Helper;
import orangehrm.webDriverManager.DriverManager;

public class LoginPageSD {

	private SoftAssert softAssert = new SoftAssert();
	private String userName;
	private String passWord;
	private String errorMessage;
	private Properties prop;

	private TestContext testContext;

	public LoginPageSD(TestContext testContext) {
		this.testContext = testContext;
	}

	@Given("User is in Login page")
	public void user_is_in_login_page() {
		testContext.getLogger().info("Launching the application");
		prop = testContext.getConfigReader().initProperties();
		String portalUrl = prop.getProperty("url");
		testContext.getHelper().getApplication(portalUrl);
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password_and_clicks_login_button() {
		testContext.getLogger().info("Entering valid credentials");
		userName = prop.getProperty("username");
		passWord = prop.getProperty("password");
		testContext.getLoginPage().enterUsername(userName);
		testContext.getLoginPage().enterpassword(passWord);
	}

	@When("clicks Login button")
	public void clicks_login_button() {
		testContext.getLogger().info("Clicking Login button");
		testContext.getLoginPage().clickLoginButton();
	}

	@Then("User lands on Dashboard page")
	public void user_lands_on_dashboard_page() {
		softAssert.assertEquals(testContext.getLoginPage().getPageHeader(), "Dashboard");
	}

	@When("User enters invalid credentials from {string} and {int}")
	public void user_enters_invalid_credentials_from_and(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		userName = data.get("userName");
		passWord = data.get("password");
		errorMessage = data.get("message");

		testContext.getLoginPage().enterUsername(userName);
		testContext.getLoginPage().enterpassword(passWord);

	}

	@Then("User sees appropriate error message")
	public void user_sees_error_message() {
		softAssert.assertTrue(testContext.getLoginPage().checkErrorMsg(errorMessage));
	}
}
