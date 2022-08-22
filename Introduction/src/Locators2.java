import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("rahul");
		
		//Finding the password element by using Regular Expression:
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		//Checking the checkbox:
		driver.findElement(By.id("chkboxOne")).click();
		
		//Checking terms and conditions checkbox:
		driver.findElement(By.id("chkboxTwo")).click();
		
		//Clicking sign in button:
		driver.findElement(By.className("submit")).click();
		

	}

}
