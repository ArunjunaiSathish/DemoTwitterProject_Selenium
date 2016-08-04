package pages;

import utils.Reporter;
import wrapper.TwitterWrappers;

public class SignUpPage extends TwitterWrappers {
	public SignUpPage(){
	if(!driver.getTitle().contains("Sign up for Twitter")){
		Reporter.reportStep("This is not a SignUp Page", "FAIL");
	}
}
}
