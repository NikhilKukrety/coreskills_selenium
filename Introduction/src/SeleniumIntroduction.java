import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		
		//First step is to invoke the browser:
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		
		
		/*We need to create object of class "ChromeDriver" to access all the
		methods in chromeDriver*/
		/*Famous interview question - which one to use below?
		ChromeDriver driver = new ChromeDriver(); or below*/
		WebDriver driver = new ChromeDriver();
		/*Because if we use first one, it will not have access to all
		methods of other browsers. In second one, driver object will have access to all
		chromeDriver methods which are defined in the webDriver*/
		
		//Launches the below page:
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//To get the title of the page:
		driver.getTitle();
		
		//Printing the title in output:
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.quit();
		//driver.close();
		/*Difference between close and quit is that close only closes the tab which got
		originally opened when code ran. Quit will close all instances. */
		

	}

}
