package pages;

import utils.Reporter;
import wrapper.TwitterWrappers;

public class TelephoneDetailsPage extends TwitterWrappers{

	public TelephoneDetailsPage(){
		if(!driver.getTitle().contains("Enter your telephone"));{
			Reporter.reportStep("This is not a TelephoneDetails Page", "FAIL");
		}
	}
	
}
