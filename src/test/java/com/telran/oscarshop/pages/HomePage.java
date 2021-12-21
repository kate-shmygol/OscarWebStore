package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".dropdown-submenu")
	WebElement submenuBook;


	public ProductPage selectCategory() {
		click(submenuBook);
		return new ProductPage(driver);
	}
}
