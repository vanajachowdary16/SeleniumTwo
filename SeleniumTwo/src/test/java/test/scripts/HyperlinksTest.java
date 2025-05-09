package test.scripts;

import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import Test.Uitilities.WebUtilis;

public class HyperlinksTest extends WebUtilis {
	
	public static final String SiteUrl="https://www.google.com/";
	
	
	@BeforeClass
	public void SetUp() {
		WebUtilis.LaunchDriver();
		driver.get(SiteUrl);
	}

	@AfterSuite
	public void afterMethod() {
		WebUtilis.tearDown();
	}

	@Test
	public static void checkHyperLinksOnAmazon() throws InterruptedException {
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		List<WebElement> links = (List<WebElement>) driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext()) {
			url=it.next().getAttribute("href");
			
			if(url==null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());
				huc.setRequestMethod("GET");				
					huc.connect();				
					respCode=huc.getResponseCode();			
				if(respCode>=400) {
					System.out.println(url + " is a broken link");					
				}
				else {
					System.out.println(url + " is fetched and working url");
				}
			}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}

}
}
