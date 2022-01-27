package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; //Log4j Logging
	public ResourceBundle rb; //to read config.properties

	@BeforeClass(groups= {"sanity","regression","master"}) 
	@Parameters({"browser"})

	public void setup(String br)
	{

		//Load config.properties
		rb= ResourceBundle.getBundle("config"); 

		//Log4j Logging
		logger = LogManager.getLogger(this.getClass());

		//Drivers
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			logger.info("Launched Chrome Browser");
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			logger.info("Launched Edge Browser");

		}
		else if(br.equals("firefox"))
		{	
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			logger.info("Launched Firefox Browser");

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}


	public String randomestring() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public int randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (Integer.parseInt(generatedString2));
	}

	public static String getScreenshot1() throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);


		String destination = System.getProperty("user.dir") + "/screenshots/" + dateName + ".png";
		File finalDestination = new File(destination);

		FileHandler.copy(source, finalDestination);
		return destination;
	}




}
