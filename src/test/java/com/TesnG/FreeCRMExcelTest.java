package com.TesnG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import javax.rmi.CORBA.Util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeCRMExcelTest {
	WebDriver driver;
	public static Object[][] getTestData() throws IOException {
		FileInputStream file=new FileInputStream("C:\\Users\\hr\\Desktop\\Sreelatha\\Java\\ABCD\\src\\main\\java\\Util\\TestData.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(file);
		XSSFSheet sheet=book.getSheet("ABCDExcelData");
		int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		Object[][ ]data=new Object[rowcount][colcount];
		
		for (int i=0;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				//System.out.println(data[i][j]);
		}
		}
		return data;
	}
	
	
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
	@DataProvider
	public Object[][] getData() throws IOException {
		Object data[][]=getTestData();
		return data;
	}
	@Test(dataProvider="getData")
	public void contactlinkclickTest(String fName, String lName,String DOBday,String DOByear) {
	driver.findElement(By.xpath("//a[@href='/contacts']")).click();
	driver.findElement(By.xpath("//a[@href='/contacts/new']")).click();
	driver.findElement(By.name("first_name")).sendKeys(fName);
	driver.findElement(By.name("last_name")).sendKeys(lName);
	driver.findElement(By.name("day")).sendKeys(DOBday);
	driver.findElement(By.name("year")).sendKeys(DOByear);
		
	}

	
	@AfterMethod
	public void tearDown() {
		
	}

}
