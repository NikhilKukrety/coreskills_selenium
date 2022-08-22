import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {

		// .classname = becomes css
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Here we are selecting checkboc Senior Citizen. ID* means we are not copying
		// complete ID(if it is very big, put * - regular expression):
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		// assertions are used to automatically detect where our code can break (write a
		// better definition).

		// Below means, inside the assert, it should return true, or else it will break:
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		// Now we need to check if checkbox is selected or not, use IsSelected() method:
		System.out.print(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		// Now I need to find out, how many checkboxes are present on the page - size();
		// To do that, identify the locator which is same for all the checkboxes. Here
		// it is "type='checkbox': Use Elements and size();:
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		// clicking on dropdown:
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);

		// Clicking on "+" icon 4 times, so I will create a loop:

		int i = 1;

		// Run the code inside the while loop, till i is less than 5:
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}

		// We can also use for loop for above clicks:

		/*
		 * int j=1; for(j=1;j<5;j++) { driver.findElement(By.id("hrefIncAdt")).click();
		 * }
		 */

		// Clicking on "Done" button:
		driver.findElement(By.id("btnclosepaxoption")).click();

		// Now I want to see if 5 adults are selected or not, so I can print the text on
		// the dropdown:

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// To check if 5 adults is correct or now:
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		// Checking if second calendar is enabled or not. It should return false as we
		// have not yet selected "Round Trip" radio button:
		/*
		 * But we will not be using isEnabled() method here bcoz below code will not
		 * detect if calendar is disabled or not bcoz when we click on that calendar, it
		 * becomes enabled, hence selenium gets confused.
		 */
		// System.out.println(driver.findElement(By.name("ctl00_mainContent_rbtnl_Trip_1")).isEnabled());

		// Now we need to check the disabled or enabled elements:
		// Below selects the radio button "Round Trip" which enables the second
		// calendar:
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		// Now checking if the second calendar got enabled:
		// driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled();

		// Checking if the above is enabled or not, which means it will return true or
		// false:
		// For same reason as above, we will not be using below method:
		// System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

		// Instead, we will use the below method. We need to check what attribute's
		// value is changing when we enable and disable the calendar:
		// Here, that attribute it "style" and its value is "opacity" which is changing
		// from 0.5 to 1 when it gets enabled:
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			/*
			 * It means if the above element's style attribute's opacity value is 1, then
			 * radio button is clicked, and calendar should get enabled.
			 */

			System.out.println("It's enabled.");
			// Pass the test:
			Assert.assertTrue(true);

		}

		else {
			// Fail the test:
			System.out.println("It's disabled.");
			Assert.assertTrue(false);
		}

	}

}
