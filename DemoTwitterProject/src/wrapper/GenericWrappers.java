package wrapper;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporter;

/**
 * @author Arun
 *
 */

public class GenericWrappers {

	protected static RemoteWebDriver driver;
	public String sUrl, primaryWindowHandle;
	public Properties objprop;

	public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
			//sHubUrl = prop.getProperty("HUB");
			sUrl = prop.getProperty("URL");
			//sHubPort = prop.getProperty("PORT");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		objprop = new Properties();
		try {
			objprop.load(new FileInputStream(new File("./Object.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will launch browser and maximize it and set the wait for 30
	 * seconds and loads the application URL
	 * 
	 * @author Arunjunai
	 * @param sHubPort 
	 * @param sHubUrl 
	 * @param platform 
	 * @param url
	 *            - the url with http or https
	 */

	public boolean invokeApp(String browser, String platform, String sHubUrl, String sHubPort) throws MalformedURLException {
		boolean bReturn = false;
		
		try {
			
			
			DesiredCapabilities dc = new DesiredCapabilities();;
			if(browser.equals("firefox")){
				
				dc=DesiredCapabilities.firefox();
				dc.setBrowserName(browser);
			}
			else if(browser.equalsIgnoreCase("chrome")){
			//	System.setProperty("webdriver.chrome.driver", "E:\\Backup\\selenium-32bit\\drivers\\chromedriver.exe");
				
				dc.setBrowserName(browser);
			}
			else if(browser.equals("IE")){
			//	System.setProperty("webdriver.ie.driver", "E:\\Backup\\selenium-32bit\\drivers\\IEDriverServer.exe");
				dc.setBrowserName(browser);
			}
			if(platform.equals("VISTA")){
				
				dc.setPlatform(Platform.VISTA);
			}
			else if(platform.equals("WIN8_1")){
				dc.setPlatform(Platform.WIN8_1);
			}
			

			driver = new RemoteWebDriver(new URL("http://" + sHubUrl + ":"
					+ sHubPort + "/wd/hub"), dc);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);
			primaryWindowHandle = driver.getWindowHandle();

			bReturn = true;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return bReturn;
	}

	/**
	 * This method will enter the value to the text field using id attribute to
	 * locate
	 * 
	 * @param idValue
	 *            - id of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @author Arunjunai
	 */
	public boolean enterById(String idValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);
			bReturn = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bReturn;
	}

	/**
	 * This method will verify the title of the browser
	 * 
	 * @param title
	 *            - The expected title of the browser
	 * @author Arunjunai
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				Reporter.reportStep("The title of the page matches with the value :"+title, "PASS");
				bReturn = true;
			}
			else
				Reporter.reportStep("The title of the page:"+driver.getTitle()+" did not match with the value :"+title, "SUCCESS");

		}catch (Exception e) {
			Reporter.reportStep("The title did not match", "FAIL");
		}

		return bReturn;
	}
	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Arunjunai
	 */
	public boolean verifyTextByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().equalsIgnoreCase(text)){
			Reporter.reportStep("The text: "+sText+" matches with the value :"+text, "PASS");
			bReturn = true;
		}else{
			Reporter.reportStep("The text: "+sText+" did not match with the value :"+text, "FAIL");
		}


		return bReturn;
	}
//Close browser
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Reporter.reportStep("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.", "FAIL");
		}

	}

	public boolean clickById(String id) {
		boolean bReturn = false;
		try{
			driver.findElement(By.id(id)).click();
			Reporter.reportStep("The element with id: "+id+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with id: "+id+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	public boolean clickByName(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.name(name)).click();
			Reporter.reportStep("The element with name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	public boolean clickByLink(String name) {
		boolean bReturn = false;
		try{
			driver.findElement(By.linkText(name)).click();
			Reporter.reportStep("The element with link name: "+name+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with link name: "+name+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	public boolean clickByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			Reporter.reportStep("The element : "+xpathVal+" is clicked.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
		return bReturn;
	}

	public boolean mouseOverByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by xpath : "+xpathVal+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	public boolean mouseOverByLinkText(String linkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			Reporter.reportStep("The mouse over by link : "+linkName+" is performed.", "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The mouse over by link : "+linkName+" could not be performed.", "FAIL");
		}
		return bReturn;
	}

	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			Reporter.reportStep("The element with xpath: "+xpathVal+" could not be found.", "FAIL");
		}
		return bReturn; 
	}

	public boolean selectById(String id, String value) {
		boolean bReturn = false;
		try{
			Select s = new Select(driver.findElement(By.id(id)));
			s.selectByVisibleText(value);
			Reporter.reportStep("The element with id: "+id+" is selected with value :"+value, "PASS");

			bReturn = true;

		} catch (Exception e) {
			Reporter.reportStep("The value: "+value+" could not be selected.", "FAIL");
		}
		return bReturn;
	}

	
}
