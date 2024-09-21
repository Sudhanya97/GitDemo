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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FifthDemo {
	WebDriver driver;
	String url = "http://demo.guru99.com/test/newtours/";
	
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
		WebElement link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver
                .findElement(By
                .xpath("//html/body/div"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr"));    		
        Thread.sleep(3000);
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(link_Home).build();
		Thread.sleep(3000);
		String bgColor = td_Home.getCssValue("background-color");
		Thread.sleep(3000);
		System.out.println("Before Hover: "+bgColor);
		Thread.sleep(3000);
		mouseOverHome.perform();
		Thread.sleep(3000);
		bgColor = td_Home.getCssValue("background-color");
		Thread.sleep(3000);
		System.out.println("After Hover: "+bgColor);
		
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
	}
	
}
