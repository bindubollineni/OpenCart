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
	
	@FindBy(xpath="//img[@title='iMac']")
	WebElement iMac_product;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[1]/ul[1]/li[1]/a/img")
	WebElement iMac_img;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[1]/ul[1]/li[2]/a/img")
	WebElement iMac_img1;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[1]/ul[1]/li[3]/a/img")
	WebElement iMac_img2;
	
	@FindBy(xpath="//button[@title='Previous (Left arrow key)']")
	WebElement left_Arrow;
	
	@FindBy(xpath="//button[@title='Next (Right arrow key)']")
	WebElement right_Arrow;
	
	@FindBy(xpath="//button[@title='Close (Esc)']")
	WebElement close_img;
	

	@FindBy(xpath="//h1[normalize-space()='iMac']")
	WebElement product_Name;
	
	@FindBy(xpath="//a[normalize-space()='Apple']")
	WebElement product_Brand;
	
	@FindBy(xpath="//*[@id=\\\"content\\\"]/div[1]/div[2]/ul[1]/li[2]")
	WebElement product_Id;

	@FindBy(xpath="//*[@id=\\\"content\\\"]/div[1]/div[2]/ul[1]/li[3]")
	WebElement availability;
	
	@FindBy(xpath="//*[@id=\\\"content\\\"]/div[1]/div[2]/ul[1]/li[3]")
	WebElement product_Price;
	
	@FindBy(xpath="//*[@id=\\\"content\\\"]/div[1]/div[2]/ul[2]/li[2]")
	WebElement exp_Tax;

	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btn_addToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement txt_success;
	
	@FindBy(xpath="//a[text()='Description']")
	WebElement tab_Description;
	
	@FindBy(xpath="//a[text()='Reviews (0)']")
	WebElement tab_Review;

	@FindBy(xpath="//input[@id='input-name']")
	WebElement review_Name;

	@FindBy(xpath="//textarea[@id='input-review']")
	WebElement txt_Review;

	@FindBy(xpath="//input[@value='5']")
	WebElement radio_Rating;

	@FindBy(xpath="//button[@id='button-review']")
	WebElement btn_submit;
	
	@FindBy(xpath="//a[normalize-space()='Your Store']")
	WebElement page_Heading;
	

	
	public void click_ProductToCompare()
	{
		click_Product.click();
	}
	
	public void clickCompareProduct()
	{
		compare_prduct.click();
	}
	
	public void clickiMac_product()
	{
		iMac_product.click();
	}
	
	public void clickiMac_img()
	{
		iMac_img.click();
	}
	
	public void clickLeftArrow()
	{
		left_Arrow.click();
	}
	
	public void clickRightArrow()
	{
		right_Arrow.click();
	}
	
	public void clickClose()
	{
		close_img.click();
	}
	public void clickiMac_img1()
	{
		iMac_img1.click();
	}
	public void clickiMac_img2()
	{
		iMac_img2.click();
	}
	
	public String validate_ProductName()
	{
		return product_Name.getText();
	}
	
	public String validate_ProductBrand()
	{
	return	product_Brand.getText();
	}
	
	public String validate_ProductId()
	{
	return	product_Id.getText();
	}
	
	public String validate_Availability()
	{
		return availability.getText();
	}
	
	public String  validate_Price()
	{
		return product_Price.getText();
	}
	public String validate_ExpTax()
	{
		return exp_Tax.getText();
	}

	public void set_Quantity(String qt)
	{
		quantity.clear();
		quantity.sendKeys(qt);
	}
	

	public void click_AddToCart()
	{
		btn_addToCart.click();
	}
	
	public String validate_TxtAddToCart()
	{
		return txt_success.getText();
	}
	
	public void click_DiscriptionTab()
	{
		tab_Description.click();
	}
	
	public void click_ReviewTab()
	{
		tab_Review.click();
	}
	
	public void set_ReviewName(String rName)
	{
		review_Name.sendKeys(rName);;
	}

	public void set_YourReview(String review)
	{
		txt_Review.sendKeys(review);;
	}
	
	public void click_RadioReview()
	{
		radio_Rating.click();
	}
	
	public void click_Review_Continue()
	{
		btn_submit.click();
	}
	public String get_PageHeading()
	{
		return page_Heading.getText();
	}
	
	public String  get_PageTitle()
	{
		return driver.getTitle();
	}
	
	public String  get_PageURL()
	{
		return driver.getCurrentUrl();
	}
	
	

}
