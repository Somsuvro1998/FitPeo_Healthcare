package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RevenueCalculatorPage {

	//Constructor to initialize the WebElements
	public RevenueCalculatorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//WebElements	
	@FindBy(xpath="//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']")
	private WebElement revenueCalculatorSlider;
	
	@FindBy(xpath="//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']")
	private WebElement revenueTextfield;
	
	@FindBy(xpath="//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']/input")
	private WebElement sliderValue;
	
	@FindBy(xpath="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")
	private WebElement CPT_99091_Checkbox;
	
	@FindBy(xpath="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]")
	private WebElement CPT_99453_Checkbox;
	
	@FindBy(xpath="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]")
	private WebElement CPT_99454_Checkbox;
	
	@FindBy(xpath="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]")
	private WebElement CPT_99474_Checkbox;
	
	@FindBy(xpath="(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]")
	private WebElement totalRecurringRembursment;
	
	@FindBy(xpath="//h4[text()='Medicare Eligible Patients']")
	private WebElement text;
	
	//Getter Methods
	public WebElement getMedicareText()
	{
		return text;
	}
	public WebElement getrevenueCalculatorSlider()
	{
	return revenueCalculatorSlider;	
	}
	public WebElement getsliderValue()
	{
		return sliderValue;
	}
	public WebElement getrevenueTextfield()
	{
		return revenueTextfield;
	}
	public WebElement getCPT_99091_Checkbox()
	{
		return CPT_99091_Checkbox;
	}
	public WebElement getCPT_99453_Checkbox()
	{
	return CPT_99453_Checkbox;	
	}
	public WebElement getCPT_99454_Checkbox()
	{
		return CPT_99454_Checkbox;
	}
	public WebElement getCPT_99474_Checkbox()
	{
		return CPT_99474_Checkbox;
	}
	public WebElement gettotalRecurringRembursment()
	{
		return totalRecurringRembursment;
	}
	//Business logic
	public void clearTextField()
	{
		revenueTextfield.clear();
	}
	public void selectCPT_99091_Checkbox()
	{
		CPT_99091_Checkbox.click();
	}
	public void selectCPT_99453_Checkbox()
	{
		CPT_99453_Checkbox.click();
	}
	public void selectCPT_99454_Checkbox()
	{
		CPT_99454_Checkbox.click();
	}
	public void selectCPT_99474_Checkbox()
	{
		CPT_99474_Checkbox.click();
	}
	public void checkSliderValue(String textValue, String sliderValue)
	{
		//actValue=sliderValue.getAttribute("value");
		if(textValue==sliderValue)
		{
			System.out.println("Slider is at correct position");
		}
		else
		{
			System.out.println("Slider is not at correct position");
		}
	}
	public void verifytotalRecurringRembursment(String expvalue)
	{
		if(totalRecurringRembursment.getText().equalsIgnoreCase(expvalue))
		{
			System.out.println("The total Recurring Rembursment for all the patients is "+expvalue);
		}
		else
		{
			System.out.println("The total Recurring Rembursment for all the patients is not "+expvalue);
		}
	}

	
}
