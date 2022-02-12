package com.telran.oscarshop.pages.profilePages;

import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "tr:nth-child(2) > td")
	WebElement emailText;

	@FindBy(xpath = "//a[contains(.,'Change password')]")
	WebElement changePasswordBtn;

	@FindBy(xpath = "//div[@id='messages']/div/div")
	WebElement messageText;

	@FindBy(xpath = "//a[contains(.,'Edit profile')]")
	WebElement editProfileBtn;

	@FindBy(id = "delete_profile")
	WebElement deleteProfileBtn;

	public String getEmailText() {
		return emailText.getText();
	}

	public ProfilePage clickOnChangePasswordBtn() {
		click(changePasswordBtn);
		return new ProfilePage(driver);
	}

	public String getProfileMessagesText() {
		return messageText.getText();
	}

	public ProfilePage clickOnEditProfileBtn() {
		click(editProfileBtn);
		return new ProfilePage(driver);
	}

	public DeleteProfilePage clickOnDeleteProfileBtn() {
		click(deleteProfileBtn);
		return new DeleteProfilePage(driver);
	}

}
