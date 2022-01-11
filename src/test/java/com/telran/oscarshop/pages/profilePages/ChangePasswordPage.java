package com.telran.oscarshop.pages.profilePages;

import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends PageBase {
	public ChangePasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h1[contains(.,'Change Password')]")
	WebElement changePasswordText;

	public String getChangePasswordPageText() {
		return changePasswordText.getText();
	}

	@FindBy(id = "id_old_password")
	WebElement oldPasswordField;

	@FindBy(id = "id_new_password1")
	WebElement newPassword1Field;

	@FindBy(id = "id_new_password2")
	WebElement newPassword2Field;

	@FindBy(xpath = "//button[contains(.,'Save')]")
	WebElement changePasswordSaveBtn;

	@FindBy(xpath = "//a[contains(.,'cancel')]")
	WebElement changePasswordCancelBtn;

	public ChangePasswordPage fillOldAndNewPasswords(String password, String newPassword) {
		type(oldPasswordField, password);
		type(newPassword1Field, newPassword);
		type(newPassword2Field, newPassword);
		click(changePasswordSaveBtn);
		return new ChangePasswordPage(driver);
	}
}
