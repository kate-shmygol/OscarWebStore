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

	@FindBy(xpath="//a[contains(.,'Change password')]")
	WebElement changePasswordBtn;

	public ProfilePage clickOnChangePasswordBtn() {
		click(changePasswordBtn);
		return new ProfilePage(driver);
	}

	@FindBy(xpath="//div[@id='messages']/div/div")
	WebElement messageText;

	public String getProfileMessagesText() {
		return messageText.getText();
	}

	@FindBy(xpath="//a[contains(.,'Edit profile')]")
	WebElement editProfileBtn;

	public ProfilePage clickOnEditProfileBtn() {
		click(editProfileBtn);
		return new ProfilePage(driver);
	}

	@FindBy(id="delete_profile")
	WebElement deleteProfileBtn;

	public DeleteProfilePage clickOnDeleteProfileBtn() {
		click(deleteProfileBtn);
		return new DeleteProfilePage(driver);
	}
}
