package com.telran.oscarshop.tests.profileTests;

import com.telran.oscarshop.pages.profilePages.EditProfilePage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.userPages.LoginPage;
import com.telran.oscarshop.pages.profilePages.ProfilePage;
import com.telran.oscarshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProfileTests extends TestBase {

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
