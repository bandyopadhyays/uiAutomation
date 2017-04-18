/**
 * 
 */
package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Souni
 *
 */
public class HomePage 
{
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		log.info("HomePage object created.");
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".login") WebElement eleSignInLink;
	
	@FindBy(css="#email") WebElement eleEmailAddress;
	
	@FindBy(css="#passwd") WebElement elePassword;
	
	@FindBy(css="#SubmitLogin") WebElement btnSignIn;
	
	@FindBy(css=".alert.alert-danger>ol>li") WebElement eleAuthenticationFailed;
	
	public void loginToApplication(String email,String password)
	{
		eleSignInLink.click();
		eleEmailAddress.sendKeys(email);
		elePassword.sendKeys(password);
		btnSignIn.click();
	}
	
	public String loginErrorMSG()
	{
		if(eleAuthenticationFailed.isDisplayed())
		{
			return eleAuthenticationFailed.getText();
		}
		else
		{
			System.out.println("No Error Messege Found");
			return null;
		}
	}
	
	

}
