package com.telran.oscarshop.tests;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginPage;
import com.telran.oscarshop.utils.PropertiesLoader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

	//	valid.email
	public static String email = PropertiesLoader.loadProperty("valid.email");
	public static String password = PropertiesLoader.loadProperty("valid.password");

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).clickOnLoginRegisterBtn();
	}

	@Test
	public void loginPositiveTest() {
		new LoginPage(driver).login(email, password);
	}
}
