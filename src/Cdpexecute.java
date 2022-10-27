import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Cdpexecute {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("width",600);
		hashMap.put("height",1000);
		hashMap.put("deviceScaleFactor",50);
		hashMap.put("mobile",true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",hashMap);
		//driver.executeCdpCommand("Emulator.setDeviceMetricsOverride",hP);
		 driver.get("https://rahulshettyacademy.com/angularAppdemo/");
         driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
         Thread.sleep(3000);
         driver.findElement(By.linkText("Library")).click();
        
		

	}

}
