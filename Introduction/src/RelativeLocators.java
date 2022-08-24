import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//To use relative locators, we need to import the below package and write it manually as it is static:
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		
		//Relative locators are also known as friendly locators.
		/*They are used to find elements (that cannot be located easily, eg. only having tagnames and no other attribute to get them)
		 * that are nearby to an element (which can be located easily). 
		*/
		//Format - driver.findElement(with(By.tagName(tagname of the element which we need to find").above(web element with whose help we are finding the element));
		//Like above(), we have 3 more methods as Below(), toLeftOf() and toRightOf();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		//Now, storing the name edit box web element in webelement:  
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
		
		//Now, using the relative locator below to get to the "Name" label above the edit name text box:
		//Below code says, the element "Name" (having only attribute as tagname) which we are trying to find is located above the nameEditBox element
		String text = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		System.out.println(text);
		

	}

}
