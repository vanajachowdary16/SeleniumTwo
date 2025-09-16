package test.scripts;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;
import test.PageObjects.MyntraHomePageObjects;

public class FindFooterSectionLinsOnMyntraHomePageTest extends MyntraHomePageObjects{
	
	@BeforeClass
	public void SetUp() {
		WebUtilis.LaunchDriver();
		driver.get(myntraHomeURL);
	}

	@AfterSuite
	public void afterMethod() {
		WebUtilis.tearDown();
	}
	
	@Test
	public void findFooterSectionLinks() throws InterruptedException {
		
		WebElement footerLinks =WebUtilis.findElementByxpath(driver, footerXpath);
		Actions action = new Actions(driver);
		action.moveToElement(footerLinks).perform();
		List<WebElement> links = footerLinks.findElements(By.tagName("a"));
		System.out.println("Number of links in footer section: " + links.size());
		 /* for (WebElement link : links) {
		        //String linkText = link.getText().trim();
		        String href = link.getAttribute("href");
		        System.out.println("Link URL: " + href);
		    }*/
		WebElement popularSearchElement = driver.findElement(By.xpath(popularSearch));
		List<WebElement> popularSearchLinks = popularSearchElement.findElements(By.tagName("a"));
		System.out.println("Number of links in popular search section: "+popularSearchLinks.size());
		for(int i=0;i<5;i++) {		
			String href=popularSearchLinks.get(i).getAttribute("href");
			System.out.println(href);
			WebElement link = popularSearchLinks.get(i);			
			//String href = link.getAttribute("href");
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", href);
			
			//action.moveToElement(link).click();
       // String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);		
       // popularSearchElement.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);

		}
			Set<String> windowhandle=driver.getWindowHandles();
			Iterator<String> it =windowhandle.iterator();
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				String title = driver.getTitle();
				System.out.println("window title is \"" + title + "\"");
				Thread.sleep(3000);
			}		
	}
	
	

}
