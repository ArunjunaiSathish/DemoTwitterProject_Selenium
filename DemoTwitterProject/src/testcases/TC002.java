package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.DataInputProvider;
import wrapper.TwitterWrappers;

public class TC002 extends TwitterWrappers{
	@BeforeClass
	  @Parameters({ "browsername", "platform", "sHubUrl", "sHubPort" })
		public void startTestCase(String browsername,String platform,String sHubUrl,String sHubPort){
		  	TwitterWrappers.browserName 	= browsername;
			TwitterWrappers.platform = platform;
			TwitterWrappers.sHubUrl = sHubUrl;
			TwitterWrappers.sHubPort = sHubPort;
			TwitterWrappers.dataSheetName 	= "TC002";
			TwitterWrappers.testCaseName 	= "TC002 - Validate User is able to signup/register";
			TwitterWrappers.testDescription = "Validate User is able to signup/register";
		}

	
	
  @Test(dataProvider="fetchdata")
  public void validateRegistration(String UserName,String emailID,String Password)  {
	  try {
		new HomePage()
		  .clickSignUp()
		  .verifySignUpPageexist()
		  .enterRegistrationDetails(UserName, emailID, Password);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	  
  }
  @DataProvider(name="fetchdata")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName);		
	}
	
}
