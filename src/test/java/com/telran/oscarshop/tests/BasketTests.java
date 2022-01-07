package com.telran.oscarshop.tests;

import com.telran.oscarshop.pages.BasketPage;
import com.telran.oscarshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).clickOnViewBasket();
	}

	@Test
	public void isItBasketPageTest() {
		Assert.assertTrue(new BasketPage(driver).isItBasketPage());
	}
}
