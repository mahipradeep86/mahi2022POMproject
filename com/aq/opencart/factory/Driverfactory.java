package com.aq.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	
	public WebDriver init_webbrowser(Properties prop) {
		String browsername=prop.getProperty("browser").trim();
		System.out.println("the browser name is" +browsername);
		highlight=prop.getProperty("highlight").trim();
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();}
		else if(browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("please pass right browser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url").trim());
		return driver;
		
	}
	
	public Properties init_prop() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/test/resourses/config/config.properties") ;
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
		
		}
	


