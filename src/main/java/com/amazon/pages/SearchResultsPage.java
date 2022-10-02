package com.amazon.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);

	}

	// page elements
	By productNameListElement = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
	By productPriceListElement = By.xpath("//span[@class='a-price']");

	// page action keywords
	public ArrayList<String> getNamesOfProductFromSearchResultList() {

		return getAllTextByElement(productNameListElement);
	}

	public ArrayList<String> getPriceOfProductFromSearchResultList() {

		return getAllTextByElement(productPriceListElement);
	}

}