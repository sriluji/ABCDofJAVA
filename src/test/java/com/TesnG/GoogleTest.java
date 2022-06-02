package com.TesnG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	WebDriver driver; //instance
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); //launch url
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		}
	@Test //priorities of the testcases are not defined so it runs randomly. to prioritize them use the word Priority=1---
	public void googleTitleTest() {
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	@Test
	public void googleSearchBoxTest() {
		boolean b=driver.findElement(By.name("q")).isDisplayed();
	}
	@Test
	public void mailLinkTest() {
		boolean b1=driver.findElement(By.linkText("Gmail")).isDisplayed();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
