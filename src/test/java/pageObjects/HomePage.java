 package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	
public  HomePage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}


@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement link_MyAccount;
@FindBy(xpath="//a[normalize-space()='Register']")
WebElement link_Register;
@FindBy(xpath="//a[normalize-space()='Login']")
WebElement link_Login;

public void clickMyAccount()
{
	link_MyAccount.click();
}
public void clickRegister()
{
	link_Register.click();
}
public void clickLogin()
{
	link_Login.click();
}

}
