import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//INTERVIEW QUESTION:
		//We need to count the number of links in a web page:
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//GET LINKS COUNT ONLY ON THE FOOTER SECTION:
		//INSPECT THE FOOTER AND THEN COUNT FROM THERE:
		//ALSO, WE NEED TO LIMIT THE SCOPE OF DRIVER TO FOOTER SECTION, BY CREATING A MINI DRIVER (DRIVER SUBSET):
		
		//STORING THE WEBELEMENT(FOOTER) IN A VARIABLE "footerDriver" - Here footerDriver is a mini driver we have created:
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		
		//Now, using this mini driver, finding the count of links on this footer:
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//HOW TO FIND THE LINKS ONLY ON A PARTICULAR SECTION OF THE FOOTER (SAY DISCOUNT COUPONS SECTION):
		
		//REACHING TO THE REQUIRED PATH USING XPATH - traversing from parent to child:
		WebElement discountDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(discountDriver.findElements(By.tagName("a")).size());
		
		//Let's store the number of links obtained on the discount coupons section:
		int discountSize = discountDriver.findElements(By.tagName("a")).size();
		
		//HOW TO CLICK ON EACH LINK ON THE DISCOUNT COUPONS SECTION:
		int i = 1; //because first link is not working.
		for(i=1; i<discountSize; i++) //this for loop will open all the tabs.
		{
			
			//We have a concept called Keys, where we can press and hold control, etc. - WE WILL PASS ALL THE KEYBOARD EVENTS IN SEND KEYS:
			String clickAndOpenNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			//Retrieving the link and then clicking on it:
			discountDriver.findElements(By.tagName("a")).get(i).sendKeys(clickAndOpenNewTab);
			Thread.sleep(2000);
			
		}
			
			//Navigating back and then clicking it again will take much time and it is not a good practice.
			//So while clicking the link, press and hold control so that links will be opened in different tabs.
			
			//Now we need to navigate each and every tab and get the title of the page - using window handles we need to iterate to each tab:
			Set<String> abc = driver.getWindowHandles(); //4
			Iterator<String> it = abc.iterator();

			//Now, while there are windows, means if there are windows opened, then move to the next window and print the title:
			while(it.hasNext()) //this while loop will iterate over all the tabs, and get the title.
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
		
		

	}

}
