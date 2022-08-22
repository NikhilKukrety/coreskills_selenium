import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();

		//Creating "Actions" class with object 'a' to handle interactions (mouse over, double click, etc.):
		Actions a = new Actions(driver);
		
		//First storing the element which we need to hover over to a variable:
		WebElement move = driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		
		//Now I need to hover my mouse over the above link (we need to "build" and "perform" this step in order to execute):
		a.moveToElement(move).build().perform();
		
		//Now we want to move to search box and enter "HELLO" in caps and highlight it (double click):
		//Also, in order to write in caps, we press and hold "SHIFT" manually, double click, so doing this below:
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
		
		//Now I want to right-click the first element:
		a.moveToElement(move).contextClick().perform();
		
		//Handling Child Windows (or tabs; it will handle tabs also like a new window):
		
	}

}
