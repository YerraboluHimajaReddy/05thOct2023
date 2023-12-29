package ExtentReports;


import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestNG.BaseClass_CommonClass;


public class ExtentReportExample extends BaseClass_CommonClass{	

	public static ExtentReports report;

	public static ExtentTest test;

	@BeforeSuite
	public void startTest() {

		report = new ExtentReports(System.getProperty("user.dir") + "\\LiveTech.html");

		test = report.startTest("Evening Batch");
		
	}	

	@BeforeTest
	public void launchBrowser() {

		BrowserLaunching("Chrome");
		
		System.out.println("i am in @BeforeSuite method");
	}
	
	@BeforeClass
	public void launcURL() {

		urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println("i am in @BeforeClass method");
		
		waitForAnApplication();
	}
	
	@Test(priority = 1)
	public void loginToOrangeHRM() {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("OrangeHRM")) {

			test.log(LogStatus.PASS, "Title is same");

		} else {

			test.log(LogStatus.FAIL, "Title is not same");
		}

	}

//	@Test(priority = 2)
//	public void clickLogout() {
//		
//		System.out.println(driver.getTitle());
//
//		String expected = "Testing";
//
//		String actual = driver.getTitle();
//
//		if (actual.equalsIgnoreCase(expected)) {
//
//			test.log(LogStatus.PASS, "Title is same : " + actual);
//
//		} else {
//
//			test.log(LogStatus.FAIL, "Title is not same " + expected + " and " + actual);
//
//		}
//	}

	@AfterClass
	public void endTest() {

		report.endTest(test);

		report.flush();
	}

	@AfterSuite
	public void closeBrowser() {

		browserClosing();
	}

}
