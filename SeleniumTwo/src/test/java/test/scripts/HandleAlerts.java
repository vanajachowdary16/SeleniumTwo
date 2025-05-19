package test.scripts;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;
import test.PageObjects.AlertsPageObjects;

public class HandleAlerts extends AlertsPageObjects{
	
	@BeforeClass
	public void SetUp() {
		WebUtilis.LaunchDriver();
		driver.get(alertURL);
	}

	@AfterSuite
	public void afterMethod() {
		WebUtilis.tearDown();
	}
	
	@Test
	public static void testAlerts() {
		
		driver.findElement(By.id("name")).sendKeys("rahulshettyclass");
		WebUtilis.findElementByxpath(driver, alertXpath).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}
	

}
