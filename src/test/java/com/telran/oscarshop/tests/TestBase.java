package com.telran.oscarshop.tests;

import com.telran.oscarshop.utils.PropertiesLoader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

	public WebDriver driver;

	public static String baseURL = PropertiesLoader.loadProperty("url");
	public static String email = PropertiesLoader.loadProperty("valid.email");
	public static String password = PropertiesLoader.loadProperty("valid.password");
	public static String newPassword = PropertiesLoader.loadProperty("valid.newPassword");
	public static String firstName = PropertiesLoader.loadProperty("first.name");
	public static String lastName = PropertiesLoader.loadProperty("last.name");
	public static String bookName = PropertiesLoader.loadProperty("book.name");
	public static String firstLineAddress = PropertiesLoader.loadProperty("first.line.address");
	public static String city = PropertiesLoader.loadProperty("city");
	public static String postcode = PropertiesLoader.loadProperty("postcode");
	public static String country1 = PropertiesLoader.loadProperty("country1");

	@BeforeMethod
	public void setUp() {
		// run Headless Chrome browser
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//		options.addArguments("windows-size=1200x800");
//		driver = new ChromeDriver(options);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().window().setSize(new Dimension(1920, 1000));
//		driver.navigate()
//		driver.get("https://selenium1py.pythonanywhere.com");
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@AfterMethod(enabled = false)
	public void tearDown() {
		driver.quit();
	}
}
