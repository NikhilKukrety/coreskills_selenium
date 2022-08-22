import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//To maximize window - Before loading the page, it will first maximize the page:
		
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		
		//To delete all the cookies:
		driver.manage().deleteAllCookies();
		
		/*To delete a specific cookie:
		driver.manage().deleteCookieNamed("asdf"); //Say "asdf" is an example name of a cookie.
		*/
		
		//**COULD BE INTERVIEW QUESTION:
		//Suppose, we need to check if after deleting cookie, the session is expired and we reach the login page, so we will do it as below:
		/*First delete the cookie:
		 * driver.manage().deleteCookieNamed("sessionKey"); //Let's say name of the cookie is "sessionKey"
		 * And now, click on any link. It should re-direct us to the login page.
		 */



	}

}
