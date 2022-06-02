package Practice;
import org.openqa.selenium.WebDriver;

//https://goo.gl/kNZ6Sr
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String title=driver.getTitle();
		System.out.println(title);
		String exc_title="Facebook - log in or sign up";
		if (exc_title.equals(title)) {
			System.out.println("true");
			}
		else {
			System.out.println("incorrect title");
		}

	}

}
