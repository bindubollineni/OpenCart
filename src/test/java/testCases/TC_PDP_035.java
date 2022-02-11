package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Product_DisplayPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

/*1. Enter any existing Product name into the Search text box field  - <Refer Test Data>
2. Click on the button having search icon
3. Click on the Product displayed in the Search results
4. Check the Page Title, Page Heading and Page URL of hte displayed 'Product Display' page (Validate ER-1)
 * 
 */
public class TC_PDP_035 extends BaseClass
{
	
	@Test(groups= {"master"})
	public void TC_PDP_035()
	{
		try
		{
		logger.info("TC_PDP_035 TestCase Started");
		
			driver.get(rb.getString("appURL"));
			logger.info("URL Launched");

			HomePage hp = new HomePage(driver);

			hp.setSearchtxt(rb.getString("product_search1"));
			logger.info("Search text iMac entered in textbox");

			hp.clickSearchBtn();
			logger.info("Clicked Search Button");

			SearchPage sp = new SearchPage(driver);

			sp.click_Product_AppleCinema_Img();
			logger.info("Clicked on Apple Cinema Product");

			Product_DisplayPage pdp = new Product_DisplayPage(driver);

			//Validation of PageHeading
			String expHeading= pdp.get_PageHeading();
			if(expHeading.equals("Your Store"))
			{
				logger.info("Validation of Page Heading Passed");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Validation of Page Heading Failed");
				Assert.assertTrue(false);
			}

			//Validation of Page title
			String expTitle= pdp.get_PageTitle();
			if(expTitle.equals("Apple Cinema 30"))
			{
				logger.info("Validation of Page Title Passed");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Validation of Page Title Failed");
				Assert.assertTrue(false);
			}

			//Validation of PageURL
			String expURL= "https://demo.opencart.com/index.php?route=product/product&product_id=42&search=Apple+Cinema+30%22";
			String actURL=	pdp.get_PageURL();
			if(actURL.equals(expURL))
			{
				logger.info("Validation of Page URL Passed");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Validation of Page URL Failed");
				Assert.assertTrue(false);
			}
		} 
		catch(Exception e)
		{
			logger.error("TC_PDP_035 failed");
			Assert.fail();
		}
		logger.info("Finished TC_PDP_035");
	}
}
