package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseTest;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		
		for(int i=1; i<rowCount; i++) {
			
			data[i-1][0] = ExcelUtils.getCellData(i, 0);	// Username
			data[i-1][1] = ExcelUtils.getCellData(i, 1);	// Password
		}
		ExcelUtils.closeExcel();
		return data;
	}
	
	@DataProvider(name="LoginData2")
	public Object[][] getData(){
		
		return new Object[][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"user3","pass3"}
		};
	}
	
	//@Test(dataProvider = "LoginData2")
	//@Test
	//@Parameters({"username","password"})
	@Test(dataProvider = "LoginData")
	public void Login(String username, String password) {

		Log.info("Staring login test....");
		test = ExtentReportManager.createTest("Login Test");

		test.info("Naviating to URL");
		LoginPage login = new LoginPage(driver);

		Log.info("Adding credentials....");
		test.info("Adding Credentials...");
		login.username("admin@yourstore.com");
		login.password("admin");
		
//		login.username(username);
//		login.password(password);
		
		test.info("Clicking on Login button...");
		login.login();

		System.out.println("Title of the page is : " + driver.getTitle());
		Log.info("Verifying page title");

		test.info("Verifying page title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		Log.info("Login test completed");
		test.pass("Login Successful");

	}

//	@Test
//	public void LoginwithInvalidCredentials() {
//
//		Log.info("Staring login test....");
//		test = ExtentReportManager.createTest("Login Test with invalid credentials");
//
//		test.info("Naviating to URL");
//		LoginPage login = new LoginPage(driver);
//
//		Log.info("Adding credentials....");
//		test.info("Adding Credentials...");
//		login.username("admin1234@yourstore.com");
//		login.password("admin");
//		test.info("Clicking on Login button...");
//		login.login();
//
//		System.out.println("Title of the page is : " + driver.getTitle());
//		Log.info("Verifying page title");
//
//		test.info("Verifying page title");
//		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration...123");
//		Log.info("Login test completed");
//		test.pass("Login Successful");
//
//	}
}
