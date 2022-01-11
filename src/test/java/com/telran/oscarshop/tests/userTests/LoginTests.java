package com.telran.oscarshop.tests.userTests;

import com.telran.oscarshop.fw.DataProviders;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.userPages.LoginPage;
import com.telran.oscarshop.pages.profilePages.ProfilePage;
import com.telran.oscarshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

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
		new HomePage(driver).clickOnAccountBtn();
		Assert.assertTrue(new ProfilePage(driver)
				.getEmailText()
				.contains(email));
	}

	// Negative Test
//	Oops! We found some errors - please check the error messages below and try again
//	Please enter a correct username and password. Note that both fields may be case-sensitive.
	@Test(dataProvider = "UserInvalidFromCSV", dataProviderClass = DataProviders.class)
	public void loginNegativeTestFromCSV(String email, String password) {
		new LoginPage(driver).login(email, password);
	}

	@Test
	public void isItLoginAndRegisterPageTest() {
		Assert.assertTrue(new HomePage(driver).isItLoginAndRegisterPage());
	}
}
