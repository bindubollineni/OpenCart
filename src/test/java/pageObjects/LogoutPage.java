package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//locators
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement valid_title;

	public String validate_LogoutTitle()
	{
		try
		{
			String title_logout = valid_title.getText();
			return title_logout;
		} catch(Exception e)
		{
			return e.getMessage();
		}
	}



}
