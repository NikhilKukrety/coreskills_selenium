import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Implicit wait - to wait atleast given seconds and find the elementv(within these seconds):
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//**Now the above wait time will be applicable to each step.
				
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//Using ID Locator to identify web element and sending value on that field:
		driver.findElement(By.id("inputUsername")).sendKeys("Nikhil");
		
		//Now Password:
		driver.findElement(By.name("inputPassword")).sendKeys("NikhilKukrety");
		
		//Clicking the submit button:
		driver.findElement(By.className("submit")).click();
		
		//To find element by CSS selector, you can do by two ways (constructing CSS selector):
		// 1. tagname.classname -> this will become a CSS selector.
		// 2. tagname#id -> this will become a CSS selector.
		// 3. If above two are not present, then use generic syntax: Tagname[attribute='value'] -> this will become CSS selector.
		
		
		//Capturing the error message displaying on incorrect login id/password and then printing it in o/p:
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		
		//To check if a css selector locator is unique or not, we need to use plugins like chropath and SelectorsHub. Just search the css selector.
		/*If company does not provide any plugin, then go to Console and type -> $('text to find') and press enter.
		It will tell how many elements with that particular css, id, etc. are there.
		Use $x('') for xpath*/
		
		//Finding element by locator "LinkText":
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//Constructing XPath - Similar to creating generic CSS selector:
		//Syntax:
		// //Tagname[@attribute='value']
		//So, after reaching the Forgot your password page, we are writing name and finding it by xpath:
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Nikhil Kukrety");
		
		//Email:
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("kukretynikhil4@gmail.com");
		
		//Clearing the email text:
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		
		//Important:
		/*If in case we dont have any unique attribute to identify element (means having same attributes for all
		elements, then use index[] to find the element:*/
		
		//Don't go with indeces (last thing to try):
		//Example to find by xpath: //input[@type='text'][1]
		//Example to find by css selector: input[type="text"]:nth-child(1)
		
		//Again entering the email id:
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("kukretynikhil4@gmail.com");
		
		//Constructing xpath using parent-child relationship"
		//Syntax:
		// //parenttagname/childtagname
		//Example: //form/h2[]
		//We will use index[] when we have duplicate child items.
		
		//For css, syntax is:
		//form hs
		
		//Constructing now and finding the xpath for phone number field:
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9971328960");
		
		//Clicking reset login button:
		driver.findElement(By.className("reset-pwd-btn")).click();
		
		//Now after clicking the reset login button, there is a message which pops up that we need to grab:
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		//If say last few words of any value keeps on changing, say "pass" is only static in "password", then use below syntax:
		// input[type*='pass']
		
		//Use Thread.sleep(milliseconds); to make the page wait for given seconds.
		
	}

}
