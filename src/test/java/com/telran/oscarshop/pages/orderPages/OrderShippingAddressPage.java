package com.telran.oscarshop.pages.orderPages;

import com.telran.oscarshop.pages.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderShippingAddressPage extends PageBase {

	public OrderShippingAddressPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[contains(.,'Shipping address')]")
	WebElement shippingAddressTitle;

	@FindBy(id = "id_first_name")
	WebElement firstNameField;

	@FindBy(id = "id_last_name")
	WebElement lastNameField;

	@FindBy(id = "id_line1")
	WebElement firstLineOfAddressField;

	@FindBy(id = "id_line4")
	WebElement cityField;

	@FindBy(id = "id_postcode")
	WebElement postcodeField;

	@FindBy(id = "id_country")
	WebElement countryField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement continueBtn;

	public boolean isItShippingAddressPage() {
		return shippingAddressTitle.isDisplayed();
	}

	public OrderShippingAddressPage typeFirstAndLastNames(String firstName, String lastName) {
		type(firstNameField, firstName);
		type(lastNameField, lastName);
		return this;
	}

	public OrderShippingAddressPage typeFirstLineOfAddress(String firstLineOfAddress) {
		type(firstLineOfAddressField, firstLineOfAddress);
		return this;
	}

	public OrderShippingAddressPage typeCity(String city) {
		type(cityField, city);
		return this;
	}

	public OrderShippingAddressPage typePostcode(String postcode) {
		type(postcodeField, postcode);
		return this;
	}

	public OrderShippingAddressPage selectCountry(String country) {
//		Select selectCountry = new Select(countryField);
//		selectCountry.selectByVisibleText(country);
		click(countryField);
		countryField.sendKeys(country);
		countryField.sendKeys(Keys.ENTER);
		return this;
	}

	public OrderShippingAddressPage clickOnContinueButton() {
		click(continueBtn);
		return new OrderShippingAddressPage(driver);
	}

}
