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

public class EighthDemo {
	WebDriver driver;
	String url = "https://demo.guru99.com/test/upload/";
	
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
//		Thread.sleep(2000);
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		uploadElement.sendKeys("D:\\Selenium\\Demo_06.txt");
		Thread.sleep(2000);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.name("send")).click();
		Thread.sleep(3000);
		String result = driver.findElement(By.xpath("//*[@id=\"res\"]")).getText();
//		Thread.sleep(3000);
		System.out.println(result);
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
	}
	
}
