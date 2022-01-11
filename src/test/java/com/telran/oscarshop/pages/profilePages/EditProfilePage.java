package com.telran.oscarshop.pages.profilePages;

import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends PageBase {
	public EditProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h1[contains(.,'Edit Profile')]")
	WebElement editProfileText;

	public String getEditProfilePageText() {
		return editProfileText.getText();
	}

	@FindBy(id = "id_first_name")
	WebElement firstNameField;

	@FindBy(id = "id_last_name")
	WebElement lastNameField;

	@FindBy(xpath = "//button[contains(.,'Save')]")
	WebElement editProfileSaveBtn;

	@FindBy(xpath = "//a[contains(.,'cancel')]")
	WebElement editProfileCancelBtn;

	public EditProfilePage typeFirstAndLastNames(String firstName, String lastName) {
		type(firstNameField, firstName);
		type(lastNameField, lastName);
		click(editProfileSaveBtn);
		return new EditProfilePage(driver);
	}
}
