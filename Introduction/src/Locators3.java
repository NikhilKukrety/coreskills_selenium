import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String name ="Nikhil";
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//calling the method created to get the password - 2 ways - use object of that class to call, or use keyword "static":
		
		/*1st method:
		Locators3 method = new Locators3();
		method.getPassword(driver);*/
		
		//Using this currently - 2nd Method - given the keyword static on the method:
		String Password = getPassword(driver);
	
				
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		
		//Typing the dynamically obtained passowrd through mthod getPassword();:
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(Password);
		
		//Checking the checkbox:
		driver.findElement(By.id("chkboxOne")).click();
		
		//Checking terms and conditions checkbox:
		driver.findElement(By.id("chkboxTwo")).click();
		
		//Clicking sign in button:
		driver.findElement(By.className("submit")).click();
		
		Thread.sleep(3000);
		//If there is only tag name present, find it by tag name. Below we are finding text and printing it:
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		//assertion - used to compare output text with expected text:
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		//Now validating the name which appears after we login:
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+"," );
		
		//Clicking on Log Out button and close the browser:
		//We need to find button based on the text on the button by using xpath:
		
		//Syntax:
		//tagname[text()='text written on the html']
		
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		//close the browser:
		driver.close();
	}
	
	
	//creating a method to extract the password dynamically from the text:
	//To make use of the driver outside the main block, pass the driver as input like below:
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		
		//Now store that complete text in a string:
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		
		//Please use temporary password 'rahulshettyacademy' to Login.
		
		//Now, sliitting the strings to get the password dynamically from the text:
		passwordText.split("'");
		//So now, the string is divided into 2 pieces - "Please use temporary password", "rahulshettyacademy' to Login.".
		
		String[] splittedString = passwordText.split("'");
		
		//Now again, splitting the splitted string into another piece on the basis of ':
		splittedString[1].split("'");
		
		//New splitted array of strings = "rahulshettyacademy" and "to Login".
		
		//Now storing this splitted string in another string:
		String[] newSplittedString = splittedString[1].split("'");
		
		//Now storing the final text obtained in password:
		String password = newSplittedString[0];
		System.out.println(password);
		
		return password;
		
	}

}
