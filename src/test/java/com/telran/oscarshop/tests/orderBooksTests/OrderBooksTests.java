package com.telran.oscarshop.tests.orderBooksTests;

import com.telran.oscarshop.pages.BasketPage;
import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.ProductPage;
import com.telran.oscarshop.pages.orderPages.*;
import com.telran.oscarshop.pages.userPages.LoginPage;
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
	}

	@Test
	public void addOneBookToBasketTest() {
		new ProductPage(driver).add1BookToBasket(1);
		new BasketPage(driver).clickOnViewBasket();
		Assert.assertTrue(new BasketPage(driver).isItBasketPage());

		Assert.assertTrue(new BasketPage(driver).takeNameOfProduct()
				.contains(bookName));

		double priceForFirstItem;

		priceForFirstItem = new BasketPage(driver).getPriceForFirstItem();
		System.out.println(priceForFirstItem);

		new BasketPage(driver).fillQuantityFieldForFirstItem("1");

		double totalPriceForFirstItem;

		totalPriceForFirstItem = new BasketPage(driver).getTotalPriceForFirstItem();
		System.out.println(totalPriceForFirstItem);

		Assert.assertEquals(totalPriceForFirstItem, priceForFirstItem * 1);
		new BasketPage(driver).takeTotalScreenshot();
	}

	@Test
	public void addTwoBooksToBasketTest() {
		new ProductPage(driver).add1BookToBasket(1);
		new ProductPage(driver).add2BooksToBasket();
		new BasketPage(driver).clickOnViewBasket();
		Assert.assertTrue(new BasketPage(driver).isItBasketPage());

		new BasketPage(driver).getQuantityOfProductsInBasket();

		Assert.assertTrue(new BasketPage(driver).takeNameOfProduct()
				.contains(bookName));

		double priceForFirstItem;

		priceForFirstItem = new BasketPage(driver).getPriceForFirstItem();
		System.out.println(priceForFirstItem);

		new BasketPage(driver).fillQuantityFieldForFirstItem("1");

		double totalPriceForFirstItem;

		totalPriceForFirstItem = new BasketPage(driver).getTotalPriceForFirstItem();
		System.out.println(totalPriceForFirstItem);

		Assert.assertEquals(totalPriceForFirstItem, priceForFirstItem * 1);

		double priceForSecondItem;

		priceForSecondItem = new BasketPage(driver).getPriceForSecondItem();
		System.out.println(priceForSecondItem);

		new BasketPage(driver).fillQuantityFieldForSecondItem("1");

		double totalPriceForSecondItem;

		totalPriceForSecondItem = new BasketPage(driver).getTotalPriceForSecondItem();
		System.out.println(totalPriceForSecondItem);

		Assert.assertEquals(totalPriceForSecondItem, priceForSecondItem);

		double totalPriceForTwoItems;

		totalPriceForTwoItems = new BasketPage(driver).getTotalPriceForTwoItems();
		System.out.println(totalPriceForTwoItems);

		Assert.assertEquals(totalPriceForTwoItems, totalPriceForFirstItem + totalPriceForSecondItem);
		new BasketPage(driver).takeTotalScreenshot();
	}

	@Test
	public void orderOneBookTest() {
		new ProductPage(driver).add1BookToBasket(1);
		new BasketPage(driver).clickOnViewBasket();

		double priceForFirstItem;

		priceForFirstItem = new BasketPage(driver).getPriceForFirstItem();
		System.out.println("Price for first item: " + priceForFirstItem);

		new BasketPage(driver).fillQuantityFieldForFirstItem("1");

		double totalPriceForFirstItem;

		totalPriceForFirstItem = new BasketPage(driver).getTotalPriceForFirstItem();
		System.out.println("Total price for first item: " + totalPriceForFirstItem);

		Assert.assertEquals(totalPriceForFirstItem, priceForFirstItem * 1);

		new BasketPage(driver).clickOnProceedToCheckout();
		Assert.assertTrue(new OrderShippingAddressPage(driver).isItShippingAddressPage());

		new OrderShippingAddressPage(driver)
				.typeFirstAndLastNames(firstName, lastName)
				.typeFirstLineOfAddress(firstLineAddress)
				.typeCity(city)
				.typePostcode(postcode)
				.selectCountry(country1)
				.clickOnContinueButton();

		new OrderPaymentPage(driver).clickOnContinueButton();
		new OrderPreviewPage(driver).clickOnPlaceOrderButton();
		new OrderConfirmationPage(driver).clickOnContinueShoppingButton();

		new HomePage(driver).clickOnAccountBtn();
		new OrderHistoryPage(driver).clickOnOrderHistoryButton();

		double totalPriceForFirstOrderedItem;

		totalPriceForFirstOrderedItem = new OrderHistoryPage(driver).getTotalPriceForFirstOrderedItem();
		System.out.println("Total price for first ordered item: " + totalPriceForFirstOrderedItem);

		Assert.assertEquals(totalPriceForFirstItem, totalPriceForFirstOrderedItem);
	}

}
