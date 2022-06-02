package com.TesnG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmTest {
	WebDriver driver;
	
	@BeforeTest
	public void SetUp(){
		driver=WebDriverManager.chromedriver().create();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	@Test
	public void validateLoginTest() throws InterruptedException {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(500);
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		
	}
	//@Test
	//public void verifyMarketPlace() throws InterruptedException {
		//Thread.sleep(500);
		//boolean b=driver.findElement(By.id("MP_link")).isDisplayed();
		//if(b) {
			//System.out.println("element is displayed");
			
		//}
		//else {
			//System.out.println("not displayed");
		//
		
	//}
	@Test
	public void verifyDashboard() throws InterruptedException {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(500);
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
	

}
