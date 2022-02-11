package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Product_Compare;
import pageObjects.Product_DisplayPage;
import testBase.BaseClass;

public class TC_PDP_001 extends BaseClass {
	@Test(groups= {"master"})
	public void TC_PDP_001() throws InterruptedException
	{
		logger.info(" TestCase TC_PDP_001 started");

		driver.get(rb.getString("appURL"));

		HomePage hp= new HomePage(driver);
		hp.setSearchtxt(rb.getString("product_search"));
		logger.info("Provided text iMac in Search textbox");

		hp.clickSearchBtn();
		logger.info("Clicked Search button");

		Product_DisplayPage pd = new Product_DisplayPage(driver);
		pd.clickiMac_product();
		logger.info("Clicked iMac Product");

		pd.clickiMac_img();
		logger.info("Clicked iMac image");

		pd.clickLeftArrow();
		Thread.sleep(1000);

		pd.clickRightArrow();
		Thread.sleep(1000);

		pd.clickClose();
		Thread.sleep(1000);

	/*	pd.clickiMac_img1();
		logger.info("Clicked iMac image1 ");

		pd.clickLeftArrow();
		Thread.sleep(1000);
		pd.clickRightArrow();
		Thread.sleep(1000);
		pd.clickClose();
		Thread.sleep(1000);

		pd.clickiMac_img2();
		logger.info("Clicked iMac image2");

		pd.clickLeftArrow();
		Thread.sleep(1000);
		pd.clickRightArrow();
		Thread.sleep(1000);
		pd.clickClose();
		Thread.sleep(1000);
		
*/
		Product_DisplayPage pdp = new Product_DisplayPage(driver);

		//Validating Product Name
		if(pdp.validate_ProductName().equals("iMac"))
		{
			logger.info("Validated Product Name Passed");
			Assert.assertTrue(true);
		}else
		{
			logger.info("Validated Product Name Failed");
			Assert.assertTrue(false);
		}

		//Validating Product Brand 
		if(pdp.validate_ProductBrand().equals("Apple"))
		{
			logger.info("Validated Product Brand Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Validated Product Brand Failed");
			Assert.assertTrue(false);
		}

			//Validating Confirm Message after clicking Add to Cart button

		pdp.set_Quantity("2");
		logger.info("Setting Quantity to 2");
		pdp.click_AddToCart();
		logger.info("Clicking on Add to Cart Button ");
		
		if(pdp.validate_TxtAddToCart().contains("Success: You have added iMac to your shopping cart!"))
		{
			logger.info("Validated Sucess Message after adding to cart Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Validated Sucess Message after adding to cart Failed");
			Assert.assertTrue(false);

		}
		

		Thread.sleep(3000);
		driver.close();


	}


}
