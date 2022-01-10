package com.telran.oscarshop.tests;

import com.telran.oscarshop.pages.EditProfilePage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.LoginPage;
import com.telran.oscarshop.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProfileTests extends TestBase{

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
