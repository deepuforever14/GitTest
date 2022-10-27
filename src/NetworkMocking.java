import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.fetch.Fetch;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		    System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			DevTools devTools = driver.getDevTools();
			devTools.createSession();
			devTools.send(Fetch.enable(Optional.empty(),Optional.empty()));
			devTools.addListener(Fetch.requestPaused(),request->
			{
				if(request.getRequest().getUrl().contains("shetty"))
				{
					String mockedUrl =	request.getRequest().getUrl().replace("=shetty","=Deepu");
					System.out.println(mockedUrl);
					devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(mockedUrl),Optional.of(request.getRequest().getMethod()),
							Optional.empty(),Optional.empty(), java.util.Optional.empty()));
					if(request.getRequest().getUrl().toString().startsWith("4"))
					{
						System.out.println(request.getRequest().getUrl()+"showing error code");
					}
				}
				else
				{
					devTools.send(Fetch.continueRequest(request.getRequestId(),Optional.of(request.getRequest().getUrl()),Optional.of(request.getRequest().getMethod()),
							Optional.empty(),Optional.empty(), java.util.Optional.empty()));
				}
					
					
	});
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			driver.manage().window().maximize();
			driver.findElement(By.cssSelector("button[routerlink*='/library']")).click();
			Thread.sleep(3000);
		//	System.out.println(driver.findElement(By.cssSelector("p")).getText());
	}

}
