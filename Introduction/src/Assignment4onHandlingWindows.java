import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4onHandlingWindows {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		//clicking on "Multiple Windows" link:
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		//Now, clicking on "Click here" link to open a new window:
		driver.findElement(By.cssSelector("a[target='_blank']")).click();
		
		//Now, switching to the newly opened window:
		Set<String> windows = driver.getWindowHandles(); //This will get the IDs of the two windows (parent and child).
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childId = it.next();
		//Now, switching to the child window:
		driver.switchTo().window(childId);
		
		//Now, grabbing the text "New Widnow" from this child window:
		System.out.println(driver.findElement(By.cssSelector("div[class='example']")).getText());
		
		//Switching back to parent window:
		driver.switchTo().window(parentID);
		
		//Finally, grabbing the text "Opening a new window":
		System.out.println(driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText());
		

	}

}
