package orangehrm.hooks;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import orangehrm.dependencyInjection.TestContext;
import orangehrm.utilities.ConfigReader;
import orangehrm.utilities.Helper;
import orangehrm.webDriverManager.DriverManager;

public class Hooks {

	private Properties prop;
	private WebDriver driver;
	private String portalUrl;
	private String browserName;
	private TestContext testContext;

	public Hooks(TestContext testContext) {
		this.testContext = testContext;
	}

	@Before(order = 0)
	public void setUp(Scenario scenario) {
		// String scenarioName = scenario.getName();
		// scenario.log("Starting scenario: "+scenarioName);
		prop = testContext.getConfigReader().initProperties();
		portalUrl = prop.getProperty("url");
		browserName = ConfigReader.getBrowserType() != null ? ConfigReader.getBrowserType()
				: prop.getProperty("browser");
	}

	@Before(order = 1)
	public void launchBrowser(Scenario scenario) {
		driver = testContext.getDriverManager().initDriver(browserName);
		testContext.getLogger().info("Launching OrangeHRM application");
		if (!testContext.getHelper().isScenarioTaggedWith(scenario, "@login")) {
			testContext.getHelper().getApplication(portalUrl);
		}
	}

	@After(order = 0)
	public void tearDown() {
		testContext.getLogger().info("Quitting driver");
		DriverManager.getDriver().quit();
	}

	@After(order = 1)
	public void takeScreenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			testContext.getLogger().info("Scenario " + scenario.getName() + " failed and taking screenshot");
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] source = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", screenshotName);
			//Allure.addAttachment(screenshotName, new ByteArrayInputStream(source));
		}
	}

}
