package TestNG_Attributes;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestNG.BaseClass_CommonClass;

public class Attribute_DataProvider extends BaseClass_CommonClass {
		
	@BeforeSuite
	public void launchBrowser() {
		
		BrowserLaunching("edge");
		
		System.out.println("in @BeforeSuite method");
	}
	
	@BeforeClass
	public void launchURL() {
		
		urlLaunching("https://www.facebook.com/");
		
		System.out.println("in @BeforeClass method");

	}
	
	@BeforeMethod
	public void wait1() {
		
		waitForAnApplication();
		
		System.out.println("in @@BeforeMethod method");
		
	}
	
	@DataProvider(name = "user credentails")
	public Object[][] verifyFacebook(){
		
		Object[][] values = new Object[2][2];
		
		values[0][0] ="Jahnavi@test.com";
		values[0][1]= "Jahnavi123";
		
		values[1][0] ="Murali@test.com";
		values[1][1]= "Murali123";
		
		return values;
	}
	
	@Test(dataProvider = "user credentails")
	public void enterCredentials(String username, String password) {
		
		//driver.findElement(By.xpath("//input[@name='email']")).clear();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		
		//driver.findElement(By.xpath("//input[@name='pass']")).clear();
		
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
		
		System.out.println("in @Test enterUsername method");
	}
	
	@AfterMethod
	public void wait2() {
		
		waitForAnApplication();

		System.out.println("in @AfterMethod method");
	}
	
	@AfterSuite
	public void closeBroswer() {
		
		browserClosing();

		System.out.println("in @AfterSuite method");

	}	

}
