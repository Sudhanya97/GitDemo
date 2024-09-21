package newpackage;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class NinthDemo {
	WebDriver driver;
	String url = "https://demo.guru99.com/test/newtours/register.php";
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void runMethod() throws InterruptedException {
		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("AZERBAIJAN");
		Thread.sleep(2000);
		drpCountry.selectByIndex(7);
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
	}
	
}
