package newpackage;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FourthDemo {
	WebDriver driver;
	String url = "http://output.jsbin.com/usidix/1";
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void runMethod() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html/body/input")).click();
		Thread.sleep(4000);
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(alertMessage);
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
	}
	
}
