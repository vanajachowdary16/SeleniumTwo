package test.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	public void findFooterSectionLinks() {
		
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
		
	}
	
	

}
