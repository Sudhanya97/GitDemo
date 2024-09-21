package newpackage;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpDemo {
	WebDriver driver;
	String url = "https://www.makemytrip.com/";
	
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
//		WebElement element = driver.findElement(By.xpath("//*[@class='makeFlex hrtlCenter']//ul//li[2]"));
//		element.click();
//		Thread.sleep(3000);
		driver.get("https://demo.guru99.com/");
		WebElement element = driver.findElement(By.xpath("//*[@name()='emailid']"));
		element.sendKeys("abc@gmail.com");
		Thread.sleep(3000);
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
	}
	
}
