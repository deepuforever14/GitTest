import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.emulation.Emulation;


public class Mobileemulator {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		 DevTools devTools = driver.getDevTools();
		 devTools.createSession();
		// devTools.send(Emulation.setDeviceMetricsOverride(600,1000,50,true,Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
		 devTools.send(Emulation.setDeviceMetricsOverride(600,1000,50,true,java.util.Optional.empty(),java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
         driver.get("https://rahulshettyacademy.com/angularAppdemo/");
         driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
         Thread.sleep(3000);
         driver.findElement(By.linkText("Library")).click();
         
         }

}
