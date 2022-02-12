package com.telran.oscarshop.pages.userPages;

import com.telran.oscarshop.pages.HomePage;
import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "id_registration-email")
	WebElement regEmailField;

	@FindBy(id = "id_registration-password1")
	WebElement regPassword1Field;

	@FindBy(id = "id_registration-password2")
	WebElement regPassword2Field;

	@FindBy(xpath = "//button[@name='registration_submit']")
	WebElement registrationBtn;

	public HomePage registration(String regemail, String regpassword) {
		type(regEmailField, regemail);
		type(regPassword1Field, regpassword);
		type(regPassword2Field, regpassword);
		click(registrationBtn);
		return new HomePage(driver);
	}

}
