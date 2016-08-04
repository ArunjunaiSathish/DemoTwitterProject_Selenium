package wrapper;

import org.testng.annotations.*;

import utils.DataInputProvider;
import utils.Reporter;

public class TwitterWrappers extends GenericWrappers {
	protected String browserName;
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;
//T
	@BeforeSuite
	public void beforeSuite() {
		Reporter.startResult();
	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.startTestCase();
		invokeApp(browserName);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.endResult();
	}

	@AfterTest
	public void afterTest() {

	}

	@AfterMethod 
	public void afterMethod() {
		quitBrowser();
	}

	@DataProvider(name = "fetchData")
	public Object[][] getData() {
		return DataInputProvider.getSheet(dataSheetName);
	}

}
