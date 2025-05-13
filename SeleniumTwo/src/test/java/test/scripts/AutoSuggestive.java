package test.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;
import test.PageObjects.AutoSuggestivePageObjects;

public class AutoSuggestive extends AutoSuggestivePageObjects{
	
	@BeforeClass
	public void SetUp() {
		WebUtilis.LaunchDriver();
		driver.get(RhUrl);
	}

	@AfterClass
	public void afterMethod() {
		WebUtilis.tearDown();
	}
	
	@Test
	public void autoSuggestiveDropDownTest() throws InterruptedException {
		WebUtilis.findElementByxpath(driver, autoSuggestXpath).sendKeys("Ind");
		Thread.sleep(2000);
		WebUtilis.handleAutosuggestDropDown(dropDownXpath, searchKey);
		
	}
}
