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


}



