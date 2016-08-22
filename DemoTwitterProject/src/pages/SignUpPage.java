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
		clickById("submit_button");
		wait("//select[@id='device_country_code']");
		return new TelephoneDetailsPage();
	}
	
	public SignUpPage verifySignUpPageexist(){
		verifyTitle("Sign up for Twitter");
		return this;
	}
	
	public HomePage clickTwitterImage() throws InterruptedException{
	clickByCssSelector("a[class='js-nav js-tooltip js-dynamic-tooltip']");
	//Thread.sleep(3000);
	wait("//a[@class='Button StreamsLogin js-login']");
	return new HomePage();
	}
}
