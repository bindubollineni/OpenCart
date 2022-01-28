package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_FP_004 extends BaseClass{
	@Test(groups= {"master"})
	public void TC_FP_004()
	{
		try
		{
			logger.info("TC_FP_004 Forgot Password Started");

			driver.get(rb.getString("appURL"));
			logger.info("URL Launched");

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked My Account Page");

			hp.clickLogin();
			logger.info("Clicked Login Page");

			LoginPage lp = new LoginPage(driver);

			lp.click_ForgotPwd();
			logger.info("Clicked Forgot password link");

			ForgotPasswordPage fp = new ForgotPasswordPage(driver);
			fp.setForgotPwdEmail(rb.getString("email"));
			logger.info("provided email to reset password");

			fp.clickContinueBtn();
			logger.info("Clicked Continue button to reset password");

			String expected_title = fp.validateResetPwdMsg();
			String actual_title = "An email with a confirmation link has been sent your email address.";

			Assert.assertEquals(expected_title, actual_title);
		}
			catch(Exception e)
			{
				logger.info("TC_FP_004 Failed");
				Assert.fail();
			}


		}

	}
