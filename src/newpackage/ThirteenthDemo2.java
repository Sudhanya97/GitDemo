package newpackage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ThirteenthDemo2 {
	WebDriver driver;
	String url = "https://demo.guru99.com/test/social-icon.html";
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void runMethod() throws InterruptedException, ParseException {
		String expectedTooltip = "Github";
		WebElement github = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/a[4]"));
		String actualTooltip = github.getAttribute("title");
		if(actualTooltip.equals(expectedTooltip))
			System.out.println("Test Case Passed");
		Thread.sleep(3000);
		driver.get("https://demo.guru99.com/test/tooltip.html");
		expectedTooltip = "What's new in 3.2";
		WebElement download = driver.findElement(By.xpath("//*[@id=\"download_now\"]"));
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(download).build().perform();
		WebElement toolTipElement = driver.findElement(By.xpath(".//*[@class='box']/div/a"));
		actualTooltip = toolTipElement.getText();
		if(actualTooltip.equals(expectedTooltip))
			System.out.println("Test Case Passed");
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
	}
	
}
