import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3onExplicitWait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String[] itemsNeeded = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };

		// Calling the method:
		loginAndAddItemsToCart(driver, itemsNeeded);

	}

	public static void loginAndAddItemsToCart(WebDriver driver, String[] itemsNeeded) {

		// Entering username as "rahulshettyacademy":
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

		// Entering password as "learning":
		driver.findElement(By.id("password")).sendKeys("learning");

		// Selecting the radio button as User:
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

		// Wait until alert is present. So, use explicit wait here:
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));

		driver.findElement(By.id("okayBtn")).click();

		// Now selecting the option "Consultant" from static dropdown:
		// First creating "Select" class as we are dealing with a static dropdown:
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown = new Select(staticDropdown);

		dropdown.selectByIndex(2);
		System.out.println("Option selected from dropdown is " + dropdown.getFirstSelectedOption().getText());

		// Checking the checkbox:
		driver.findElement(By.id("terms")).click();

		// Clicking Sign In button:
		driver.findElement(By.id("signInBtn")).click();

		// Now, lets store all the items before we iterate them:
		// Now, we are storing all the 4 elements in WebElement "products":
		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

		/*
		 * Now, we need to iterate all these items and only click on the specific items
		 * which we need. Here, we need all 4 items.
		 */

		int i;
		int j = 0;
		for (i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();

			// Now converting the array into arrayList:
			List itemsNeededList = Arrays.asList(itemsNeeded);

			/*
			 * Now we are checking if string "name" contains the items which we need, then
			 * click on "Add" button:
			 */
			if (itemsNeededList.contains(name)) {
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}
			}
		}

		// Clicking the "Checkout" button:
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();

		/*
		 * Now, printing the message "Assigment 3 completed!" when all items are added
		 * and checked out. Else, print "Failed!":
		 */
		if (j == itemsNeeded.length) {
			System.out.println("Assignement 3 is completed successfully!");
		}

		else {
			System.out.println("Failed!");
		}
	}

}
