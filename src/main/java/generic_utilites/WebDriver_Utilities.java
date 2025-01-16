package generic_utilites;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utilities {
	public WebDriver driver;
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void scrollIntoView(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	public void sliderAdjustment(WebDriver driver, WebElement ele, int xOffSet, int yOffSet)
	{
		Actions act=new Actions(driver);
		act.dragAndDropBy(ele, xOffSet, yOffSet).build().perform();
	}
	public static String takesScreenshot(WebDriver driver, String screenshotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+screenshotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

}
