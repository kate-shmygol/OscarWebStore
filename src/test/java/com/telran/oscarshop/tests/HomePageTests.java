package com.telran.oscarshop.tests;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

	@Test
	public void guestCanSelectProductFromMenuTest() {
		new HomePage(driver).selectCategory();
		Assert.assertTrue(new ProductPage(driver).isItProductPage());

	}

}
