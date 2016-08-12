package testcases;

import org.testng.annotations.*;

import pages.HomePage;
import wrapper.TwitterWrappers;

public class TC001 extends TwitterWrappers{

  @BeforeClass
  @Parameters({ "browsername", "platform", "sHubUrl", "sHubPort" })
	public void startTestCase(String browsername,String platform,String sHubUrl,String sHubPort){
	  	TwitterWrappers.browserName 	= browsername;
		TwitterWrappers.platform = platform;
		TwitterWrappers.sHubUrl = sHubUrl;
		TwitterWrappers.sHubPort = sHubPort;
		dataSheetName 	= "";
		testCaseName 	= "TC001 - Validate User is able to click Signup button";
		testDescription = "Validate User is able to click Signup button";
	}
  @Test
  public void validateSignUp() throws InterruptedException{
	  new HomePage()
	  .clickSignUp();
	  
  }
}
