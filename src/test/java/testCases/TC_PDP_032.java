package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

/*1. Enter any existing Product name into the Search text box field - <Refer Test Data>
2. Click on the button having search icon
3. Click on 'Add to Cart' option on the product that is displayed in the Search Results 
4. Click on 'Cart' button which is in black color beside the search icon button on the top of the page
5. Click on the Product Name link in the displayed toggle box (Validate ER-1)
*/
public class TC_PDP_032 extends BaseClass {
@Test (groups= {"master"})
	public void TC_PDP_032() throws InterruptedException
	{
		logger.info("TC_PDP_032 test case started");
		
		driver.get(rb.getString("appURL"));
		logger.info("URL Launched");
		
		HomePage hp = new HomePage(driver);
		
		hp.setSearchtxt(rb.getString("product_search"));
		logger.info("Search text iMac entered in textbox");
		
		hp.clickSearchBtn();
		logger.info("Clicked Search Button");
		
		SearchPage sp = new SearchPage(driver);
		
		sp.click_Add_To_Cart();
		logger.info("clicked add to cart next to image");
		
		sp.click_Cart_Total();
		logger.info("clicked add to cart next to Search Button");
		Thread.sleep(1000);
		sp.click_ProductName();
		logger.info("clicked on Product Name on Toggle window");
		
		
	}
}
