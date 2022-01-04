package com.telran.oscarshop.tests;

import com.telran.oscarshop.fw.DataProviders;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.ProfilePage;
import com.telran.oscarshop.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).clickOnLoginRegisterBtn();
	}

	@Test(dataProvider = "UserValidFromCSV", dataProviderClass = DataProviders.class)
	public void registrationPositiveTest(String regemail, String regpassword) {
		new RegistrationPage(driver).registration(regemail, regpassword);
		new HomePage(driver).clickOnAccountBtn();
		Assert.assertTrue(new ProfilePage(driver)
				.getEmailText()
				.contains(regemail));
	}
}
