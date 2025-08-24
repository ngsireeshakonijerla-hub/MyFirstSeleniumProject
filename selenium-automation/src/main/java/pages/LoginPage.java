package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	private By username = By.id("Email");
	private By password = By.id("Password");
	private By login = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void username(String mailid){
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(mailid);
	}
	
	public void password(String pwd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void login() {
		driver.findElement(login).click();
	}
	
}
