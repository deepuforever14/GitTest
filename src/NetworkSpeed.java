import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.devtools.v106.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				DevTools devTools = driver.getDevTools();
				devTools.createSession();
			    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			    devTools.send(Network.emulateNetworkConditions(true, 6000, 20000, 35000, Optional.of(ConnectionType.ETHERNET)));
			    devTools.addListener(Network.loadingFailed(),loadingFailed->
			    {		    
			    System.out.println(loadingFailed.getErrorText());
			    System.out.println(loadingFailed.getTimestamp());
			    		
	});
			    long startTime = System.currentTimeMillis();
		         driver.get("https://www.amazon.in/");
		        // driver.manage().window().maximize();
		         long endTime = System.currentTimeMillis();
		          System.out.println(endTime-startTime);  
		          //91302
		        
	}

}
