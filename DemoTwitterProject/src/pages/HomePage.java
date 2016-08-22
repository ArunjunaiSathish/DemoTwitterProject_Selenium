package pages;

import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Reporter;
import wrapper.TwitterWrappers;

public class HomePage extends TwitterWrappers{
	public HomePage(){
		if(!driver.getTitle().contains("Twitter - see what's happening")){
			Reporter.reportStep("This is not a Home Page", "FAIL");
		}
	}

	public SignUpPage clickSignUp() throws InterruptedException{
		clickByLink("Sign up");
		//Thread.sleep(3000);
		wait("//input[@id='full-name']");
		return new SignUpPage();
	}
	public LoginPage clickLogin(){
		clickByLink("Log In");
		return new LoginPage();
	}
	
	public HomePage verifyHomePageexist(){
		verifyTitle("Twitter - see what's happening");
		return this;
	}

	public HomePage verifyHomePageelement(){
		verifyTextByCssSelector("h2.StreamsHero-header", "What’s Happening");
		return this;
	}
	
	public HomePage navigateSubpages(String pagelinktext){
		mouseOverByXpath("//span[contains(text(),'More ')]");
		clickByLink(pagelinktext);
		return this;
	}
	
	
}
