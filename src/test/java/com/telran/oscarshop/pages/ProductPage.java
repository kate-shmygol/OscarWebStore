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

	public boolean isItProductPage() {
		return pageTitle.isDisplayed();
	}

	@FindBy(xpath = "//*[@id='default']/div[2]/div/div/div/section/div/ol/li[1]/article/div[2]/form/button")
	WebElement addToBasket1stBookBtn;

	public ProductPage add1BookToBasket(int number) {
//		click(addToBasket1stBookBtn);
		driver.findElement(By.cssSelector(".col-xs-6:nth-child(" + number + ") .btn")).click();
		return new ProductPage(driver);
	}

	@FindBy(xpath = "//*[@id='default']/div[2]/div/div/div/section/div/ol/li[2]/article/div[2]/form/button")
	WebElement addToBasket2ndBookBtn;

	public ProductPage add2BooksToBasket() {
		click(addToBasket2ndBookBtn);
		return new ProductPage(driver);
	}

}
