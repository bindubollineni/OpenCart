package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_SF_015 extends BaseClass{

	@Test (groups= {"master"})
	public void TC_SF_015() {

		logger.info("TestCase TC_SF_015 started");

		driver.get(rb.getString("appURL"));
		logger.info("URL is launched");

		HomePage hp = new HomePage(driver);

		hp.setSearchtxt(rb.getString("search"));
		logger.info("Enter txt to search product");

		hp.clickSearchBtn();
		logger.info("Clicked search button");


		SearchPage sp = new SearchPage(driver);
		try
		{
			if(sp.selectDropdown()==true)
			{
				logger.info("DropDown Validated");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("DropDown Validation failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.info("TestCase TC_SF_015 failed");
		}
			
		}
	}
