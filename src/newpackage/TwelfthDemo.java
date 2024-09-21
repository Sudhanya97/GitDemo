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

public class TwelfthDemo {
	WebDriver driver;
	String url = "https://demo.guru99.com/test/web-table-element.php";
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void runMethod() throws InterruptedException, ParseException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String max;
		double m=0, r=0;
		List<WebElement> cols = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("Total Cols: "+cols.size());
		System.out.println("Total Rows: "+rows.size());
		WebElement baseTable = driver.findElement(By.tagName("table"));
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[5]"));
		String rowText = tableRow.getText();
		WebElement cellIneed = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[5]/td[4]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Fifth Row: "+rowText);
		System.out.println("Fifth Row's Fourth Element:"+valueIneed);
//		Thread.sleep(3000);
		
		WebElement mytable = driver.findElement(By.xpath("/html/body/table/tbody"));
    	//To locate rows of table. 
    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
    	//To calculate no of rows In table.
    	int rows_count = rows_table.size();
    	//Loop will execute till the last row of table.
    	for (int row = 0; row < rows_count; row++) {
    	    //To locate columns(cells) of that specific row.
    	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
    	    //To calculate no of columns (cells). In that specific row.
    	    int columns_count = Columns_row.size();
    	    System.out.println("Number of cells In Row " + row + " are " + columns_count);
    	    //Loop will execute till the last cell of that specific row.
    	    for (int column = 0; column < columns_count; column++) {
    	        // To retrieve text from that specific cell.
    	        String celtext = Columns_row.get(column).getText();
    	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
    	    }
    	}
//		for (int i =1;i<rows.size();i++)
//        {    
//            max= driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
//            NumberFormat f =NumberFormat.getNumberInstance(); 
//            Number num = f.parse(max);
//            max = num.toString();
//            m = Double.parseDouble(max);
//            if(m>r)
//             {    
//                r=m;
//             }
//        }
//		System.out.println("Maximum current price: "+r);
//		Thread.sleep(10000);
	}
	
	@After
	public void tearDown(){
		System.out.println("QUITTING THE DRIVER AND BROWSER INSTANCE");
//		driver.close();
		driver.quit();
	}
	
}
