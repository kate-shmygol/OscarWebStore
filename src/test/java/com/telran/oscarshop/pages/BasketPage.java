package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Collection;

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
		return quantityOfProducts;
	}

}
