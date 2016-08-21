package pages;

import utils.Reporter;
import wrapper.TwitterWrappers;

public class BusinessceosPage extends TwitterWrappers {

	public BusinessceosPage(){
		if(!driver.getTitle().contains("Twitter - see what's happening")){
			Reporter.reportStep("This is not a Home or BusinessceosPage Page", "FAIL");	
		}
	}
	
	
	public BusinessceosPage retrieveLinkcount(String LinkName) {
		fetchlinkcount(LinkName);	
		return this;
	} 

}
