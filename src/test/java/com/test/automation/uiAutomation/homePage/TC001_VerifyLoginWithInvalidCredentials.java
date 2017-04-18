/**
 * 
 */
package com.test.automation.uiAutomation.homePage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;

/**
 * @author Souni
 *
 */
public class TC001_VerifyLoginWithInvalidCredentials extends TestBase
{
	HomePage homePage;
	
	private static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	
	
	@BeforeTest
	public void setUp()
	{
		log.info("Test Case sutUp Started");
		init();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials()
	{
		log.info("========== Test case Started - TC001_VerifyLoginWithInvalidCredentials ==========");
		homePage = new HomePage(driver);
		homePage.loginToApplication("test@testm.com", "password123");
		Assert.assertEquals(homePage.loginErrorMSG(), "Authentication failed.");
	}
	
	@AfterClass
	public void endTest()
	{
		driver.close();
		log.info("*** End OF Test TC001_VerifyLoginWithInvalidCredentials ***");
	}

}
