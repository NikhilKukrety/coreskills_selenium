import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggesstiveDropdown {

	public static void main(String[] args) throws InterruptedException {

		// Auto suggestive dropdowns are one on which options appear based on what we
		// write on the field:

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		// There is a slight delay before the options appear:
		Thread.sleep(3000);

		/*
		 * Now we need to scan the options and then select the correct option because we
		 * dont know at what order our option will appear.
		 */

		/*
		 * Here also, we will use the PARENT-CHILD RELATIONSHIP TO select "India" from
		 * autosuggestive options but now by cssSelector:
		 */

		// Now we are selecting options from a list, so use below. Scan all options and
		// select india:

		// Also, since we will be scanning options, there will be many elements, hence
		// we use "findElements":
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		// Enhanced for loop:
		// From autosuggestive options, scan option one by one:
		for (WebElement option : options) {
			option.getText();
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();

				// When we have got the option, come out of the for loop:
				break;
			}
		}

	}

}
