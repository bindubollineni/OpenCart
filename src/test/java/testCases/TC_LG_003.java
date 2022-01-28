package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LG_003 extends BaseClass{

	@Test	(groups= {"sanity","master"})
	public void TC_LG_003(){
		logger.info("TC_LG_003 is started");

		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("URL is launched");

			driver.manage().window().maximize();

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmailId(rb.getString("email"));		
			logger.info("Provided Email");

			lp.setPwd(rb.getString("password"));
			logger.info("Provided Password");

			lp.click_LoginBtn();
			logger.info("Clicked Login");

			boolean validate_title =lp.validateTitle();
			logger.info("title captured");

			if(validate_title==true)
			{
				logger.info("Validation Passed");

				hp.clickMyAccount();
				logger.info("Clicked My Account");

				MyAccountPage ap =  new MyAccountPage(driver);
				ap.clickLogout();
				logger.info("Clicked LogOut");

				LogoutPage lg =new LogoutPage(driver);
				String lg_title=	lg.validate_LogoutTitle();
				Assert.assertEquals(lg_title, "Account Logout");
				logger.info("Validated Logout Message");
			
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Validation Failed");

				Assert.assertTrue(false);
			}
		}

		catch(Exception e)
		{
			logger.error("TC_LG_003 Failed");
			Assert.fail();
		}

	}
}
