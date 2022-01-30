package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.DesktopPage;
import pageObjects.HomePage;
import pageObjects.Product_Compare;
import pageObjects.Product_DisplayPage;
import testBase.BaseClass;

public class TC_PC_004 extends BaseClass{

	@Test(groups= {"master"})
	public void TC_PC_004()
	{
		logger.info("TestCase TC_PC_004 started");

		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("URL is launched");

			HomePage hp = new HomePage(driver);
			hp.click_Desktops();
			logger.info("Clicked the Desktop button");

			hp.click_ShowAllDesktop();
			logger.info("Clicked Show all Desktop");

			DesktopPage dp = new DesktopPage(driver);
			dp.click_Listview();
			logger.info("Clicked List View");

			dp.click_Product();
			logger.info("Choose the product from the list");

			Product_DisplayPage pd = new Product_DisplayPage(driver);
			pd.clickCompareProduct();
			logger.info("Added the product to compare product");

			Product_Compare pc = new Product_Compare(driver);
			String confirm_mssg = pc.ConfirmationMsgProductComparision();
			logger.info("Captured Confirmation message after adding the product to compare");

			if(confirm_mssg.contains("Success: You have added"))
			{
				logger.info("Validation passed");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Validation failed");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			logger.info("Testcase TC_PC_004 failed");
			Assert.fail();

		}

	}
}
