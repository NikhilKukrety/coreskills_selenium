import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {

	public static void main(String[] args) throws IOException {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//GOAL:
		/*So, basically here we are capturing first available course name at https://rahulshettyacademy.com (second tab), and pasting it in
		the field "Name" on the site https://rahulshettyacademy.com/angularpractice
		*/
		
		//Now, lets switch to a blank tab:
		driver.switchTo().newWindow(WindowType.TAB); //Control is still in the previous home page, and not here.
		
		/*Now, before moving on to the next window, we need get its ID, and then switch to it. To get the ID, we first need to
		find how many windows/tabs are currently present (using window handles), and then iterate through each of them:
		*/
		
		Set<String> handles = driver.getWindowHandles(); //Return type of getWindowHandles() is a set of strings.
		
		//Now, we will iterate through each of them:
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next(); //Id of homepage will be stored in parentWindow string
		String childWindow = it.next();  //Id of next window will be stored in childWindow string
		
		//Now, finally, switching to next window (childWindow):
		driver.switchTo().window(childWindow); //Now, control will be sent to the next window:
		
		//now, hitting the second URL:
		driver.get("https://rahulshettyacademy.com");
		
		
		//Now, getting the name of the first course:
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
		.get(1).getText(); //Basically, this cssSelector matches 24 elements, and we are using get(1) to get the first course (first index).
		
		//Now, the control needs to switch back to Parent window:
		driver.switchTo().window(parentWindow);
		
		//Finally, entering the first course name on the "Name" field:
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		
		//Now, I want to take the SCREENSHOT of the element so that we can check if entered text is correct or not.
		//This is also called as "PARTIAL SCREENSHOT"
		//So, we will use below method:
		File file = name.getScreenshotAs(OutputType.FILE);
		
		//Now, using the object "file" getting the physical file:
		/*ALSO, to convert file object to physical file, we need to import a JAR for fileUtils class:
		 * google search - apache commons fileutils maven and download the jar common-io-2.6:
		*/
		
		//Converting file object to physical file
		FileUtils.copyFile(file, new File("CourseNameCaptured.png")); //Now, only the screenshot of "Name" edit box will be saved
		
		//NOW, REFRESH THE PROJECT AND WE WILL SEE THE PNG FILE.
		
	}

}
