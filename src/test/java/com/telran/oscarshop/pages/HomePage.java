package com.telran.oscarshop.pages;

import com.telran.oscarshop.pages.profilePages.ProfilePage;
import com.telran.oscarshop.pages.userPages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".dropdown-submenu")
	WebElement submenuBook;

	@FindBy(id = "login_link")
	WebElement loginRegisterBtn;

	@FindBy(xpath = "//a[contains(text(),'Account')]")
	WebElement accountBtn;

	@FindBy(xpath = "//div[@id='messages']/div/div")
	WebElement homeMessageText;

	@FindBy(id = "id_q")
	WebElement searchField;

	@FindBy(xpath = "//*[@id='default']/header/div[2]/div/div[2]/form/input")
	WebElement searchBtn;

	@FindBy(xpath = "//*[@id='default']/div[2]/div/div/div/div[1]/h1")
	WebElement searchMessageText;

	@FindBy(xpath = "//*[@id='browse']/li/ul/li[1]/a")
	WebElement submenuAllProducts;

	@FindBy(xpath = "//*[@id='promotions']/section[1]/div/h2")
	WebElement homePageTitle;

	@FindBy(xpath = "//*[@id='default']/header/div[1]/div/div[1]/a")
	WebElement mainLink;

	@FindBy(id = "login_form")
	WebElement loginPageTitle;

	@FindBy(xpath = "//*[@id='browse']/li/ul/li[3]/a")
	WebElement submenuClothing;

	@FindBy(xpath = "//*[@id='browse']/li/ul/li[6]/a")
	WebElement submenuOffers;

	public ProductPage selectCategoryBook() {
		click(submenuBook);
		return new ProductPage(driver);
	}

	public LoginPage clickOnLoginRegisterBtn() {
		click(loginRegisterBtn);
		return new LoginPage(driver);
	}

	public ProfilePage clickOnAccountBtn() {
		click(accountBtn);
		return new ProfilePage(driver);
	}

	public String getHomeMessagesText() {
		return homeMessageText.getText();
	}

	public HomePage typeInSearchField(String text) {
		type(searchField, text);
		click(searchBtn);
		return new HomePage(driver);
	}

	public String getSearchMessagesText() {
		return searchMessageText.getText();
	}

	public HomePage selectCategoryAllProducts() {
		click(submenuAllProducts);
		return new HomePage(driver);
	}

	public boolean isItHomePage() {
		return homePageTitle.isDisplayed();
	}

	public HomePage clickOnMainLink() {
		click(mainLink);
		return new HomePage(driver);
	}

	public boolean isItLoginAndRegisterPage() {
		return loginPageTitle.isDisplayed();
	}

	public HomePage selectCategoryClothing() {
		click(submenuClothing);
		return new HomePage(driver);
	}

	public HomePage selectCategoryOffers() {
		click(submenuOffers);
		return new HomePage(driver);
	}

}
