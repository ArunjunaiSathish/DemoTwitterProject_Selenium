package wrapper;

import java.net.MalformedURLException;

import org.testng.annotations.*;

import utils.DataInputProvider;
import utils.Reporter;

public class TwitterWrappers extends GenericWrappers {
	protected static String platform;
	protected static String sHubUrl;
	protected static String sHubPort;
	protected static String browserName;
	protected static String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;

	@BeforeSuite
	public void beforeSuite() {
		Reporter.startResult();
	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		Reporter.startTestCase();
		invokeApp(browserName,platform,sHubUrl,sHubPort);
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
//
//	@DataProvider(name = "fetchData")
//	public Object[][] getData() {
//		return DataInputProvider.getSheet(dataSheetName);
//	}

}
