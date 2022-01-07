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

	public ProductPage selectCategoryBook() {
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

	@FindBy(id = "id_q")
	WebElement searchField;

	@FindBy(xpath = "//*[@id='default']/header/div[2]/div/div[2]/form/input")
	WebElement searchBtn;

	public HomePage typeInSearchField(String text) {
		type(searchField, text);
		click(searchBtn);
		return new HomePage(driver);
	}

	@FindBy(xpath="//*[@id='default']/div[2]/div/div/div/div[1]/h1")
	WebElement searchMessageText;

	public String getSearchMessagesText() {
		return searchMessageText.getText();
	}

	@FindBy(xpath = "//*[@id='browse']/li/ul/li[1]/a")
	WebElement submenuAllProducts;

	public HomePage selectCategoryAllProducts() {
		click(submenuAllProducts);
		return new HomePage(driver);
	}

	@FindBy(xpath = "//*[@id='promotions']/section[1]/div/h2")
	WebElement homePageTitle;

	public boolean isItHomePage() {
		return homePageTitle.isDisplayed();
	}

	@FindBy(xpath = "//*[@id='default']/header/div[1]/div/div[1]/a")
	WebElement mainLink;

	public HomePage clickOnMainLink() {
		click(mainLink);
		return new HomePage(driver);
	}

	@FindBy(id = "login_form")
	WebElement loginPageTitle;

	public boolean isItLoginAndRegisterPage() {
		return loginPageTitle.isDisplayed();
	}

	@FindBy(xpath = "//*[@id='default']/header/div[1]/div/div[2]/span/a")
	WebElement viewBasketBtn;

	public HomePage clickOnViewBasket() {
		click(viewBasketBtn);
		return new HomePage(driver);
	}

	@FindBy(xpath = "//*[@id='browse']/li/ul/li[3]/a")
	WebElement submenuClothing;

	public HomePage selectCategoryClothing() {
		click(submenuClothing);
		return new HomePage(driver);
	}

	@FindBy(xpath = "//*[@id='browse']/li/ul/li[6]/a")
	WebElement submenuOffers;

	public HomePage selectCategoryOffers() {
		click(submenuOffers);
		return new HomePage(driver);
	}
}
