package ExtentReport;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.LongSerializationPolicy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	

	@BeforeTest
	public void setExtent() {

		spark = new ExtentSparkReporter("target/extentreport1.html");
		report = new ExtentReports();
		report.attachReporter(spark);

	}
	
	@AfterTest
	public void after(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL,"test case failed is "+result.getName());
			test.log(Status.FAIL,"test case failed is "+result.getThrowable());
		}
		
		report.flush();
		
	}
	
	@BeforeMethod
	public void setUp() {
		driver=WebDriverManager.chromedriver().create();
		driver.get("https://freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


	}

	@Test
	public void loginTestTitle() {
		ExtentTest test1 = report.createTest("logintestTitle");
		String title=driver.getTitle();
		Assert.assertEquals(title, "ABCD");

	}

	@Test
	public void loginTest() {
		ExtentTest test2 = report.createTest("logintest");
		driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com/']")).click();
		driver.findElement(By.name("email")).sendKeys("jisrilu@gmail.com");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

	}


	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}}


