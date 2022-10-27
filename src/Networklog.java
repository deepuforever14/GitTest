import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.devtools.v106.network.model.Request;
import org.openqa.selenium.devtools.v106.network.model.Response;

public class Networklog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(),request->
		{
			   Request req = request.getRequest();
			   System.out.println(req.getUrl());
		}
				
				);
		devTools.addListener(Network.responseReceived(),response->
		{
		Response res =	response.getResponse();			
		//System.out.println(res.getUrl());
		System.out.println(res.getStatus());
		if(res.getStatus().toString().startsWith("4"))
		{
			System.out.println(res.getUrl()+"is status code starting with Error code"+res.getStatus());
		}
	});
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector("button[routerlink*='/library']")).click();
	

	}

}
