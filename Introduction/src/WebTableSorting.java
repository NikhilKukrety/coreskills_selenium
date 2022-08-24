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
		
		//Using streams, we will get them and sort them and get the list (original):
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
	
		//Printing the new List:
		System.out.println(originalList);
		
		//Now, sorting this original list to get the sorted list:
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());	
		System.out.println(sortedList);
		
		//Comparing the original and sorted list if both are same or not:
		Assert.assertEquals(originalList, sortedList);
		
		//Now, I want to get the price of "Rice" and also search it on different page (pagination). So, do while loop will take vare of it:
		//Scan the name -> if it returns 'beans', then print the price of "beans":
		
		List<String> price;
		
		do
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			
			price = rows.stream().filter(s->s.getText().contains("Rice")).
			map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
			price.forEach(a->System.out.println(a));
		
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("[aria-label='Next'")).click();
			}
		
		}while(price.size()<1);
		
	}

	private static String getPriceVeggie(WebElement s) {
		
		//Now, above we have already traversed to "beans". And its price is basically the element next to it on the table.
		//So basically its price is a sibling of "Beans". Hence code is -> //tr/td[1]/following-sibling::td[1]
		//But, in the below xpath, we will give the path of only sibling, as we have traversed till "Beans" as above:
		//Also, we can say that, if we want to get price of any other item, replace the word "Beans", and below will traverse to its price:
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceValue;
		
	}

}
