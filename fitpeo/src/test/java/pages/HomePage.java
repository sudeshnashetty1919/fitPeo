package pages;

import java.awt.RenderingHints.Key;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
WebDriver driver;
	
	@FindBy(xpath="//img[contains(@src,'brand-website')]//..//div[6]//a")
	WebElement revenueCalculator;
	
	@FindBy(xpath="(//img[contains(@src,'brand-website')]//..//h4)[2]")
	WebElement revenuePageHeading;
	
	@FindBy(xpath="//span[contains(@class,'MuiSlider-thumb')]")
	WebElement slider;
	
	@FindBy(xpath="//span[contains(@class,'MuiSlider-track')]//following-sibling::span//input")
	WebElement multiSliderTrack;
	
	////span[contains(@class,'MuiSlider-rail')]//..//..//input[@type='range']
	@FindBy(xpath="//span[contains(@class,'MuiSlider-rail')]//..//..//input[@type='number']")
	WebElement inputSliderValue;

	@FindBy(xpath="(//div[@class='MuiBox-root css-4o8pys'])[1]/label/span[contains(@class,'MuiButtonBase-root')]")
	WebElement CPT_99091;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-4o8pys'])[2]/label/span[contains(@class,'MuiButtonBase-root')]")
	WebElement CPT_99453;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-4o8pys'])[3]/label/span[contains(@class,'MuiButtonBase-root')]")
	WebElement CPT_99454;
	
	@FindBy(xpath="(//div[@class='MuiBox-root css-4o8pys'])[8]/label/span[contains(@class,'MuiButtonBase-root')]")
	WebElement CPT_99474;
	
	@FindBy(xpath="(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4]")
	WebElement totalRecurringReimbursement;
	
	
	public HomePage(WebDriver driver) {
		 
		 this.driver = driver;  
		 
		 PageFactory.initElements(driver, this); 
	 }
	
	
	public void navigateToRevenueCalculator() throws InterruptedException {
		
		revenueCalculator.click();
		
		Thread.sleep(1000);
	}
	
	public String validateRevenueCalculatorPage() {
		
		System.out.println(revenuePageHeading.getText());
		
		return revenuePageHeading.getText();
		
	}
	public void setSlider() {
	
		Actions actions = new Actions(driver);
		
		actions.moveToElement(inputSliderValue);
		
		actions.dragAndDropBy(slider, 93, 0).perform();
		
		for(int i=0;i<3;i++) {
			
			multiSliderTrack.sendKeys(Keys.ARROW_RIGHT);
		}
		
	}
	
	public String getSliderValueFromTextBox() {
		
		String valueOfSlider = inputSliderValue.getAttribute("value");
		
		return valueOfSlider;
	}
	
	public void clearTextBoxForSlider() {
		
		inputSliderValue.sendKeys(Keys.CONTROL + "a");
		
		inputSliderValue.sendKeys(Keys.DELETE);
		
	}

	public void setSliderFromTextBox(String value) {
				
		inputSliderValue.sendKeys(value);
	}
	
	public String isSliderUpdated() {
		
		return multiSliderTrack.getAttribute("aria-valuenow");
	}
	
	public boolean isCPT_99091Selected() {
		
		
		boolean selected = CPT_99091.getAttribute("class").contains("Mui-checked");
		
		return selected;
	}
	
	public boolean isCPT_99453Selected() {
		
		
		boolean selected = CPT_99453.getAttribute("class").contains("Mui-checked");
		
		return selected;
	}
	
	public boolean isCPT_99454Selected() {
		
		
		boolean selected = CPT_99454.getAttribute("class").contains("Mui-checked");
		
		return selected;
	}
	
	public boolean isCPT_99474Selected() {
		
		
		boolean selected = CPT_99474.getAttribute("class").contains("Mui-checked");
		
		return selected;
	}
	
	
	public void selectCPT_99091() {
		
		CPT_99091.click();
	}
	
	public void selectCPT_99453() {
		
		CPT_99453.click();
	}
	
	public void selectCPT_99454() {
		
		CPT_99454.click();
	}
	
	public void selectCPT_99474() {
		
		CPT_99474.click();
	}
	
	public String getTotalRecurringReimbursement() {
		
		String Reimbursement = totalRecurringReimbursement.getText();
		
		return Reimbursement;
	}
	
	
	
}
