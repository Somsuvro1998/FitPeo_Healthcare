package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	//Constructor to initialize the WebElements
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[text()='Revenue Calculator']")
	private WebElement revenueCalculatorLink;
	
	//getter method
	public WebElement getRevenueCalculatorLink()
	{
		return revenueCalculatorLink;
	}
	//Business logic
	public void clickRevenueCalculatorLink()
	{
		revenueCalculatorLink.click();
	}
}
