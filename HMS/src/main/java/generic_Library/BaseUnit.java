package generic_Library;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import generic_Library.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUnit {
	public WebDriver driver;
	public WebDriverWait explicitWait;
	@Parameters("browsername")
	@BeforeMethod(groups = "launch")
	public void launchBrowser(@Optional("chrome") String bname) {
		String url=ReadData.fromProperty("Url");
		// Launching empty browser and maximize the window
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
			Reporter.log("pass the valid data",true);
		Reporter.log("Empty browser is launched",true);
		driver.manage().window().maximize();
		Reporter.log("browser is maximized",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		explicitWait=new WebDriverWait(driver, Duration.ofSeconds(10));

		//navigate to the application
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(),url,"Home page is not displayed");

	}

	@AfterMethod()
	public void logoutAndCloseTheBrowser()
	{
		driver.quit();
	}

}
