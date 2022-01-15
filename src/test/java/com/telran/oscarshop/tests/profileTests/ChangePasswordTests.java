package com.telran.oscarshop.tests.profileTests;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.profilePages.ChangePasswordPage;
import com.telran.oscarshop.pages.profilePages.ProfilePage;
import com.telran.oscarshop.pages.userPages.LoginPage;
import com.telran.oscarshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTests extends TestBase {

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
	public void changePasswordPositiveTest() {
		new ProfilePage(driver).clickOnChangePasswordBtn();
		Assert.assertTrue(new ChangePasswordPage(driver)
						.getChangePasswordPageText()
						.contains("Change Password"));

		new ChangePasswordPage(driver).fillOldAndNewPasswords(password, newPassword);
		Assert.assertTrue(new ProfilePage(driver)
				.getProfileMessagesText()
				.contains("Password updated"));
	}

}
