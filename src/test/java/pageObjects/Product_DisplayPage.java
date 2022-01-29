package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_DisplayPage {
	
	WebDriver driver;
	
	//Constructor
	
	public Product_DisplayPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	
	//Locators
	
	@FindBy(xpath="//img[@title='MacBook']")
	WebElement click_Product;
	@FindBy(xpath="//button[@class='btn btn-default'][@data-original-title='Compare this Product']")
	WebElement compare_prduct;
	
	public void click_ProductToCompare()
	{
		click_Product.click();
	}
	
	public void clickCompareProduct()
	{
		compare_prduct.click();
	}

}
