package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='row']//h4/a")
	List<WebElement> search_Items;

	@FindBy(xpath="//select[@id='input-limit']/option")
	List <WebElement> drpdown;

	@FindBy(xpath="//img[@title='MacBook']")
	WebElement click_Product;
	
	@FindBy(xpath="//span[normalize-space()='Add to Cart']")
	WebElement click_AddToCart;
	
	
	@FindBy(xpath="//span[@id='cart-total']//i[@class='fa fa-shopping-cart']")
	WebElement click_Cart_Total;

	//td[@class='text-left']//a[contains(text(),'iMac')]
	@FindBy(xpath="//td[@class='text-left']//a")
	WebElement click_productName;
	
	//img[@title='Apple Cinema 30"']
	@FindBy(xpath="//img[@title='Apple Cinema 30\"']")
	WebElement click_AppleCinema_img;
	
	
	
	
	public int noOfSearchItemsDisplayed()
	{
		int count = search_Items.size();
		return count;
	}

	public String listOfItemsDisplayed()
	{
		try
		{
			for(WebElement s : search_Items)
			{
				return s.getText();
			} 
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		return null;
	}


	public boolean selectDropdown()
	{
		boolean select_Drp = false;
		for(WebElement s : drpdown)
		{
			if(s.getText().equals("75"))
			{
				s.click();
				select_Drp=true;
				break;
			}
		}
		return select_Drp;
	}
	public void  clickProductDisplayed()
	{
		for(WebElement si : search_Items)
		{
			if(si.getText().equals("MacBook"))
			{
				si.click();
				break;
			}
		}

	}
	
	public void click_ProductToCompare()
	{
		click_Product.click();
	}
	
	public void click_Add_To_Cart()
	{
		click_AddToCart.click();
	}
	public void click_Cart_Total()
	{
		click_Cart_Total.click();
	}
	public void click_ProductName()
	{
		click_productName.click();
	}

	public void click_Product_AppleCinema_Img()
	{
		click_AppleCinema_img.click();
	}
}





