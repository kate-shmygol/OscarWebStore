package com.telran.oscarshop.tests;

import com.telran.oscarshop.pages.BasketPage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketPageTests extends TestBase {
	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).selectCategoryBook();
	}

	@Test
	public void verifyIfTotalPriceCorrect() {
		new ProductPage(driver).add1BookToBasket(1);
		new BasketPage(driver).clickOnViewBasket();

		double priceForOne;

		priceForOne = new BasketPage(driver).getPriceForOneBook();
		System.out.println(priceForOne);

		new BasketPage(driver).fillQuantityField("4");

		double totalPriceItem;

		totalPriceItem = new BasketPage(driver).getTotalPriceItem();
		System.out.println(totalPriceItem);

		Assert.assertEquals(totalPriceItem, priceForOne*4);
		new BasketPage(driver).takeTotalScreenshot();
	}
}
