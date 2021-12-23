package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "id_login-username")
	WebElement emailField;

	@FindBy(id = "id_login-password")
	WebElement passwordField;

	@FindBy(xpath = "//button[@name='login_submit']")
	WebElement loginBtn;

	public HomePage login(String email, String password) {
		type(emailField, email);
		type(passwordField, password);
		click(loginBtn);
		return new HomePage(driver);
	}
}
