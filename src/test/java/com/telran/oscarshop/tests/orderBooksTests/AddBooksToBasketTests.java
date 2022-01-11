package com.telran.oscarshop.tests.orderBooksTests;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.ProductPage;
import com.telran.oscarshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBooksToBasketTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).selectCategoryBook();
	}

	@Test
	public void isItBooksPageTest() {
		Assert.assertTrue(new ProductPage(driver).isItProductPage());
	}
}
