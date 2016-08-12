package pages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Reporter;
import wrapper.TwitterWrappers;

public class SignUpPage extends TwitterWrappers {
	public SignUpPage(){
	if(!driver.getTitle().contains("Sign up for Twitter")){
		Reporter.reportStep("This is not a SignUp Page", "FAIL");
	}
}
	
	public TelephoneDetailsPage enterRegistrationDetails(String UserName,String emailID,String Password){
		enterById("full-name", UserName);
		enterById("email", emailID);
		enterById("password", Password);
		clickByXpath("//input[@name='user[use_cookie_personalization]']");
		//name = user[use_cookie_personalization]
		clickById("password");
			//	submit_button
		return new TelephoneDetailsPage();
	}
	
	public SignUpPage verifySignUpPageexist(){
		verifyTitle("Sign up for Twitter");
		return this;
	}
	
	
}
