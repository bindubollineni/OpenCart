package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Product_Compare;
import pageObjects.Product_DisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_PC_001 extends BaseClass{
	@Test(groups= {"master"})
	public void TC_PC_001()
	{
		logger.info("TestCase TC_PC_001 is started");

		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("URL is launched ");

			HomePage hp = new HomePage(driver);

			hp.setSearchtxt(rb.getString("search"));
			logger.info("Text Mac is entered in inputsearch box");

			hp.clickSearchBtn();
			logger.info("Clicked search Button");

			SearchPage sp = new SearchPage(driver);

			sp.clickProductDisplayed();
			logger.info("Clicked on the product displayed ");


			Product_DisplayPage pd = new Product_DisplayPage(driver);

			pd.clickCompareProduct();
			logger.info("Clicked on product to be compared");

			Product_Compare pc = new Product_Compare(driver);

			boolean st= pc.click_ProductComparisionlink();
			Assert.assertTrue(st);
			logger.info("Clicked on productCompairsion link");
		}
		catch(Exception e)
		{
			logger.info("TestCase TC_PC_001 Failed");
			Assert.fail();
			e.getMessage();
		}

	}


}
