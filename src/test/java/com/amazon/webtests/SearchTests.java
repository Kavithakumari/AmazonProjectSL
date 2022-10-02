package com.amazon.webtests;

import java.util.ArrayList;

import org.junit.Test;

import com.amazon.common.Constants;
import com.amazon.common.DBUtils;

public class SearchTests extends BaseWebTest {

	@Test
	public void searchProductAndVerifyResults() {

		try {

			// SEARCHING THE PRODUCT "iphone 13"
			String productName = "iphone 13";
			homePage.searchProduct(productName);

			// RETREIVING THE PRODUCT NAMES FROM THE SEARCH RESULTS
			ArrayList<String> NamesList = searchResultsPage.getNamesOfProductFromSearchResultList();
			ArrayList<String> NamesListForSave = new ArrayList<String>();
			for (int i = 0; i < NamesList.size(); i++) {
				if (i >= Constants.nameStartIndex) {
					NamesListForSave.add(NamesList.get(i).replaceAll(",", " "));
				}
			}
			String ProductResultNames = NamesListForSave.toString();
			System.out.println(ProductResultNames);

			// RETRIEVING THE PRODUCT PRICES FROM THE SEARCH RESULTS
			ArrayList<String> PricesList = searchResultsPage.getPriceOfProductFromSearchResultList();
			ArrayList<String> PricesListForSave = new ArrayList<String>();
			for (int i = 0; i < PricesList.size(); i++) {
				if (i >= Constants.priceStartIndex) {
					PricesListForSave.add(PricesList.get(i).replaceAll("[\t\n\r]", ".").replaceAll(",", ""));
				}
			}
			String ProductResultPrices = PricesListForSave.toString();
			System.out.println(ProductResultPrices);

			// Inserting Data In to DB simplilearn.amazon
			String InsertData = "INSERT INTO simplilearn.amazon(student_name,namelist,pricelist) VALUES "
					+ "('Kavitha Kumari','" + ProductResultNames + "' ,'" + ProductResultPrices + "');";
			DBUtils.createDataInDB(InsertData);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
