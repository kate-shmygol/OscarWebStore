package com.telran.oscarshop.tests;

import com.telran.oscarshop.fw.DataProviders;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginPage;
import com.telran.oscarshop.pages.ProfilePage;
import com.telran.oscarshop.utils.PropertiesLoader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	public static String email = PropertiesLoader.loadProperty("valid.email");
	public static String password = PropertiesLoader.loadProperty("valid.password");

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).clickOnLoginRegisterBtn();
	}

	@Test
	public void loginPositiveTest() {
		new LoginPage(driver).login(email, password);
		new HomePage(driver).clickOnAccountBtn();
		Assert.assertTrue(new ProfilePage(driver)
				.getEmailText()
				.contains(email));
	}

	@Test(dataProvider = "UserValidFromCSV", dataProviderClass = DataProviders.class)
	public void loginPositiveTestFromCSV(String email, String password) {
		new LoginPage(driver).login(email, password);
		Assert.assertTrue(new ProfilePage(driver)
				.getEmailText()
				.contains(email));
	}

	@Test(dataProvider = "UserInvalidFromCSV", dataProviderClass = DataProviders.class)
	public void loginNegativeTestFromCSV(String email, String password) {
		new LoginPage(driver).login(email, password);

	}
}
