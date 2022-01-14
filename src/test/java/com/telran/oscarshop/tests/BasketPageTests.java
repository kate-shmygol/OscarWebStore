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

		double priceForFirstItem;

		priceForFirstItem = new BasketPage(driver).getPriceForFirstItem();
		System.out.println(priceForFirstItem);

		new BasketPage(driver).fillQuantityFieldForFirstItem("4");

		double totalPriceForFirstItem;

		totalPriceForFirstItem = new BasketPage(driver).getTotalPriceForFirstItem();
		System.out.println(totalPriceForFirstItem);

		Assert.assertEquals(totalPriceForFirstItem, priceForFirstItem * 4);
		new BasketPage(driver).takeTotalScreenshot();
	}
}
