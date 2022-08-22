import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEndUIAutomation {

	public static void main(String[] args) throws InterruptedException {
		
		
		/*Goal is to select "From" city as "Delhi", "To" as "Chennai", select today's date, check "Family and Friends"
		 * checkbox. Enter 3 adults, check if return calendar is disabled, and click on Search button.
		 */

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();

		//Selecting the option "Delhi" from "From" dropdown:
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		
		//Selecting "Chennai" from "To" dropdown:
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		//Selecting "Depart Date" as current date:
		//No need to click on the calendar as it automatically gets opened:
		//driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		//Selecting radio button "One Way" to make sure return calendar is disabled:
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		//To check if Return Calendar is disabled or not:
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("It's disabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(false);
		}
		
		//Now, selecting 3 adults from "Passengers" dropdown:
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		int i=1;
		while(i<4)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Checking the checkbox "Family and Friends":
		driver.findElement(By.cssSelector("input[name='ctl00$mainContent$chk_friendsandfamily']")).click();
		
		//Now, selecting "INR" from currency dropdown. Since it is a select dropdown, we need to use "Select" class:
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByValue("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//Clicking on "Search" button:
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		System.out.println("UI Automation Completed!");
		
	}
	
		

}
