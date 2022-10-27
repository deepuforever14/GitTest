import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.fetch.Fetch;
import org.openqa.selenium.devtools.v106.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v106.network.model.ErrorReason;

public class NetworkRequestFail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		 Optional<List<RequestPattern>> patterns  = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),
				 Optional.empty(),Optional.empty())));
		 devTools.send(Fetch.enable(patterns,Optional.empty()));
		 devTools.addListener(Fetch.requestPaused(),request->
		 {	 
			devTools.send(Fetch.failRequest(request.getRequestId(),ErrorReason.FAILED));	
			System.out.println(ErrorReason.FAILED);
				 
				 
	});
		   driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			driver.manage().window().maximize();
			driver.findElement(By.cssSelector("button[routerlink*='/library']")).click();
	}

}
