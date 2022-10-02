package com.amazon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver2 = null;

	protected WebDriverWait wait = null;
	protected WebDriverWait shortWait = null;

	public BasePage(WebDriver driver) {
		this.driver2 = driver;
		wait = new WebDriverWait(driver2, 10);
		shortWait = new WebDriverWait(driver2, 1);

	}

	protected final void clickElement(By element) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			driver2.findElement(element).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected final void setText(By element, String value) {
		try {
			shortWait.until(ExpectedConditions.visibilityOfElementLocated((element)));

			driver2.findElement(element).sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected final String getText(By element) {

		return driver2.findElement(element).getText();

	}

	protected final String getCurrentUrl() {

		return driver2.getCurrentUrl();

	}

	protected final void runJavaScript(String scipt) {

		try {
			JavascriptExecutor jsDriver = (JavascriptExecutor) driver2;

			jsDriver.executeScript(scipt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected final void handleAlert(boolean isAccept) {
		try {
			if (isAccept) {
				driver2.switchTo().alert().accept();
			} else {
				driver2.switchTo().alert().dismiss();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected final void openWebPage(String url) {
		try {
			driver2.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected final void switchWindow(int index) {

		try {
			ArrayList<String> windows = new ArrayList<>(driver2.getWindowHandles());

			driver2.switchTo().window(windows.get(index));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected final ArrayList<String> getAllTextByElement(By element) {
		ArrayList<String> results = new ArrayList<>(driver2.getWindowHandles());
		try {
			shortWait.until(ExpectedConditions.visibilityOfElementLocated((element)));

			List<WebElement> webElements = driver2.findElements(element);

			for (WebElement we : webElements) {
				results.add(we.getText());
			}
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return results;
		}
	}

}
