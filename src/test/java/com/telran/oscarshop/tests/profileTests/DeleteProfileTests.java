package com.telran.oscarshop.tests.profileTests;

import com.telran.oscarshop.fw.DataProviders;
import com.telran.oscarshop.pages.profilePages.DeleteProfilePage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.userPages.LoginPage;
import com.telran.oscarshop.pages.profilePages.ProfilePage;
import com.telran.oscarshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteProfileTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).clickOnLoginRegisterBtn();
	}

	@Test(dataProvider = "UserValidFromCSV", dataProviderClass = DataProviders.class)
	public void deleteProfilePositiveTestFromCSV(String email, String password) {
		new LoginPage(driver).login(email, password);
		new HomePage(driver).clickOnAccountBtn();
		Assert.assertTrue(new ProfilePage(driver)
				.getEmailText()
				.contains(email));

		new ProfilePage(driver).clickOnDeleteProfileBtn();
		Assert.assertTrue(new DeleteProfilePage(driver)
				.getDeleteProfilePageText()
				.contains("Delete profile"));

		// after clicking Delete button message appears:
		// Your profile has now been deleted. Thanks for using the site.
		new DeleteProfilePage(driver).typePasswordForDeletingProfile(password);
		Assert.assertTrue(new HomePage(driver)
				.getHomeMessagesText()
				.contains("Your profile has now been deleted. Thanks for using the site."));
	}

	// Negative Test. Message on Delete profile page:
	// Oops! We found some errors - please check the error messages below and try again
}
