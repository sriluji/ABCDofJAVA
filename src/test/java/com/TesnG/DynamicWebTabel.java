package com.TesnG;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Find a name in the name and click the checkbox
//two methods 1. for loop-lengthy process and a direct method
//in html code tr=row number and td=column number and col number remains same and row no changes for the check box

public class DynamicWebTabel {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver=WebDriverManager.chromedriver().create();
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com/']")).click();
		
		driver.findElement(By.name("email")).sendKeys("jisrilu@gmail.com");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		}
	
	@Test
	public void loginTest() {
		driver.getTitle();
		
	}
	
	@Test()
	public void contactlinkclickTest() {
	driver.findElement(By.xpath("//a[@href='/contacts']")).click();
	
	//Method-1
	
	//all the xpaths for names, only row number changes evrything remains same, so break xapth into before and after
	//*[@id="main-content"]/div/div[2]/div/table/tbody/tr[1]/td[2]/a
	//*[@id="main-content"]/div/div[2]/div/table/tbody/tr[2]/td[2]/a
	//*[@id="main-content"]/div/div[2]/div/table/tbody/tr[3]/td[2]/a
	//*[@id="main-content"]/div/div[2]/div/table/tbody/tr[4]/td[2]/a
	//*[@id="main-content"]/div/div[2]/div/table/tbody/tr[5]/td[2]/a
	//*[@id="main-content"]/div/div[2]/div/table/tbody/tr[4]/td[1]/div/label--xpath for check box
	
//	String before_xpath="//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[";
//	String after_xpath="]/td[2]/a";
//	//for for loop u should know total number of rows from the table to iterate
//	//i want to select and ceckbox for maria garcia-row numer is 4
//	for(int i=1;i<=6;i++) {
//		String name=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
//		System.out.println(name);
//		if (name.contains("Maria Garcia")) {//i=4
//			//enter the checkbox xpath concatinating with i
//			driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr["+i+"]/td[1]/div/label")).click();
//		}
//	}
	//Method 2:
	
	driver.findElement(By.xpath("//a[contains(text(),'Maria Garcia')]/parent::td//preceding-sibling::td"));
	}

	
	@AfterMethod
	public void tearDown() {
		
	}


}
