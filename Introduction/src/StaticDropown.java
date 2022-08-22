import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropown {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// If dropdown has a "select" tag, then it is a static dropdown and then we have
		// a separate class called "Select" to handle select dropdowns:

		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		// creating object "dropdown"
		Select dropdown = new Select(staticdropdown);

		dropdown.selectByIndex(3);

		// To select first option and show what is selected:
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// To select by text:
		dropdown.selectByVisibleText("AED");

		System.out.println(dropdown.getFirstSelectedOption().getText());

		// To select by value. Value is an attribute you can find in html code of that
		// element:
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());

	}

}
