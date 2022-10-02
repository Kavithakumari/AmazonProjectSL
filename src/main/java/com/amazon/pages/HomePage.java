package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);

	}

	// page elements
	By searchTextbox = By.id("twotabsearchtextbox");
	By searchSubmitIcon = By.id("nav-search-submit-button");

	public void searchProduct(String searchText) {

		setText(searchTextbox, searchText);
		clickElement(searchSubmitIcon);

	}
}