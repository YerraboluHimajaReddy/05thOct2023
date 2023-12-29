package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOut {

	public WebDriver driver;

	public SignOut(WebDriver driver) {

		this.driver = driver;
	}

	// 2nd way
	
	@FindBy(xpath = "//*[text()='About']")
	public WebElement about_Button;
	
	@FindBy(xpath = "//*[text()='Support']")
	public WebElement support_Button;
	
	@FindBy(xpath = "//*[text()='Change Password']")
	public WebElement changePassword_Button;
	
	@FindBy(xpath = "//*[text()='Logout']")
	public WebElement logout_Button;

	public void clickLogout() {

		logout_Button.click();
	}

	public void clickAbout() {

		about_Button.click();
	}

	public void clickChangePassword() {

		changePassword_Button.click();
	}

	public void clickSupport() {

		support_Button.click();
	}

}
