import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterWebTableUsingJavaStreams {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Clicking the search button. We dont need to "enter" because rice will display as we enter in the search box:
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		//Now, only 1 result will be displayed:
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		//Now, only 1 result will be displayed and we need to check if it contains "Rice":
		List<WebElement> filteredList = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
		
		//Comparing the two lists if they are equal or not in size:
		Assert.assertEquals(veggies.size(), filteredList.size());
		
		
		
	}

}
