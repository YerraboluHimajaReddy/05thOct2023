package Common;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass_CommonClass {
	
	public WebDriver driver;
	
	public void BrowserLaunching(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		
	}
	
	public void urlLaunching(String url) {
		
		driver.get(url);
	}
	
	public void browserClosing() {
		
		driver.quit();
	}
	
	public void waitForAnApplication() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
	}

	public void takeScreenshot(String screenShot) throws IOException {
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshot, new File("C:\\Users\\himaj\\eclipse-workspace\\05thOct2023Batch\\AutomationProject\\src\\test\\java\\Screenshots\\"+screenShot+".png"));
	}
}
