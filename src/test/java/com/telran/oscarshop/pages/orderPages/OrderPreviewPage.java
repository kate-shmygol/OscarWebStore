package com.telran.oscarshop.pages.orderPages;

import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPreviewPage extends PageBase {

	public OrderPreviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "place-order")
	WebElement placeOrderBtn;

	public OrderConfirmationPage clickOnPlaceOrderButton() {
		click(placeOrderBtn);
		return new OrderConfirmationPage(driver);
	}

}
