import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1CountCheckboxes {

	public static void main(String[] args) {
			
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Common locator for all 3 checkboxes is "type=checkbox":
		
	System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
