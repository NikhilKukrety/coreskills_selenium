import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {

	public static void main(String[] args) {
		
		//**IMPORTANT FOR INTERVIEW:
		//Lets say we want to select July 23rd 2022 in this example.

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		
		//Click on the calendar field:
		driver.findElement(By.id("travel_date")).click();
		
		//First, we need to select the month (July) - below cssSelector is a parent to child traverse - [class = parent class] [class = child class]
		//And we need to click next month button while the month is not July:
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("July"))
		{
			//Click on next (>>) button to move to next month:
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
		}
		
		//Now, we need to get all the dates by getting common attribute for dates, and then iterate through them to find 23rd:
		//**always use cssSelector like this for calendars, so you can handle calendars in all websites.
		List<WebElement> dates = driver.findElements(By.cssSelector(".day"));
		
		//Now, iterating through each item in the list:
		for(int i=0; i<dates.size(); i++)
		{
			String date = driver.findElements(By.cssSelector(".day")).get(i).getText();
			
			if(date.equalsIgnoreCase("23"))
			{
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}
		
		

	}

}
