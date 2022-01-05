package com.telran.oscarshop.tests;

import com.telran.oscarshop.pages.*;
import com.telran.oscarshop.utils.PropertiesLoader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProfileTests extends TestBase{

	public static String email = PropertiesLoader.loadProperty("valid.email");
	public static String password = PropertiesLoader.loadProperty("valid.password");
	public static String firstName = PropertiesLoader.loadProperty("first.name");
	public static String lastName = PropertiesLoader.loadProperty("last.name");

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).clickOnLoginRegisterBtn();
		new LoginPage(driver).login(email, password);
		new HomePage(driver).clickOnAccountBtn();
		Assert.assertTrue(new ProfilePage(driver)
				.getEmailText()
				.contains(email));
	}

	@Test
	public void editProfilePositiveTest() {
		new ProfilePage(driver).clickOnEditProfileBtn();
		Assert.assertTrue(new EditProfilePage(driver)
				.getEditProfilePageText()
				.contains("Edit Profile"));

		new EditProfilePage(driver).typeFirstAndLastNames(firstName, lastName);
		Assert.assertTrue(new ProfilePage(driver)
				.getProfileMessagesText()
				.contains("Profile updated"));
	}
}
