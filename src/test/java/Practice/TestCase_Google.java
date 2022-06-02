package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//create a class
//add code to open google
//enter something and click

public class TestCase_Google {

	public static void main(String[] args) {

googlesearch();


	}
	public static void googlesearch() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");//get url
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");//enter text in search bar
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//driver.findElement(By.name("btnk")).click();//click the search button
		//exception with the search click button: because when automation step by step is typed the text box is also giving other options in drop down
//Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element: 
		//Unable to locate element: {"method":"css selector","selector":"*[name='btnk']"}
		//to deal with it modify the click the search button
		
		driver.close();// close browser
		System.out.println("success");
	}

}
