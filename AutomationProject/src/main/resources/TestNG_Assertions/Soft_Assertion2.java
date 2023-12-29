package TestNG_Assertions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestNG.BaseClass_CommonClass;

public class Soft_Assertion2 extends BaseClass_CommonClass{
			
		@BeforeSuite
		public void launchBrowser() {
			
			BrowserLaunching("chrome");
			
			System.out.println("in @BeforeSuite method");
		}
		
		@BeforeClass
		public void launchURL() throws IOException {
			
			urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			takeScreenshot("url loading");
			
			System.out.println("in @BeforeClass method");

		}
		
		@BeforeMethod
		public void wait1() {
			
			waitForAnApplication();
			
			System.out.println("in @@BeforeMethod method");
			
		}
		
		@Test(priority = 0)
		public void verifyTitle() {
			
			SoftAssert testing = new SoftAssert();
			
			String actualTitle = "Priyanka";
			
			String expectedTitle = driver.getTitle();
			
			testing.assertEquals(actualTitle, expectedTitle);
			
			System.out.println("Hi Testing team");
			
			System.out.println("Hi Testing team1");
			
			testing.assertAll();			
		}
		
		@Test(priority = 1)
		public void enterUsername() throws IOException {
			
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
			
			takeScreenshot("after entering the username");
			
			System.out.println("in @Test enterUsername method");
		}
		

		@Test(priority = 2)
		public void enterPassword() throws IOException {
			
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
			
			takeScreenshot("after entering the password");
			
			System.out.println("in @Test enterPassword method");
		}
		

		@Test(priority = 3)
		public void clickLogin() {
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			System.out.println("in @Test enterUsername method");
		}
		
		@AfterMethod
		public void wait2() {
			
			waitForAnApplication();

			System.out.println("in @AfterMethod method");
		}
		
		@AfterSuite
		public void closeBroswer() throws IOException {
			
			takeScreenshot("Homepage");
			
			browserClosing();
						
			System.out.println("in @AfterSuite method");

		}	


}
