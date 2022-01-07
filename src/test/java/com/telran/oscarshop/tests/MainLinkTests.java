package com.telran.oscarshop.tests;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainLinkTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).selectCategoryAllProducts();
		Assert.assertTrue(new ProductPage(driver).isItProductPage());
	}

	@Test
	public void guestCanReturnOnHomePageTest() {
		new HomePage(driver).clickOnMainLink();
		Assert.assertTrue(new HomePage(driver).isItHomePage());
	}
}
