package Tests;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignOut;


public class LoginTest extends Common.BaseClass_CommonClass {
	
	LoginPage lp;
	
	HomePage hp;
	
	SignOut sp;
		
	@BeforeSuite
	public void launchBrowser() {
		
		BrowserLaunching("chrome");
		
		lp= new LoginPage(driver);
		
		//Syntax: parentclass objectname = pagefactory.initElements(parentclass.class, driver);
		
		hp = PageFactory.initElements(driver, HomePage.class);
		
		sp = PageFactory.initElements(driver, SignOut.class);
		
		System.out.println("in @BeforeSuite method");
	}
	
	@BeforeClass
	public void launchURL() {
		
		urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
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
	
	@Test(priority = 4)
	public void clickTest61Button() {
		
		hp.clickTest61();
		
		System.out.println("in @Test clickTest61Button method");
	}
	
	@Test(priority = 5)
	public void clickLogoutButton() {
		
		sp.clickLogout();
		
		System.out.println("in @Test clickLogoutButton method");
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
