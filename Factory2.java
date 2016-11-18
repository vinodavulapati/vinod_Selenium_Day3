package work_day3;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Factory2 {

	private static WebDriver driver = null;
	private static final String FBurl = "https://www.facebook.com/";
	private static final String Amazonurl = "www.amazon.com";
	private static final String Expedia = "https://www.expedia.com/";
	private static final String DHX = "https://dhtmlx.com/";

	@BeforeClass
	public void initializeWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C://Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Expedia);
	}
	
	public static void setDriver(WebDriver driver) {
		Factory2.driver = driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
			}
	}

}
