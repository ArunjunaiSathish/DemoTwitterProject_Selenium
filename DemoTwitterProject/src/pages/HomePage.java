package pages;

import utils.Reporter;
import wrapper.TwitterWrappers;

public class HomePage extends TwitterWrappers{
	public HomePage(){
		if(!driver.getTitle().contains("Twitter")){
			Reporter.reportStep("This is not a Home Page", "FAIL");
		}
	}

	public SignUpPage clickSignUp() throws InterruptedException{
		clickByLink("Sign up");
		Thread.sleep(3000);
		return new SignUpPage();
	}
	public LoginPage clickLogin(){
		clickByLink("Log In");
		return new LoginPage();
	}
	
}
