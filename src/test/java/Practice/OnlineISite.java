package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OnlineISite {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		String Exp_Title="Swag Labs";
		String Act_Title=title;
		if (Exp_Title.equals(Act_Title)) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		driver.close();
	}
	}


