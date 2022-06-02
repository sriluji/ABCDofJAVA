package Practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllKeys {

	public static void main(String[] args) {

WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get ("htttps://www.google.com");
driver.get("http://www.freecrm.com");
System.out.println(driver.getTitle());
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
driver.navigate().to("http://facebook.com");
System.out.println(driver.getTitle());
driver.navigate().back();
driver.navigate().forward();
WebElement email=driver.findElement(By.id("email"));
WebElement passW=driver.findElement(By.id("passContainer"));
if (email.isDisplayed()&& email.isEnabled()) {
	email.sendKeys("sriluji");
}

driver.close();
	}

}
