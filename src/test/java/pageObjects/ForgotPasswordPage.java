package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	WebDriver driver;

	//Constructor
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Locators
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email_Fp;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_Continue;

	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement validate_ResetPwdTxt;


	//Action methods on locators

	public void setForgotPwdEmail(String fpwd)
	{
		email_Fp.sendKeys(fpwd);
	}

	public void clickContinueBtn()
	{
		btn_Continue.click();
	}

	public String validateResetPwdMsg()
	{
		try
		{
			String valid_txt_Fp = validate_ResetPwdTxt.getText();
			System.out.println(valid_txt_Fp);
			return valid_txt_Fp;
		} catch(Exception e)
		{
			return e.getMessage();
		}
	}

}
