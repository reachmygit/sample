import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWord {
	
	public static void main(String a[]){
		
		System.out.println("Hello World");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Rama\\Documents\\Rama\\Java\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		//driver.findElement(By.id("username")).sendKeys("hello");
		//driver.findElement(By.name("pw")).sendKeys("1234");
		//driver.findElement(By.id("Login")).click();

		//driver.findElement(By.cssSelector("input[id='username']")).sendKeys("hello");
		//driver.findElement(By.cssSelector("input[name='pw']")).sendKeys("1234");
		//driver.findElement(By.cssSelector("input[id='Login']")).click();

		//driver.findElement(By.xpath("//div[@class='1st-c']/div/div[2]\div\input"))
	}
 
}
