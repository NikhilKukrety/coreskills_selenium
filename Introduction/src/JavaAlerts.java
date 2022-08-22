import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAlerts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		String text = "Nikhil";

		// finding the element where we will type the name:
		driver.findElement(By.id("name")).sendKeys(text);

		// Clicking the alert button:
		driver.findElement(By.id("alertbtn")).click();

		// Now we need to grab the text from the alert:
		System.out.println(driver.switchTo().alert().getText());

		// Now, an alert popup will display and we need to handle it:
		/*
		 * We need to switch the context from driver to alert and then accept the alert
		 * (Means to change the locator to another frame or window:
		 */
		driver.switchTo().alert().accept();

		// Now there are some alerts where we have more than 1 button, say "OK" and
		// "Cancel".
		// Again send the text in the field and click on Confirm button this time:
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("confirmbtn")).click();

		// An alert message will popup having "OK" and "Cancel" button:
		System.out.println(driver.switchTo().alert().getText());

		// Clicking Cancel (or negative answer):
		driver.switchTo().alert().dismiss();

	}

}
