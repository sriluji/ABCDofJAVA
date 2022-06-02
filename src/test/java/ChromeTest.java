import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ChromeTest {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver",
				//"C:\\Users\\hr\\Desktop\\Sreelatha\\chromedriver_win32 (2)\\chromedriver.exe");
		
		// to use WebDriverManager add the dependencies to the pom.xml file as was for selenium
		//for the dependency search for webdrivermanager and click on https://github.com/bonigarcia/webdrivermanager
		//and click of webdrivermanager and under setup copy the dependency and paste in pom.xml under selenium dependency
		 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();//WebDriver is the interface and ChromeDriver is the child class-dynamic polymorphism
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println(title);
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("submit")).click();
		
		String exptitle="Login: Mercury Tours";
		String acttitle=driver.getTitle();
		
		if(exptitle.equals(acttitle)) {
			System.out.println("correct");
			
		}
		else {
			System.out.println("incorrect ttile");
		}
				
}
}
