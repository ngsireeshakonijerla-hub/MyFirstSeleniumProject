package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement usernameTextbox;
	
	@FindBy(id="Password")
	WebElement pwdTextbox;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginButton;
	
	
//	private By username = By.id("Email");
//	private By password = By.id("Password");
//	private By login = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void username(String mailid){
		
		Log.info("Entering username:");
		
		usernameTextbox.clear();
		usernameTextbox.sendKeys(mailid);
//		driver.findElement(username).clear();
//		driver.findElement(username).sendKeys(mailid);
	}
	
	public void password(String pwd) {
		Log.info("Entering password:");
		
		pwdTextbox.clear();
		pwdTextbox.sendKeys(pwd);
//		driver.findElement(password).clear();
//		driver.findElement(password).sendKeys(pwd);
	}
	
	public void login() {
		
		Log.info("Clicking login button....");
		loginButton.click();
		
//		driver.findElement(login).click();
	}
	
}
