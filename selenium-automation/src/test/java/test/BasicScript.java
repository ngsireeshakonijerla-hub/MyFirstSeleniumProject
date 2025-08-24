package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicScript {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		String title = driver.getTitle();
		
		System.out.println("Title of the page is: " +title);
		
		 WebElement email = driver.findElement(By.id("Email"));
		 email.clear();
	     email.sendKeys("admin@yourstore.com");  
		 
		 WebElement password = driver.findElement(By.className("password"));
		 password.clear();
		 password.sendKeys("admin");
		 
	     WebElement login = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
	     
	     System.out.println("Login test is: " +login.getText());

//		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
//		
//		driver.findElement(By.className("field-validation-valid")).sendKeys("admin");
//		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		
	}

}
