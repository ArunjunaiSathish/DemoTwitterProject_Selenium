package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BusinessceosPage;
import pages.HomePage;
import wrapper.TwitterWrappers;

public class TC004 extends TwitterWrappers {
	@BeforeClass
	  @Parameters({ "browsername", "platform", "sHubUrl", "sHubPort" })
		public void startTestCase(String browsername,String platform,String sHubUrl,String sHubPort){
		  	TwitterWrappers.browserName 	= browsername;
			TwitterWrappers.platform = platform;
			TwitterWrappers.sHubUrl = sHubUrl;
			TwitterWrappers.sHubPort = sHubPort;
			TwitterWrappers.dataSheetName 	= "TC004";
			TwitterWrappers.testCaseName 	= "TC004 - Select Business CEOs under More and validate the screen functionality";
			TwitterWrappers.testDescription = "Select Business CEOs under More and validate the screen functionality";
		}

	
	
@Test(priority=0)
public void validateSubpagesNavigation()  {
	  new HomePage()
	  .navigateSubpages("Business & CEOs");
}

@Test(priority=1)
public void fetchCEOLinkCount()  {
	  new BusinessceosPage()
	  .retrieveLinkcount("CEOs");
}	



}
