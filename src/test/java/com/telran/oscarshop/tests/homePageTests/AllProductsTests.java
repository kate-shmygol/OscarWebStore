package com.telran.oscarshop.tests.homePageTests;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.ProductPage;
import com.telran.oscarshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllProductsTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).selectCategoryAllProducts();
	}

	@Test
	public void isItAllProductsPageTest() {
		Assert.assertTrue(new ProductPage(driver).isItProductPage());
	}
}
