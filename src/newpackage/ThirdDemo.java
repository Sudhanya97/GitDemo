package newpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdDemo {
	WebDriver driver;
	String url = "https://demo.guru99.com/test/ajax.html";
	
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
		Thread.sleep(3000);
		driver.findElement(By.id("no")).click();
		driver.findElement(By.id("buttoncheck")).click();
		Thread.sleep(3000);
		
		driver.get("http://demo.guru99.com/test/ajax.html");
		List<WebElement> elements = driver.findElements(By.name("name"));
		System.out.println("Number of Element: "+elements.size());
		
		for(int i = 0; i<elements.size(); i++) {
			System.out.println("Radio button Text: "+elements.get(i).getAttribute("value"));
		}
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
		System.out.println("Created a new branch to push code into that");
	}
	
}
