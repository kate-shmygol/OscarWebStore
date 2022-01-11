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

	@FindBy(xpath = "//*[@id='basket_formset']/div")
	WebElement product;

	public int getQuantityOfProductsInBasket() {
		int quantityOfProducts = driver.findElements(By.xpath("//*[@id='basket_formset']/div")).size();
		System.out.println(quantityOfProducts);
		Assert.assertEquals("2", quantityOfProducts);
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

	public double getPriceForOneBook() {
		double number1 = Double.parseDouble(priceForOne.getText()
				.replace("£", ""));
		return number1;
	}

	@FindBy(id = "id_form-0-quantity")
	WebElement quantity;

	@FindBy(css = ".input-group-btn")
	WebElement updateQuantity;


	public BasketPage fillQuantityField(String n) {
		type(quantity, n);
		click(updateQuantity);
		return null;
	}

	@FindBy(css = ".basket-items:nth-child(6) :nth-child(5)")
	WebElement totalPrice;

	public double getTotalPriceItem() {
		double number2 = Double.parseDouble(totalPrice.getText()
				.replace("£", ""));
		return number2;
	}
}
