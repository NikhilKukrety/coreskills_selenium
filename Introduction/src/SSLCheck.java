import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		
		//To handle SSL Certifications (not secure sites - http), there is a class called "ChromeOptions" which basically handles the behaviour of the chrome browser.
		
		//Creating object "options" of the "ChromeOptions" class.
		
		//**AND ALSO, WE NEED TO PASS THIS OBJECT TO DRIVER SO THAT IT KNOWS THAT WE NEED TO BYPASS SUCH INSECURE SITES.
		ChromeOptions options = new ChromeOptions();
		
		//Using the below method of this class, we can by pass the insecure websites:
		options.setAcceptInsecureCerts(true); //When we set it to "true", it will accept it, and WE WILL REACH THE MAIN PAGE.
		
		
		//now we can use this object to access methods of this class to set the behaviour of the browser:
		

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();

		
		//Printing the title of the main page (after bypassing the insecure certifications):
		System.out.println(driver.getTitle());
		
		
		//**NOW, THERE ARE 2-3 METHODS THAT WE WILL BE USING OF THIS CLASS, IN REAL TIME:
		/*
		 * 1. SETTING PROXY USING PROXY CLASS:
		 * Proxy proxy = new Proxy();
		 * now based on requirement, we can use below:
		 * proxy.setHttpProxy("ipaddress:4444");
		 * options.setCapability("proxy" , proxy)
		 */
		
		
		//2. We can use one of the methods of this class to block unnecessary pop-up windows like "Allow location", etc.
		
		/*3. We can set the path of the files that we download using "HashMap" class - use this code everywhere:
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		//Setting the path - where to download the file:
		prefs.put("download.default_directory", "/directory/path");
		
		options.setExperimentalOption("prefs", prefs);
		*/
	}

}
