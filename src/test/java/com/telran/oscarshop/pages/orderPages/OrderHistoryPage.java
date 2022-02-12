package com.telran.oscarshop.pages.orderPages;

import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase {

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Order History')]")
	WebElement orderHistoryBtn;

	@FindBy(css = "tr:nth-child(2) > td:nth-child(3)")
	WebElement totalPriceForFirstOrderedItem;

	public OrderHistoryPage clickOnOrderHistoryButton() {
		click(orderHistoryBtn);
		return new OrderHistoryPage(driver);
	}

	public double getTotalPriceForFirstOrderedItem() {
		double number6 = Double.parseDouble(totalPriceForFirstOrderedItem.getText()
				.replace("£", ""));
		return number6;
	}

}
