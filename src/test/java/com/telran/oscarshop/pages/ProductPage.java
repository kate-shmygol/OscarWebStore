package com.telran.oscarshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".page-header.action")
	WebElement pageTitle;

	@FindBy(css = ".col-xs-6:nth-child(1) .btn")
	WebElement addToBasket1stBookBtn;

	@FindBy(css = ".col-xs-6:nth-child(2) .btn")
	WebElement addToBasket2ndBookBtn;

	public boolean isItProductPage() {
		return pageTitle.isDisplayed();
	}

	public ProductPage add1BookToBasket(int number) {
//		click(addToBasket1stBookBtn);
		driver.findElement(By.cssSelector(".col-xs-6:nth-child(" + number + ") .btn")).click();
		return new ProductPage(driver);
	}

	public ProductPage add2BooksToBasket() {
		click(addToBasket2ndBookBtn);
		return new ProductPage(driver);
	}

}
