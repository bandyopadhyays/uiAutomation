/**
 * 
 */
package com.test.automation.uiAutomation.homePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.uiActions.HomePage;

/**
 * @author Souni
 *
 */
public class TC001_VerifyLoginWithInvalidCredentials 
{
	HomePage homePage;
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials()
	{
		homePage = new HomePage(driver);
		homePage.loginToApplication("test@testm.com", "password123");
		Assert.assertEquals(homePage.loginErrorMSG(), "Authentication failed.");
	}
	
	@AfterClass
	public void endTest()
	{
		
	}

}
