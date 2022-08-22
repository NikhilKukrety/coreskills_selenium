import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		
		
		//READ ABOUT FRAMES.

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		//Clicking the frame "Drag me to my target" - THIS WILL FAIL BECAUSE BELOW ELEMENT IS A FRAME WHICH CANNOT BE DETECTED ONE ATTRIBUTE.
		//FRAMES CANNOT BE HANDLED LIKE BELOW BY SELENIUM:
		//driver.findElement(By.id("draggable")).click();
		
	
		//TO FIND THE NUMBER OF FRAMES (SAME WAY TO COUNT AS BEFORE):
		System.out.println(driver.findElements(By.tagName("iframe")).size()); //Output will be 1 (for this page).
		
		
		//We need to switch to the complete frame.
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		//Now control will come to this frame.
		//Now we can use below:
		driver.findElement(By.id("draggable")).click();
		
		
		//Now we will do the drag and drop using actions in frame:
		//Drag and Drop is done by actions class.
		
		//So creating "Actions" class:
		Actions a = new Actions(driver);
		
		//We need to identify the source (that needs to be dropped) and target (where we need to drop). So storing those elements:
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		//dragging and dropping source to target:
		a.dragAndDrop(source, target).build().perform();
		
		//IF THERE ARE MULTIPLE FRAMES IN A SINGLE PAGE, THEN SWITCH TO FRAMES USING INDEX (say we need to switch to first frame). BUT IT'S NOT RECOMMENDED:
		//driver.switchTo().frame(0);
		
		//Now we need to switch back to page from frame:
		driver.switchTo().defaultContent();
		
		
	}

}
