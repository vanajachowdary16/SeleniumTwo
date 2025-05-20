package test.scripts;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;
import test.PageObjects.ProductsToCartPageObjects;

public class ProductsToCart extends ProductsToCartPageObjects{
	
	@BeforeClass
	public void SetUp() {
		WebUtilis.LaunchDriver();
		driver.get(itemsURL);
	}

	@AfterSuite
	public void afterMethod() {
		WebUtilis.tearDown();
	}
	@Test
	public void testItemsaddToCart() {
		
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		
		addItems(driver, itemsNeeded);
		
	}
		}
