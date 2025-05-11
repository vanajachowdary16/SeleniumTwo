package test.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;
import test.PageObjects.ExercisePageObjects;

public class AutomationExercise extends ExercisePageObjects {
			
	@BeforeClass
	public void SetUp() {
		WebUtilis.LaunchDriver();
		driver.get(Url);
	}

	@AfterClass
	public void afterMethod() {
		WebUtilis.tearDown();
	}
	
	@Test
	public static void testAddtoCart() throws InterruptedException {						
		WebElement productId = WebUtilis.findElementByxpath(driver, mensProductAddToCart);
		WebUtilis.JsScrollToelement(driver, productId);
		productId.click();
		WebElement viewCartelement = WebUtilis.findElementByxpath(driver, viewCart);
		viewCartelement.click();
		String productInCart=driver.findElement(By.xpath(mensShirtText)).getText();
			System.out.println(productInCart + " element is visible");
	}

	
}
