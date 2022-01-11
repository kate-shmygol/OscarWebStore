package com.telran.oscarshop.tests.homePageTests;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.ProductPage;
import com.telran.oscarshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClothingTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).selectCategoryClothing();
	}

	@Test
	public void isItClothingPageTest() {
		Assert.assertTrue(new ProductPage(driver).isItProductPage());
	}
}
