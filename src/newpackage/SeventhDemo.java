package newpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SeventhDemo {
	WebDriver driver;
	String url = "https://demo.guru99.com/test/write-xpath-table.html";
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void runMethod() throws InterruptedException {
//		Thread.sleep(2000);
		String innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText().toUpperCase();
		System.out.println(innerText);
		driver.get("http://demo.guru99.com/test/accessing-nested-table.html");
		driver.manage().window().maximize();
		innerText = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]")).getText();
		System.out.println(innerText);
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		innerText = driver.findElement(By.xpath("//table[@width=\"270\"]/tbody/tr[3]/td")).getText().toUpperCase();
		System.out.println(innerText);
		innerText = driver.findElement(By.xpath("//table/tbody/tr/td[2]"
				+"/table/tbody/tr[4]/td"
				+"/table/tbody/tr/td[2]"
				+"/table/tbody/tr[2]/td[1]"
				+"/table[2]/tbody/tr[3]/td[2]/font")).getText();
		System.out.println(innerText);
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
	}
	
}
