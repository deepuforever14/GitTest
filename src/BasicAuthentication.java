import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Predicate<URI> predicateURI = uri->uri.getHost().contains("httpbin.org");
		((HasAuthentication)driver).register(predicateURI,UsernameAndPassword.of("foo","bar"));
		//((HasAuthentication)driver).register(predicateURI,UserNameAndPassword.of("foo","bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");

	}

}
