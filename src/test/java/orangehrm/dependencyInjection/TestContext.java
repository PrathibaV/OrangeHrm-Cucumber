package orangehrm.dependencyInjection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import orangehrm.pageobjects.ContactDetailsPage;
import orangehrm.pageobjects.DependentsPage;
import orangehrm.pageobjects.HomePage;
import orangehrm.pageobjects.LoginPage;
import orangehrm.pageobjects.MyInfoPage;
import orangehrm.utilities.ConfigReader;
import orangehrm.utilities.ExcelReader;
import orangehrm.utilities.Helper;
import orangehrm.webDriverManager.DriverManager;

public class TestContext {
	
	private DriverManager driverManager;
	private LoginPage loginPage ;
	private HomePage homePage;
	private MyInfoPage myInfoPage;
	private DependentsPage dependentsPage;
	private ContactDetailsPage contactDetailsPage;
	private ExcelReader excelReader = new ExcelReader();
	//private Logger logger;
	private ConfigReader configReader;
	private Helper helper;
	
	
	public DriverManager getDriverManager() {
		return driverManager==null ? driverManager=new DriverManager() : driverManager;
	}
	
	public LoginPage getLoginPage() {
		return loginPage==null ? loginPage=new LoginPage(DriverManager.getDriver()) : loginPage;
	}
	
	public HomePage getHomePage() {
		return homePage==null ? homePage=new HomePage(DriverManager.getDriver()) : homePage;
	}
	
	public MyInfoPage getMyInfoPage() {
		return myInfoPage==null ? myInfoPage=new MyInfoPage(DriverManager.getDriver()) : myInfoPage;
	}
	
	public DependentsPage getDependentsPage() {
		return dependentsPage==null ? dependentsPage=new DependentsPage(DriverManager.getDriver()) : dependentsPage;
	}
	
	public ContactDetailsPage getContactDetailsPage() {
		return contactDetailsPage==null ? contactDetailsPage=new ContactDetailsPage(DriverManager.getDriver()) : contactDetailsPage;
	}
	
	public ExcelReader getExcelReader() {
		return excelReader==null ? excelReader=new ExcelReader() : excelReader;
	}
	
	public Logger getLogger() {
		return LogManager.getLogger(this.getClass());
	}
	
	public ConfigReader getConfigReader() {
		return configReader==null ? configReader=new ConfigReader() : configReader;
	}
	
	public Helper getHelper() {
		return helper==null ? helper=new Helper(DriverManager.getDriver()) : helper;
	}
	
	
	
	
}
