 package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class Accountpage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	private By search=By.name("search");
	private By searchbtn=By.xpath("(//button[@type='button'])[4]");
	private By header=By.cssSelector("div#logo a");
	private By accSeclist=By.cssSelector("div#content h2");
	
	
	public Accountpage(WebDriver driver) {
		this.driver=driver;
	eleutil=new ElementUtil(driver);
		
	}
	
	
	public String accountPageTitle()
	{
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	public  boolean isAccountpageHeaderExists()
	{
		return eleutil.doIsDisplayed(header);
	}
	
	public boolean issearchExists() {
		return eleutil.doIsDisplayed(search);
	}
	
	
	public SearchResultsPage doSearch(String productname) {
		if(issearchExists()) {
		eleutil.doSendKeys(search, productname);
		eleutil.doClick(searchbtn);
		return new SearchResultsPage(driver);}
		
		return null;
	}
	
	public List<String> getaccountpageSectionList()
	{
		List <WebElement>seclist=eleutil.getElements(accSeclist);
		List<String>accsecvalist=new ArrayList<String>();
		for(WebElement e:seclist) {
			String text=e.getText();
			accsecvalist.add(text);
		}
		return accsecvalist;
			
		}
	}
	

