package com.amazon.webtests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.common.Constants;
import com.amazon.pages.HomePage;
import com.amazon.pages.SearchResultsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseWebTest {
	protected WebDriver driver = null;
	HomePage homePage;
	SearchResultsPage searchResultsPage;

	@Before
	public void setUp() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(Constants.baseUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			intilizePageObjects();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void intilizePageObjects() {
		try {
			homePage = new HomePage(driver);

			searchResultsPage = new SearchResultsPage(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@After
	public void tearDown() {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
