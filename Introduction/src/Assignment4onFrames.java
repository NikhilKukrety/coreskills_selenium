import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4onFrames {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		//Applying implicit wait:
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Clicking on "Nested Frames" link:
		driver.findElement(By.linkText("Nested Frames")).click();
		
		//Switching to the frameset (parent frame) first:
		driver.switchTo().parentFrame();
		
		//Now witching to the next parent frame (to go to second frame):
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		
		//Now switching to the second frame:
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		
		//Printing the word "MIDDLE":
		System.out.println(driver.findElement(By.id("content")).getText());
		
		//Coming out of the frame:
		driver.switchTo().defaultContent();
		
		

	}

}
