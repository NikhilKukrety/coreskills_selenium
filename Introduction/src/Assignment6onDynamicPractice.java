import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6onDynamicPractice {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//clicking the checkbox "Option3":
		driver.findElement(By.id("checkBoxOption3")).click();
		
		//Now, we need to retrieve the label for the selected checkbox and see if it is correct:
		System.out.println(driver.findElement(By.cssSelector("label[for='honda']")).getText());
		
		//Now storing the text in a variable:
		String grabbedText = driver.findElement(By.cssSelector("label[for='honda']")).getText();
		
		//Since dropdown is a select dropdown, we need to use the "select" class"
		//First storing the dropdown element in a webelement dropdown:
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		
		//Select class:
		Select dropdown = new Select(staticDropdown);
		
		//Selecting the dropdown for which we selected the checkbox:
		dropdown.selectByVisibleText(grabbedText);
		
		//Now, entering the grabbed text in the edit box of the Alert message:
		driver.findElement(By.id("name")).sendKeys(grabbedText);
		
		//Clicking the "alert" button:
		driver.findElement(By.id("alertbtn")).click();
		
		//Now, as a final step, we need to check if grabbed text is present on the popup message:
		//Switching to Alert message and printing the message:
		
		System.out.println(driver.switchTo().alert().getText());
		
		//Storing the alert text in a variable:
		String alertText = driver.switchTo().alert().getText();
		
		//Now, check the requirement if grabbedText is present in the alert:
		if(alertText.contains(grabbedText))
		{
			System.out.println("Grabbed Text "+grabbedText+" is present on the Alert message");
		}
		else
		{
			System.out.print(grabbedText+" is not present on the Alert message");
		}
	
		
		
		
		
	}

}
