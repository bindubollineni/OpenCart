package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

//TestCase for first page of URL
public class TC_001_AccountRegistration extends BaseClass{


	@Test(groups= {"sanity","master"})
	public void test_account_Registration()
	{
		/* Some times webElement may throw exceptions
		 * better to write in try catch block
		 */
		try 
		{
			logger.info("Starting TC_001_AccountRegistration");

			driver.get(rb.getString("appURL"));
			logger.info("Home PageDisplayed");
			driver.manage().window().maximize();

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicking My Account link");

			hp.clickRegister();
			logger.info("Clicking Register link");


			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			regpage.setFirstName("abcd");
			logger.info("First Name Provided");

			regpage.setLastName("abcdefgh");
			logger.info("Last Name Provided");

			regpage.setEmail(randomestring()+"@gmail.com");
			regpage.setTelephone("345677");
			regpage.setPassword("abcd");
			regpage.setConfirmPassword("abcd");
			regpage.click_RadioBtn();
			regpage.check_PrivacyPolicy();
			logger.info("Provided details to Registration");

			regpage.click_Continue();
			logger.info("Clicked on continue");


			String confmsg = regpage.checkConfirmation();
			System.out.println(confmsg);
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				logger.info("Confirmation message validated");

				Assert.assertTrue(true);
			} 
			else 
			{
				logger.error("Account Registration Failed ");
				//	captureScreen(driver, "test_accout_Registration"); //Capturing screenshot

				Assert.assertTrue(false);

			}
		}
		catch(Exception e)
		{
			logger.error("Account Registration failed");
			Assert.fail();
		}
		logger.info(" Finished 	TC_001_AccountRegistration");

	}



}
