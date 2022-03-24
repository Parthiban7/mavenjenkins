package mavenforjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UITests {
	@Parameters("Browsers")
	@Test
	public void startBrowser(String browserName) {
		WebDriver driver = null;
		System.out.println("Paramter Value is " + browserName);
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Assert.assertTrue(driver.getTitle().contains("Orange"),"Title does not match");
		driver.quit();
	}
}
