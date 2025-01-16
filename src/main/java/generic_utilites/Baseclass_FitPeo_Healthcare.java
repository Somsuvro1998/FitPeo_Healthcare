package generic_utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass_FitPeo_Healthcare {
	
	public WebDriver driver;
	public static WebDriver screenshotdriver;
	public Excel_Utilitis elib=new Excel_Utilitis();
	public WebDriver_Utilities wlib=new WebDriver_Utilities();
	
	@BeforeSuite
	public void beforeSuite()
	{
	System.out.println("Establishing database connection");	
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Starting Parallel Connection");
	}
	@BeforeClass
	public void beforeClass() throws Throwable
	{
		System.out.println("Launching browser");
		String browser = elib.getDataFormatterData("Sheet1", 0, 0);
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		wlib.maximizeWindow(driver);
		screenshotdriver=driver;
	}
	@BeforeMethod
	public void beforeMethod() throws Throwable
	{
	System.out.println("Launching url");	
	System.out.println("Test script execution start");
	String url = elib.getDataFormatterData("Sheet1", 0, 1);
	driver.get(url);
	wlib.implicitWait(driver);
	
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Test script execution ends");
		driver.close();
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("Closing browser");
		driver.quit();
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("Closing Parallel Test");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Closing Database Connection");
	}
}
