package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	private By searchheader=By.cssSelector("div#content h1");
	private By products=By.cssSelector("div.caption a");
	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(driver);
	}
	
	
	public String getResultsHeaderPageValue() {
		if(eleutil.doIsDisplayed(searchheader)) {
		return	eleutil.doElementGetText(searchheader);
		}
		return null;
		
	}
	
	
	public int getProductsearchCount() {
		
			return eleutil.waitForElementsToBeVisible(products, Constants.DEFAULT_TIME_OUT).size();
		
	}
	
	public List<String> getProductResultsList() {
	List<WebElement> prodlist=	eleutil.waitForElementsToBeVisible(products, Constants.DEFAULT_TIME_OUT);
	List<String> prodvallist=new ArrayList<String>();
	for(WebElement e: prodlist) {
		String text=e.getText();
		prodvallist.add(text);
		
	}
	return prodvallist;
	}

}
