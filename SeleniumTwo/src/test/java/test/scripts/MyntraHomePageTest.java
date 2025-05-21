package test.scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;
import test.PageObjects.MyntraHomePageObjects;

public class MyntraHomePageTest extends MyntraHomePageObjects{
	
	
	
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
	public void testMyntraHomePageNavigations() {
		
		WebElement menSection = driver.findElement(By.cssSelector(menCssSelector));
		System.out.println(menSection.isDisplayed());		
		Actions action= new Actions(driver);
		 action.moveToElement(menSection).perform();
		WebElement Tshirt= WebUtilis.findElementByxpath(driver, TshirsXpath);
		System.out.println(Tshirt.isDisplayed());	
		 action.moveToElement(Tshirt).click().perform();	
	}

}
