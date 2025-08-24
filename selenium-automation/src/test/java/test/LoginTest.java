package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void Login(){
		
		LoginPage login = new LoginPage(driver);
		login.username("admin@yourstore.com");
		login.password("admin");
		login.login();
		
		System.out.println("Title of the page is : " +driver.getTitle());
		
	}
}
