package script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;

public class HomeScript extends BasePage {
	
	
	@Test(priority = 0)
	public void revenueCalculatorPage() throws InterruptedException {
		
		
		HomePage hP = new HomePage(driver);
		
		hP.navigateToRevenueCalculator();
		
		String expected ="How Many Medicare Patients Would ";
		
		String actual = hP.validateRevenueCalculatorPage();
		
		Assert.assertTrue(actual.contains(expected));
		
	}
	
	@Test(priority = 1)
	public void dragSlider() throws InterruptedException {
		
		HomePage hP = new HomePage(driver);
		
		hP.navigateToRevenueCalculator();
		
		hP.setSlider();
		
		String actual =hP.getSliderValueFromTextBox();
		
		String expected = "820";
		
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 2)
	public void giveSliderInput() throws InterruptedException {
		
		HomePage hP = new HomePage(driver);
		
		hP.navigateToRevenueCalculator();
		
		hP.clearTextBoxForSlider();
		
		hP.setSliderFromTextBox("560");
		
		String actualValue= hP.isSliderUpdated();
		
		String expectedValue = "560";
		
		Assert.assertEquals(actualValue, expectedValue);
		
	}
	
	@Test(priority = 3)
	public void claculateTotalRecurringReimbursement() throws InterruptedException {
		
		HomePage hP = new HomePage(driver);
		
		hP.navigateToRevenueCalculator();
		
		hP.clearTextBoxForSlider();
		
		hP.setSliderFromTextBox("820");
		
		hP.selectCPT_99091();
		
		Assert.assertTrue(hP.isCPT_99091Selected());
		
		hP.selectCPT_99453();
		
		Assert.assertTrue(hP.isCPT_99453Selected());
		
		hP.selectCPT_99454();
		
		Assert.assertTrue(hP.isCPT_99454Selected());
		
		hP.selectCPT_99474();
		
		Assert.assertTrue(hP.isCPT_99474Selected());
		
		String actualTotalReimbursement = hP.getTotalRecurringReimbursement();
		
		String expectedTotalReimbursement = "$110700";
		
		if(actualTotalReimbursement.equals(expectedTotalReimbursement)) {
			
			System.out.println("total reimbursement is calculated correctly");
		}else {
			System.out.println("total reimbursement is not calculated correctly");
		}
		
		
	}
	
	
	
	

}
