package com.telran.oscarshop.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShippingAddressPage extends PageBase {
	public ShippingAddressPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[contains(.,'Shipping address')]")
	WebElement shippingAddressTitle;

	public boolean isItShippingAddressPage() {
		return shippingAddressTitle.isDisplayed();
	}

	@FindBy(id = "id_first_name")
	WebElement firstNameField;

	@FindBy(id = "id_last_name")
	WebElement lastNameField;

	public ShippingAddressPage typeFirstAndLastNames(String firstName, String lastName) {
		type(firstNameField, firstName);
		type(lastNameField, lastName);
		return this;
	}

	@FindBy(id = "id_line1")
	WebElement firstLineOfAddressField;

	public ShippingAddressPage typeFirstLineOfAddress(String firstLineOfAddress) {
		type(firstLineOfAddressField, firstLineOfAddress);
		return this;
	}

	@FindBy(id = "id_line4")
	WebElement cityField;

	public ShippingAddressPage typeCity(String city) {
		type(cityField, city);
		return this;
	}

	@FindBy(id = "id_postcode")
	WebElement postcodeField;

	public ShippingAddressPage typePostcode(String postcode) {
		type(postcodeField, postcode);
		return this;
	}

	@FindBy(id = "id_country")
	WebElement countryField;

	public ShippingAddressPage selectCountry(String country) {
//		Select selectCountry = new Select(countryField);
//		selectCountry.selectByVisibleText(country);
		click(countryField);
		countryField.sendKeys(country);
		countryField.sendKeys(Keys.ENTER);
		return this;
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement continueBtn;

	public ShippingAddressPage clickOnContinueButton() {
		click(continueBtn);
		return new ShippingAddressPage(driver);
	}
}
