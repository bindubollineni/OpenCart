package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DesktopPage {

	WebDriver driver;
	
	public DesktopPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-th-list']")
	WebElement btn_listview;
	
	@FindBy (xpath="//img[@title='Apple Cinema 30\"']")
	WebElement img_product;
	
	public void click_Listview()
	{
		btn_listview.click();
	}
	
	public void click_Product()
	{
		img_product.click();
	}
}
