import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {

	public static void main(String[] args) throws IOException {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		
		//In order to take screenshots, you need behavior of the driver to take screenshot.
		
		//Observe below line of code:
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		/*So, in above code, we are saying that the bahvior of the driver object should be set to take screenshot.
		  There is a method called "getScreenshotAs()" that takes the screenshot, and the format of the output of type "File".
		  And then store this file (screenshot) in an object called "src".*/
		
		//Now, we need to copy this file from "src" to store it in our machine in 'C' drive. So use a java method called "FilesUtils".
		FileUtils.copyFile(src, new File("D:\\Selenium\\Screenshots Taken By Selenium\\GoogleDotCom.jpg"));
		

	}

}
