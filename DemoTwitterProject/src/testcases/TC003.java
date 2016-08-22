package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.DataInputProvider;
import wrapper.TwitterWrappers;

public class TC003 extends TwitterWrappers {
	@BeforeClass
	  @Parameters({ "browsername", "platform", "sHubUrl", "sHubPort" })
		public void startTestCase(String browsername,String platform,String sHubUrl,String sHubPort){
		  	TwitterWrappers.browserName 	= browsername;
			TwitterWrappers.platform = platform;
			TwitterWrappers.sHubUrl = sHubUrl;
			TwitterWrappers.sHubPort = sHubPort;
			TwitterWrappers.dataSheetName 	= "TC003";
			TwitterWrappers.testCaseName 	= "TC003 - Click Twitter Image and verify if it takes to home page or not";
			TwitterWrappers.testDescription = "Click Twitter Image and verify if it takes to home page or not";
		}

	
	
@Test
public void validateTwitterImageNavigation()  {
	  try {
		new HomePage()
		  .clickSignUp()
		  .verifySignUpPageexist()
		  .clickTwitterImage()
		  
		  .verifyHomePageexist()
		  .verifyHomePageelement();
		  
		  
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  
}
}
