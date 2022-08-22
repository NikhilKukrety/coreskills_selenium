
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximing window lets selenium find objects on the screen properly:
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
		
		//Navigate to another page:
		driver.navigate().to("https://rahulshettyacademy.com");
		
		//Go back to previous page:
		driver.navigate().back();
		
		//Go back to rahulshetty site again:
		driver.navigate().forward();
		

	}

}
