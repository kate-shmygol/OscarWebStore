package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends PageBase {
	public BasketPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".page-header.action")
	WebElement basketTitle;

	public boolean isItBasketPage() {
		return basketTitle.isDisplayed();
	}
}
