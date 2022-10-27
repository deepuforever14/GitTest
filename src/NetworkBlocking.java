import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;

import com.google.common.collect.ImmutableList;

public class NetworkBlocking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
         long startTime = System.currentTimeMillis();
         driver.get("https://www.amazon.in/");
         driver.manage().window().maximize();
         long endTime = System.currentTimeMillis();
          System.out.println(endTime-startTime);  
          //3164
         
         }

}
