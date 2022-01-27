package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{ 
	@Test(groups= {"regression", "master"})
	public void TC_002_Login()
	{

		logger.info("Starting TC_002_Login");

		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home PageDisplayed");
			
			driver.manage().window().maximize();

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked My account link");

			hp.clickLogin();
			logger.info("Clicking login link");

			LoginPage lp = new LoginPage(driver);
	
			lp.setEmailId(rb.getString("email"));
			logger.info("provide email");

			lp.setPwd(rb.getString("password"));
			logger.info("provided password");

			lp.click_LoginBtn();
			logger.info("clicked login button");


			boolean targetpage = lp.validateLogin();
			if(targetpage)
			{
				logger.info("succesful validation");

				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login failed");
				Assert.assertTrue(false);
			}
		}
		catch (Exception e)
		{

			Assert.fail();
		}
		logger.info("Finished TC_002_Login");

	}
}
