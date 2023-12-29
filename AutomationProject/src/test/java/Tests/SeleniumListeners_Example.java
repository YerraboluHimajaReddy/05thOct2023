package Tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Common.SeleniumListeners;
import Pages.LoginPage;


public class SeleniumListeners_Example extends Common.BaseClass_CommonClass {
	
	LoginPage lp;
	
	SeleniumListeners sl;
		
	@BeforeSuite
	public void launchBrowser() {
		
		BrowserLaunching("chrome");
		
		lp= new LoginPage(driver);
		
		sl = new SeleniumListeners();
		
		System.out.println("in @BeforeSuite method");
	}
	
	@BeforeClass
	public void launchURL() {
		
		sl.beforeNavigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", driver);
		
		urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		sl.afterNavigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", driver);
		
		System.out.println("in @BeforeClass method");

	}
	
	@BeforeMethod
	public void wait1() {
		
		waitForAnApplication();
		
		System.out.println("in @@BeforeMethod method");
		
	}
	
	@Test(priority = 1)
	public void enterUsername() {
		
		lp.enterUsername();
		
		System.out.println("in @Test enterUsername method");
	}
	

	@Test(priority = 2)
	public void enterPassword() {
		
		lp.enterPassword();
		
		System.out.println("in @Test enterPassword method");
	}
	

	@Test(priority = 3)
	public void clickLogin() {
		
		lp.clickLogin();
		
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
