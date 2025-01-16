package test_scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_utilites.Baseclass_FitPeo_Healthcare;
import pom.Homepage;
import pom.RevenueCalculatorPage;
@Listeners(generic_utilites.Extent_Utilities.class)
public class TestClass1_test extends Baseclass_FitPeo_Healthcare {
	@Test
	public void tc_01_test() throws Throwable
	{
		Homepage hp=new Homepage(driver);
		hp.clickRevenueCalculatorLink();
		RevenueCalculatorPage rp=new RevenueCalculatorPage(driver);
		WebElement mText = rp.getMedicareText();
		WebElement slider = rp.getrevenueCalculatorSlider();
		wlib.scrollIntoView(driver, mText);
		Thread.sleep(5000);
		wlib.sliderAdjustment(driver, slider,95, 0);
		Thread.sleep(5000);
		WebElement textField = rp.getrevenueTextfield();
		textField.click();
		Thread.sleep(5000);
		String newValue = elib.getDataFormatterData("Sheet1", 0, 2);
		String value = textField.getAttribute("value");
		if(value!=null)
		{
			int valueLen = value.length();
			for(int i=0;i<valueLen;i++)
			{
				textField.sendKeys(Keys.BACK_SPACE);
			}
		}
		textField.sendKeys(newValue);
		WebElement sliderValue = rp.getsliderValue();
		String actValue = sliderValue.getAttribute("value");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actValue, newValue);
		Thread.sleep(5000);
		rp.selectCPT_99091_Checkbox();
		rp.selectCPT_99453_Checkbox();
		rp.selectCPT_99454_Checkbox();
		rp.selectCPT_99474_Checkbox();
		String expRembursment = elib.getDataFormatterData("Sheet1", 0, 3);
		Thread.sleep(5000);
		System.out.println("------------------------------------------------------------");
		rp.verifytotalRecurringRembursment(expRembursment);
		System.out.println("------------------------------------------------------------");
	    Thread.sleep(5000);
		sa.assertAll();
	}

}
