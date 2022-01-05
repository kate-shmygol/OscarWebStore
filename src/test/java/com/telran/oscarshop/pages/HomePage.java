package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".dropdown-submenu")
	WebElement submenuBook;

	public ProductPage selectCategory() {
		click(submenuBook);
		return new ProductPage(driver);
	}

	@FindBy(id = "login_link")
	WebElement loginRegisterBtn;

	public LoginPage clickOnLoginRegisterBtn() {
		click(loginRegisterBtn);
		return new LoginPage(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Account')]")
	WebElement accountBtn;

	public ProfilePage clickOnAccountBtn() {
		click(accountBtn);
		return new ProfilePage(driver);
	}

	@FindBy(xpath="//div[@id='messages']/div/div")
	WebElement homeMessageText;

	public String getHomeMessagesText() {
		return homeMessageText.getText();
	}
}
