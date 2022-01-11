package com.telran.oscarshop.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PageBase {
	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initialize Page and Elements = new in creating Object
	}

	public void click(WebElement element) {
		element.click();
	}

	public void type(WebElement element, String text) {
		if (text != null) {
			element.click();
			element.clear();
			element.sendKeys(text);
		}
	}

	public void clickWithAction(WebElement element) {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		element.click();
	}

	public void typeWithJSExecutor(WebElement element, int x, int y, String text) {
		if (text != null) {
			clickWithAction(element);
			clickWithJSExecutor(element, x, y);
			element.clear();
			element.sendKeys(text);
		}
	}

	public void clickWithJSExecutor(WebElement element, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		element.click();
	}

	public void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String takeScreenshot() {
		File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshot = new File("screenshot/screen-" + System.currentTimeMillis() + ".png");
		try {
			Files.copy(tmp, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshot.getAbsolutePath();
	}

	public void waitUntilElementToBeClickable(WebElement element, int time) {
		try {
			new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitUntilElementVisible(WebElement element, int time) {
		try {
			new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitUntilElementInvisible(WebElement element, int time) {
		try {
			new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitUntilAllElementsVisible(List<WebElement> elements, int time) {
		try {
			new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Screenshot takeTotalScreenshot() {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies
				.viewportPasting(ShootingStrategies.scaling(1.0f), 1000))
				.takeScreenshot(driver);

		try {
			ImageIO.write(screenshot.getImage(), "png",
					new File("screenshot/screen-" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshot;
	}

}
