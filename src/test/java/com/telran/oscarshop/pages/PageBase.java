package com.telran.oscarshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PageBase {
	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
