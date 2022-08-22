import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		//Now, the goal is to select the link displaying at the top right corner of the page:
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		
		//Now, our goal is to get the email id present of the new tab and paste it in the username field of the parent window:
		
		//Now a new tab is opened, and we need to tell the driver to switch to that window:
		//First we need to get the IDs of the two windows (parent and child):
		//And return type is Set of strings:
		Set<String> windows = driver.getWindowHandles(); //[parentid, childid] This will return the IDs of the two windows.
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		//Now we are on the child window:
		
		//Extracting the email id from the paragraph:
		System.out.println(driver.findElement(By.cssSelector("p[class='im-para red'")).getText());
		
		//Extracing the email id from above paragraph:
		//First we need to split the string based on the word "at" and now storing this array of string in a variable:
		String[] splittedString = driver.findElement(By.cssSelector("p[class='im-para red'")).getText().split("at");
		
		//Now splitting this string based on " with":
		String[] newlySplittedString = splittedString[1].split("with");
		
		String finalSplittedString = newlySplittedString[0].trim();
		System.out.println(finalSplittedString);
		
		//Now we need to go back to parent window:
		driver.switchTo().window(parentId);
		
		//Now, entering the email id obtained on the username field:
		driver.findElement(By.id("username")).sendKeys(finalSplittedString);
		
		
		
		
		
		

	}

}
