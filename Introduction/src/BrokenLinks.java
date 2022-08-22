import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		

		/* A broken link is link which does not work. Basically, on clicking that link,
		 * we will navigate to an error page, or 404 not found error page, etc.
		 * If error code is greater than 400, then URL is not working.
		 */
		
		/* To validate a broken link, follow the below steps:
		 * 1. Using SELENIUM, get all URLs tied up to all the links on the web page.
		 * 2. Using JAVA METHODS, we will call the URLs and we will get the status code of all of these URLs.
		 * 3. If status code>400, that means the link is broken (or not working). Basically the link which is
		 * tied to that URL is broken.
		 */ 
		
		//Storing all the links on variable "links":
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		/**IMPORTANT CONCEPT**: SOFT ASSERTION CLASS. It means by using this, we will not let our script fail even if we have failures.
		*We are using this basically to validate all the broken links, so that when our script finds a broken link, it does not
		*fail the script, but cpntinue to run it even when we are reporting failed or broken links:
		*/
		//Creating object 'a' of class "SoftAssert":
		SoftAssert a = new SoftAssert();
		
		
		
		
		//Now Iterating for each link using enhanced for loop:
		for(WebElement link : links)
		{
			
			String url = link.getAttribute("href");
			
			//Java methods:
			//Open Connection Concept - to get the status code of a URL using Open Connection method:
			//Syntax:
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			/*Above line of code says that we are calling a method called "openConnection()",
			belonging to the "URL" class. The return type of the method is "HttpURLConnection". Now, connection is established to the retrieved URL.
			*/
			
			//Now, we are making a call to the URL using the "HEAD" http request type. It can be GET, POST, DELETE, etc...
			conn.setRequestMethod("HEAD");
			
			//Now we need a response back, by doing the below, we will make a call to that url and get the response. The response will sit in "conn" object only.
			conn.connect();
			
			//From the object only we will retrieve the response. We just need status code of the url, so do below:
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			
			//Now using SoftAssert concept, fail the condition and print the required text, and script keeps on running.
			//Also, the below code will be catching all the broken links.
			a.assertTrue(responseCode<400, "The link with text "+link.getText()+" is broken with Status Code "+responseCode);
			//So, above line means when "responseCode<400" condition is false (say 404<400, then print the above message.

			
		}
		
			//Now, above code has caught up all the broken links. Now we have to report them. Using below code we will report them:
			a.assertAll(); //If there are no issues caught up in above code, this line of code will pass the test, otherwise it will fail.
			
	}

}
