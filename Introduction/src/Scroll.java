import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		//TO USE THE SCROLL FEATURE, WE NEED TO EXECUTE JAVASCRIPT.
		
		//THERE IS A JAVASCRIPT CLASS CALLED "JavaScriptExecutor" WHICH WE NEED TO USE:
		JavascriptExecutor js = (JavascriptExecutor)driver; //Now driver is aware that it can execute java scripts.
		
		//TO SCROLL ON BROWSER LEVEL:
		js.executeScript("window.scrollBy(0,500)"); //We can use this same script "window.scrollBy(0,500)" in "console" of dev tools to see exactly where we are reaching on a page. This is called hit and trial method.
		
		Thread.sleep(3000); //Giving 3 seconds wait so that we can see clearly the two scrolls (above and below).
		
		/*Now, lets say we have a table (or any element) on a web page,
			and that component has its own scrollbar, so how can we scroll on that particular element?
			For that we need to use "document.querySelector". Just like we have cssSelector in selenium, we have document.querySelector in JavaScript.
			So use below:*/
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); //Scrolling on table level.
		
		
		//Now, we want to grab the elements of the 4th column of this required table ,and store the list in a variable:
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")); // ".tableFixHead" is the parent and "td:nth-child" is the child.
		
		//Now, lets iterate through each web element and sum them.
		int sum=0;
		
		for(int i=0; i<values.size(); i++)
		{	
			sum = sum + Integer.parseInt(values.get(i).getText()); //This will convert the string "28" to integer 28.	
		}
		
		//Printing the total sum:
		System.out.println(sum);
		
		//Now, we need to compare this sum obtained with the sum mentioned on the page - "Total Amount Collected: 296":
		
		//First grabbing the text from the page and then splitting it:
		System.out.println(driver.findElement(By.cssSelector(".totalAmount")).getText());
		
		//Splitting the above string now:
		String[] splittedString = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":");
		
		//Trimming " 296" and storing it in a variable:
		String finalSplittedString = splittedString[1].trim();
		
		//Printing the final string:
		System.out.println(finalSplittedString);
		
		//Now, we need to convert this string to integer, and storing it in a variable of type int:
		int num = Integer.parseInt(finalSplittedString);
		
		/*if(num == sum)
		{
			System.out.println("Addition by code is correct");
		}
		else
		{
			System.out.println("Addition by code is incorrect");
		}*/
		
		//Instead of using the above if else statement, do it with Assert:
		Assert.assertEquals(sum, num); //Means, check if actual "sum" obtained is equal to expected "num".

	}

}
