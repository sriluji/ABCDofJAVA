package com.TesnG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TaestNGBasics {
	//@Before =pre-condition, @Test=test cae, @After=postCondition
	@BeforeSuite
	public void setUp() {
		System.out.println("setup system properties");
	}
	@BeforeClass
	public void launcgBrowser() {
		System.out.println("launch Chrome Browser");
	}
	@BeforeTest
	public void enterURL(){
		System.out.println("enter url");
	}
	@BeforeMethod
	public void login() {
		System.out.println("login method");
	}
	@Test
	public void  googleTitleTest() {
	System.out.println("google test title");
	}
	@AfterMethod
	public void logOut() {
		System.out.println("logout from app");
	}
	
	@AfterTest
	public void deleteAllCookies() {
		System.out.println("deleteAllCookies");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("closeBrowser");
	}
	@AfterSuite
	public void generateReports() {
		System.out.println("generate Reports");
	}
	

}
