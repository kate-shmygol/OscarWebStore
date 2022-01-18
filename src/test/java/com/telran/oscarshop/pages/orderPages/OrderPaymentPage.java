package com.telran.oscarshop.pages.orderPages;

import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPaymentPage extends PageBase {
	public OrderPaymentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "view_preview")
	WebElement continueOrderPaymentBtn;

	public OrderPreviewPage clickOnContinueButton() {
		click(continueOrderPaymentBtn);
		return new OrderPreviewPage(driver);
	}

}
