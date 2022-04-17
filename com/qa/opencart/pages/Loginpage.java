package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;


public class Loginpage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	private By emailid=By.id("input-email");
	private By password=By.id("input-password");
	private By login=By.xpath("//input[@value='Login']");
	private By forgottenpw= By.xpath("(//a[text()='Forgotten Password'])[1]");
	private By register=By.linkText("Register");
	
	//2.public page constructor
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(driver);
		
	}
	
	//public page actions
	
	public String getpagetitle()
	{
	
		return eleutil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);
		
	}
	public String getpageurl() {
		return eleutil.waitForUrl(Constants.DEFAULT_TIME_OUT,Constants.LOGIN_PAGE_FRACTION_URL);}
	
	public boolean forgottenPwdLinkExists() {
		return eleutil.doIsDisplayed(forgottenpw);
		
	}
	public Accountpage doLogin(String un,String Pw)
	{

eleutil.waitForElementToBeVisible(emailid, Constants.DEFAULT_TIME_OUT).sendKeys(un);
eleutil.waitForElementToBeVisible(password, Constants.DEFAULT_TIME_OUT).sendKeys(Pw);
eleutil.doClick(login);
return new  Accountpage(driver);}

	public boolean isRegistrationlinkLinkExists() {
		return eleutil.waitForElementToBeVisible(register, Constants.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	public RegistrationPage navigateToRegisterPage() {
		if(isRegistrationlinkLinkExists()) {
			eleutil.doClick(register);
			return new RegistrationPage(driver);
		}
		return null;
	}
		
		
		
		
		
		
		
}
