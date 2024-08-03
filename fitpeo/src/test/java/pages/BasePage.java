package pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BasePage {
	
	
		public static WebDriver driver;
		
		@SuppressWarnings("deprecation")
		@BeforeMethod
	    public void initializeWebDriver() throws IOException {
			
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe");
			
			driver = new ChromeDriver(); 
	       
			driver.manage().window().maximize();  
	    
	        // Implicit wait  
	        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        
	        driver.get("https://www.fitpeo.com/"); 
		
		}
		
		@AfterMethod
		public static void tearDown() {
			
			driver.quit();
		}
		 

}
