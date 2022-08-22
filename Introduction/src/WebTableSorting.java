import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Using Java Streams, we will sort the table contents (fruits) in order:
		//Click on the column and then capture all the contents. Then grab them using .get(i). Then capture them in a list (original list).
		//Then sort the original list to get the sorted list. Then, compare the original and sorted list:
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Grabbing the contents:
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//Using streams, we will get them and sort them aand get the list (original):
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
	
		//Printing the new List:
		System.out.println(originalList);
		
		//Now, sorting this original list to get the sorted list:
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());	
		System.out.println(sortedList);
		
		//Comparing the original and sorted list if both are same or not:
		Assert.assertEquals(originalList, sortedList);
		
		
		
		
		
		

	}

}
