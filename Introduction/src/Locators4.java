import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators4 {

	public static void main(String[] args) {
		
		//**WE MAY NOT USE THIS IN REAL TIME. BUT IT IS IMPORTANT FOR INTERVIEW QUESTIONS. AND THIS IS NOT POSSIBLE IN CSS.
		
		//here we are practicing child-parent-grandparent and reverse traverse:
		//Parent to child and sibling traverse. Sibling means button, link next to the child (button or link or anything):
		
		//**IMPORTANT:
		//Absolute XPATH - traversing from root element (<html) to the child element. This is the complete path.It starts with /:
		//Example: /html/body/header...
		
		//Recommended to use:
		//Relative XPATH - We can just start from middle, and not from the top. Starts with //:
		//Example: //header/...
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Clicking the "Practice" button using parent child travers and using relative xpath:
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]")).getText());
		
		//Now, I want to click the button next to practice button, which is the login button:
		
		//Write after the parent child travers - /following-sibling::tagname of the desired button/link
		//Give index if more than one element of same tagname are there:
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		//Now moving from child to parent:
		//Syntax: ../parent::tagname
		
		//Below will go to parent.
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div")).getText());
		
		//To again go one step back, i.e. to parent of this parent(grandparent), add the same thing one more time:
		//Syntax: ../parent::tagname
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header")).getText());
	
	
	}

}
