import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Here we are dealing with dynamic dropdowns.And at the last, we will deal with
		// calendars:

		// Clicking on 1'FROM" dropdown:
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		// selecting Bengaluru option:
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		/*
		 * Now we need to select Chennai from second dropdown which is "TO" dropdown.
		 * But Chennai option is also there in "FROM" dropdown, then to select the
		 * second option, do this:
		 */

		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		// In above code, we are using second index to select the Chennai option from
		// second dropdown.

		// **IMPORTANT:
		// Some client do not want to use indeces. So use PARENT-CHILD RELATIONSHIP
		// method:

		// First give parent xpath and then give one space, and give child xpath:

		// The difference is that selenium will search the element within the parent
		// area only and not on the entire page:

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		// Selecting today's date with calendar. Note: When we select "To" destination,
		// calendar automatically opens:

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

	}

}
