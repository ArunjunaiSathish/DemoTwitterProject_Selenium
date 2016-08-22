package pages;

import utils.Reporter;
import wrapper.TwitterWrappers;

public class TelephoneDetailsPage extends TwitterWrappers{

	public TelephoneDetailsPage(){
		if(!driver.getTitle().contains("Enter your phone"))
		{
			
			Reporter.reportStep("This is not a Telephone Details Page", "FAIL");
		}
	}
	
}
