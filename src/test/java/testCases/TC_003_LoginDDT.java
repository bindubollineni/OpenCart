package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void TC_003_LoginDDT(String email, String pwd, String exp)
	{
		logger.info("Starting TC_003_LoginDDT");

		try 
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home PageDisplayed");

			driver.manage().window().maximize();


			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked My account link");

			hp.clickLogin();
			logger.info("Clicking login link");

			LoginPage lp = new LoginPage(driver);

			lp.setEmailId(rb.getString(email));
			logger.info("provide email");

			lp.setPwd(rb.getString(pwd));
			logger.info("provided password");

			lp.click_LoginBtn();
			logger.info("clicked login button");

			boolean targetpage=lp.validateLogin();
			if(exp.equals("Valid"))
			{
				if(targetpage==true)
				{
					logger.info("Login success");
					MyAccountPage ap = new MyAccountPage(driver);
					ap.clickLogout();
					logger.info("Clicked Logout");
					Assert.assertTrue(true);
				}
				else
				{
					logger.info("Login Failed");
					Assert.assertTrue(false);
				}
			}

			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
					MyAccountPage ap = new MyAccountPage(driver);
					ap.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					logger.info("Login Failed");
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed");
		}
		logger.info("Finished TC_003_LoginDDT");
	}

		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException
		{
			String path="./testData/test_data_MyAccount.xlsx";

			XLUtility xlutil=new XLUtility(path);

			int totalrows=xlutil.getRowCount("Sheet1");	
			int totalcols=xlutil.getCellCount("Sheet1",1);

			String logindata[][]=new String[totalrows][totalcols];

			for(int i=1;i<=totalrows;i++)  //1
			{		
				for(int j=0;j<totalcols;j++)  //0
				{
					logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
				}
			}
			return logindata;

		}


	}
