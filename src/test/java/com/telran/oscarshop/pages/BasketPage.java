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

	public boolean isItBasketPage() {
		return basketTitle.isDisplayed();
	}

	@FindBy(xpath = "//*[@id='basket_formset']/div/div/div[2]/h3/a")
	WebElement productName;

	public String takeNameOfProduct() {
		return productName.getText();
	}

	public int getQuantityOfProductsInBasket() {
		int quantityOfProducts = driver.findElements(By.xpath("//*[@id='basket_formset']/div")).size();
		System.out.println(quantityOfProducts);
		Assert.assertEquals(2, quantityOfProducts);
		return quantityOfProducts;
	}

	@FindBy(xpath = "//*[@id='default']/header/div[1]/div/div[2]/span/a")
	WebElement viewBasketBtn;

	public HomePage clickOnViewBasket() {
		click(viewBasketBtn);
		return new HomePage(driver);
	}

	@FindBy(css = ".basket-items:nth-child(6) :nth-child(4)")
	WebElement priceForOne;

	public double getPriceForFirstItem() {
		double number1 = Double.parseDouble(priceForOne.getText()
				.replace("£", ""));
		return number1;
	}

	@FindBy(id = "id_form-0-quantity")
	WebElement quantityForFirstItem;

	@FindBy(css = ".basket-items:nth-child(6) .btn")
	WebElement updateQuantityForFirstItem;

	public BasketPage fillQuantityFieldForFirstItem(String n) {
		type(quantityForFirstItem, n);
		click(updateQuantityForFirstItem);
		return this;
	}

	@FindBy(css = ".basket-items:nth-child(6) :nth-child(5)")
	WebElement totalPriceForFirstItem;

	public double getTotalPriceForFirstItem() {
		double number2 = Double.parseDouble(totalPriceForFirstItem.getText()
				.replace("£", ""));
		return number2;
	}

	@FindBy(css = ".basket-items:nth-child(7) :nth-child(4)")
	WebElement priceForTwo;

	public double getPriceForSecondItem() {
		double number3 = Double.parseDouble(priceForTwo.getText()
				.replace("£", ""));
		return number3;
	}

	@FindBy(id = "id_form-1-quantity")
	WebElement quantityForSecondItem;

	@FindBy(css = ".basket-items:nth-child(7) .btn")
	WebElement updateQuantityForSecondItem;

	public BasketPage fillQuantityFieldForSecondItem(String n) {
		type(quantityForSecondItem, n);
		click(updateQuantityForSecondItem);
		return this;
	}

	@FindBy(css = ".basket-items:nth-child(7) :nth-child(5)")
	WebElement totalPriceForSecondItem;

	public double getTotalPriceForSecondItem() {
		double number4 = Double.parseDouble(totalPriceForSecondItem.getText()
				.replace("£", ""));
		return number4;
	}

	@FindBy(css = ".total > .price_color")
	WebElement totalPriceForTwoItems;

	public double getTotalPriceForTwoItems() {
		double number5 = Double.parseDouble(totalPriceForTwoItems.getText()
				.replace("£", ""));
		return number5;
	}

}
