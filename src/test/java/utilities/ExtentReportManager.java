package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//Extent report 5.x

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager extends BaseClass implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;
	WebDriver driver;

	public void onStart(ITestContext testContext)
	{		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		repName="Test-Report-"+timeStamp+".html";

		sparkReporter=new ExtentSparkReporter("./reports/"+repName);//specify location of the report

		sparkReporter.config().setDocumentTitle("nopCommerce Automation Report"); // Title of report
		sparkReporter.config().setReportName("nopCommerce  Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "nopCommerce");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","bindu");
	}


	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName()); 
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());

		InputStream in = null;
		try {
			in = new FileInputStream(getScreenshot1());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		byte[] imageBytes = null;
		try {
			imageBytes = IOUtils.toByteArray(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String base64 = Base64.getEncoder().encodeToString(imageBytes);

		test.log(Status.PASS,"Attached Screenshot ", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+base64).build());
		



	}

	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName()); //test=extent.createTest(result.getTestContext().getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();

		/* try {
		URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);

		 // Create the email message
		 ImageHtmlEmail email = new ImageHtmlEmail();
		  email.setDataSourceResolver(new DataSourceUrlResolver(url));
		  email.setHostName("smtp.googlemail.com");
		  email.setSmtpPort(465);
		  email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com", "password"));
		  email.setSSLOnConnect(true);
		  email.setFrom("pavanoltraining@gmail.com");   //Sender
		  email.setSubject("Test Results");
		  email.setMsg("Please find Attached Report....");
		  email.addTo("pavankumar.busyqa@gmail.com");   //Receiver
		  email.attach(url, "extent report", "please check report...");
		  email.send();   // send the email
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
	}


}
