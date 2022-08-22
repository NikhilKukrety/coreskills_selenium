import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7onWebTables {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Clicking on "Practice" link:
		driver.findElement(By.xpath("(//ul/li/a)[11]")).click();
		
		//NOW, WE NEED TO SCROLL DOWN TO SEE THE TABLE, USING JAVASCRIPT:
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,650)");
		
		//We have reached to the required table. Now, we need to print the number of rows from the web table:
		
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr:nth-child(n)")); //Here number of rows, i.e. 11 elements will be stored.
		
		//Printing the number of rows:
		System.out.println("The number of rows are "+rows.size());
		
		//Now, lets print the number of columns in the table:
		List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th:nth-child(n)"));
		
		//Printing the number of columns:
		System.out.println("The number of colums are "+columns.size());
		
		
		//Now, final step is to print the data present in second row:
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
		

	}

}
