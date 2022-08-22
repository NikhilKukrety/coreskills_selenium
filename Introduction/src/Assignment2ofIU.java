import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2ofIU {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// Entering my Full name on the "Name" text field:
		driver.findElement(By.name("name")).sendKeys("Nikhil Kukrety");

		// Entering my email id on the "Email" text field:
		driver.findElement(By.name("email")).sendKeys("kukretynikhil4@gmail.com");

		// Entering a random password on the "Password" text field:
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("rahulshettyacademy");

		// Checking the checkbox "Check me out if you love iceCreams!":
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();

		/*
		 * Since the "Gender" dropdown has the tag "select", it means it is a static
		 * dropdown. then we will be using the class "Select" to select my gender
		 * (Male):
		 */
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));

		// Creating object of "Select" class:
		Select dropdown = new Select(staticDropdown);

		// To check if "Male" is selected or not:
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// Selecting the radio button "Student" for Employment Status:
		driver.findElement(By.id("inlineRadio1")).click();

		// Entering the DOB as "16101996":
		driver.findElement(By.name("bday")).sendKeys("16101996");

		// Clicking the submit button:
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Finally, capturing the success message:
		System.out.println(
				driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible'")).getText());

	}

}
