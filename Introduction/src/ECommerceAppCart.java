import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ECommerceAppCart {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Below is example of Implicit wait. This wait is applied to every step now, i.e. it is applied globally:
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //comment it out if using explicit wait.
		//Grabbing the successful text message after applying coupon:
		//Defining explicit wait here because it takes longer time, means we are targetting only this element:
		//To defind explicit wait, one way is to define WebDriver wait class:
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();


		// Say I want to select "Brocolli" and "Cucumber":
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Cauliflower" };
		//addItems(driver, itemsNeeded); //We can do this when we have written static.
		
		//Creating object of this class when we don't write static:
		ECommerceAppCart b = new ECommerceAppCart();
		b.addItems(driver, itemsNeeded); //This is called a utility.
		
		//Clicking the cart icon:
		driver.findElement(By.cssSelector("img[alt='Cart'")).click();
		
		//Clicking "PROCEED TO CHECKOUT". We can use by text as text on the button is static:
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		
		//Below is again exapmple to use explicit wait if we are not using implicit wait:
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='promoBtn'")));
		
		//Entering promocode as "rahulshettyacademy:"
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		
		//Clicking on "Apply" button:
		driver.findElement(By.cssSelector("button[class='promoBtn'")).click();
		

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded)
	{
		int j=0;
		// Adding Cucumber item to the cart:
				// We need to iterate all elements and then find cucumber and then click "Add to Cart" button for it:
				// tagname.classname = becomes css selector:
				List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
				// Since there are 30 elements with this cssSelector, we will iterate through all of these.

				// Now iterating through all of these:
				for (int i = 0; i < products.size(); i++) {

					// Returning text for each element and then we need to split the name based on
					// '-':
					String[] name = products.get(i).getText().split("-");
					// So name[0] will be Brocolli and name[1] will be Cucumber .
					// Now splitting the space with the name:
					String formattedName = name[0].trim();

					// Let's convert array into arrayList:
					List itemsNeededList = Arrays.asList(itemsNeeded);

					if (itemsNeededList.contains(formattedName)) {
						// Now, why do we need to run it 30 times when we have found the 3 items? And
						j++;
						// Click on "Add to Cart - //button[text()='ADD TO CART']
						// driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
						// Locating element by text is not recommened as sometimes the text keeps on changing, so instead of using text locator, use below:
						driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
						//Above we are using parent-child relationship
						// also, we cannot use break. So do this:
						// Our test will pass when the loop has iterated 3 times. So:
						//We use length() to get size of array, and we use size() to get size of arrayList.
						if (j == itemsNeeded.length) {
							break;
						}
					}
				}

	}

}
