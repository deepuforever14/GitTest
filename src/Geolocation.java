import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Geolocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String,Object> location = new HashMap<String,Object>();
		location.put("latitude",40);
		location.put("longitude",3);
		location.put("accuracy",1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride",location);
         driver.get("http://google.com/");
         driver.findElement(By.name("q")).sendKeys("amazon",Keys.ENTER);
         driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
         String title = driver.findElement(By.cssSelector("")).getText(); 
        //String title = driver.findElement(By.cssSelector(".our-story-card-title")).getText();
        System.out.println(title);
	}

}
