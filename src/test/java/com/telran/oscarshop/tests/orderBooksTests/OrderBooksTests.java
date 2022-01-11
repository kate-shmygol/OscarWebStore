package com.telran.oscarshop.tests.orderBooksTests;

import com.telran.oscarshop.pages.BasketPage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.userPages.LoginPage;
import com.telran.oscarshop.pages.ProductPage;
import com.telran.oscarshop.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderBooksTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions() {
		new HomePage(driver).clickOnLoginRegisterBtn();
		new LoginPage(driver).login(email, password);
		new HomePage(driver).selectCategoryBook();
		Assert.assertTrue(new ProductPage(driver).isItProductPage());
		new ProductPage(driver).add1BookToBasket(1);
		new ProductPage(driver).add2BooksToBasket();
		new BasketPage(driver).clickOnViewBasket();
		Assert.assertTrue(new BasketPage(driver).isItBasketPage());
	}

	@Test
	public void addOneBookToBasketTest() {
		Assert.assertTrue(new BasketPage(driver).takeNameOfProduct()
				.contains(bookName));
	}

	// check that we have 2 items
	// assert that quantity of tags "div" (*[@id='basket_formset']/div) is 2
	@Test
	public void addTwoBooksToBasketTest() {
		new BasketPage(driver).getQuantityOfProductsInBasket();
	}

}
