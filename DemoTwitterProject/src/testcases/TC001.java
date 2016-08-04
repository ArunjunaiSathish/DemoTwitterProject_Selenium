package testcases;

import org.testng.annotations.*;

import pages.HomePage;
import wrapper.TwitterWrappers;

public class TC001 extends TwitterWrappers{
  @BeforeClass
	public void startTestCase(){
		browserName 	= "firefox";
		dataSheetName 	= "";
		testCaseName 	= "TC001 - Check Signup Page is able to open";
		testDescription = "Check Signup Page is able to open";
	}
  @Test
  public void validateSignUp(){
	  new HomePage()
	  .clickSignUp();
	  
  }
}
