package newpackage;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstDemo {
	WebDriver driver;
	String url = "http://demo.guru99.com/test/newtours";
	
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
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("SYSTEM PASSED");
		} else {
			System.out.println("SYSTEM FAILED");
		}
//		System.out.println(actualTitle);
//		Thread.sleep(2000);
		System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
		System.out.println("All the changes are done for Git and now you can proceed !");
		System.out.println("Just a demo expereiment to check git");
	}
	
	
	
}
