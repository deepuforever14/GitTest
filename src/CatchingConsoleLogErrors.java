import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class CatchingConsoleLogErrors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			driver.findElement(By.cssSelector(".btn-lg")).click();
			driver.findElement(By.partialLinkText("Selenium")).click();
			driver.findElement(By.cssSelector(".add-to-cart")).click();
			driver.findElement(By.cssSelector("[routerlink='/cart']")).click();
			driver.findElement(By.cssSelector(".form-control")).clear();
			driver.findElement(By.cssSelector(".form-control")).sendKeys("2");
			LogEntries entry =    driver.manage().logs().get(LogType.BROWSER);
			List<LogEntry> logs = entry.getAll();
			for(LogEntry e:logs)
			{
				System.out.println(e.getMessage());
			}
	}

}
