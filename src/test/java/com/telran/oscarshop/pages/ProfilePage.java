package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="tr:nth-child(2) > td")
	WebElement emailText;

	public String getEmailText() {
		return emailText.getText();
	}
}
