package com.telran.oscarshop.pages.profilePages;

import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProfilePage extends PageBase {
	public DeleteProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h1[contains(.,'Delete profile')]")
	WebElement deleteProfileText;

	public String getDeleteProfilePageText() {
		return deleteProfileText.getText();
	}

	@FindBy(id = "id_password")
	WebElement confirmPasswordField;

	@FindBy(xpath = "//button[contains(.,'Delete')]")
	WebElement deleteBtn;

	public DeleteProfilePage typePasswordForDeletingProfile(String password) {
		type(confirmPasswordField, password);
		click(deleteBtn);
		return new DeleteProfilePage(driver);
	}
}
