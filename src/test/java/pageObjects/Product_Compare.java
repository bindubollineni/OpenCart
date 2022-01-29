package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Compare {


	WebDriver driver;
	public Product_Compare (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='product comparison']")
	WebElement link_ProductComparision;

	public boolean click_ProductComparisionlink()
	{
		boolean status = false;
		try
		{
			status =link_ProductComparision.isDisplayed();
			return status;

		} catch(Exception e)
		{
			e.getMessage();
		}
		return status;
	}

}
