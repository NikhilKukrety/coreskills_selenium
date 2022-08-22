import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8onAutoSuggestiveDropddown {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//Clicking and entering "ind" in the autosuggestive dropdown field:
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		
		//Now, we need to scan all the elements that come up after typing "ind":
		List<WebElement> countries = driver.findElements(By.xpath("//ul/li/div"));
		
		String country = null;
		for(int i=0; i<countries.size(); i++)
		{
			country = countries.get(i).getText();
			
			if(country.equalsIgnoreCase("India"))
			{
				driver.findElements(By.xpath("//ul/li/div")).get(i).click();
				break;
			}
			
		}
			//Now, printing the text obtained after selecting "India". "India" should be displayed:
			//String text = driver.findElement(By.cssSelector("input[id='autocomplete']")).getText();
			System.out.println(country);
}
}
