package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BasketPage extends PageBase {

	public BasketPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".page-header.action")
	WebElement basketTitle;

	@FindBy(xpath = "//*[@id='basket_formset']/div/div/div[2]/h3/a")
	WebElement productName;

	@FindBy(xpath = "//*[@id='default']/header/div[1]/div/div[2]/span/a")
	WebElement viewBasketBtn;

	@FindBy(css = ".basket-items:nth-child(6) :nth-child(4)")
	WebElement priceForOne;

	@FindBy(id = "id_form-0-quantity")
	WebElement quantityForFirstItem;

	@FindBy(css = ".basket-items:nth-child(6) .btn")
	WebElement updateQuantityForFirstItem;

	@FindBy(css = ".basket-items:nth-child(6) :nth-child(5)")
	WebElement totalPriceForFirstItem;

	@FindBy(css = ".basket-items:nth-child(7) :nth-child(4)")
	WebElement priceForTwo;

	@FindBy(id = "id_form-1-quantity")
	WebElement quantityForSecondItem;

	@FindBy(css = ".basket-items:nth-child(7) .btn")
	WebElement updateQuantityForSecondItem;

	@FindBy(css = ".basket-items:nth-child(7) :nth-child(5)")
	WebElement totalPriceForSecondItem;

	@FindBy(css = ".total > .price_color")
	WebElement totalPriceForTwoItems;

	@FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
	WebElement proceedToCheckoutBtn;

	public boolean isItBasketPage() {
		return basketTitle.isDisplayed();
	}

	public String takeNameOfProduct() {
		return productName.getText();
	}

	public int getQuantityOfProductsInBasket() {
		int quantityOfProducts = driver.findElements(By.xpath("//*[@id='basket_formset']/div")).size();
		System.out.println(quantityOfProducts);
		Assert.assertEquals(2, quantityOfProducts);
		return quantityOfProducts;
	}

	public HomePage clickOnViewBasket() {
		click(viewBasketBtn);
		return new HomePage(driver);
	}

	public double getPriceForFirstItem() {
		double number1 = Double.parseDouble(priceForOne.getText()
				.replace("£", ""));
		return number1;
	}

	public BasketPage fillQuantityFieldForFirstItem(String n) {
		type(quantityForFirstItem, n);
		click(updateQuantityForFirstItem);
		return this;
	}

	public double getTotalPriceForFirstItem() {
		double number2 = Double.parseDouble(totalPriceForFirstItem.getText()
				.replace("£", ""));
		return number2;
	}

	public double getPriceForSecondItem() {
		double number3 = Double.parseDouble(priceForTwo.getText()
				.replace("£", ""));
		return number3;
	}

	public BasketPage fillQuantityFieldForSecondItem(String n) {
		type(quantityForSecondItem, n);
		click(updateQuantityForSecondItem);
		return this;
	}

	public double getTotalPriceForSecondItem() {
		double number4 = Double.parseDouble(totalPriceForSecondItem.getText()
				.replace("£", ""));
		return number4;
	}

	public double getTotalPriceForTwoItems() {
		double number5 = Double.parseDouble(totalPriceForTwoItems.getText()
				.replace("£", ""));
		return number5;
	}

	public BasketPage clickOnProceedToCheckout() {
		click(proceedToCheckoutBtn);
		return new BasketPage(driver);
	}

}
