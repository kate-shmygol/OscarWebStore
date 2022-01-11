package com.telran.oscarshop.tests.homePageTests;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.userPages.LoginPage;
import com.telran.oscarshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).clickOnLoginRegisterBtn();
		new LoginPage(driver).login(email, password);
	}

	@Test
	public void searchPositiveTest() {
		new HomePage(driver).typeInSearchField("test");
		Assert.assertTrue(new HomePage(driver)
				.getSearchMessagesText()
				.contains("Products matching \"test\""));
	}
}
