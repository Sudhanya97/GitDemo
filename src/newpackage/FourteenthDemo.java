package newpackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Iterator;
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

public class FourteenthDemo {
	WebDriver driver;
	String baseUrl = "https://www.zlti.com";
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void runMethod() throws InterruptedException, ParseException {
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext()) {
			url = it.next().getAttribute("href");
			System.out.println(url);
			
			if(url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			
			if(!url.startsWith(baseUrl)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}
			
			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if(respCode>=400 || respCode>= 500) {
					System.out.println(url +"is a broken link");
				} else {
					System.out.println(url +"is a valid link");
				}
				
			} catch (MalformedURLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
	}
	
}
