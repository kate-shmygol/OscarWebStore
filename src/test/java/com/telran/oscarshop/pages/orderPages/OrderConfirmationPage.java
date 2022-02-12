package com.telran.oscarshop.pages.orderPages;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends PageBase {

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Continue shopping')]")
	WebElement continueShoppingBtn;

	public HomePage clickOnContinueShoppingButton() {
		click(continueShoppingBtn);
		return new HomePage(driver);
	}

}
