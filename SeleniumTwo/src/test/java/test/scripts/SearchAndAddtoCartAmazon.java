package test.scripts;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;
import junit.framework.Assert;
import test.PageObjects.SearchAndAddtoCartAmazonPageObjects;

public class SearchAndAddtoCartAmazon extends SearchAndAddtoCartAmazonPageObjects{
	
	@BeforeClass
	public void SetUp() throws InterruptedException {
		WebUtilis.LaunchDriver();
		driver.get(AmzonURL);
		
	}

	@AfterSuite
	public void afterMethod() {
		WebUtilis.tearDown();
	}
	
	@Test
	public void TestAddtoCart() throws InterruptedException {
		Thread.sleep(2000);
		WebUtilis.findElementByxpath(getDriver(), searchBar).sendKeys(mouseSearch);
		WebUtilis.findElementByxpath(getDriver(), searchBarIcon).click();
		WebUtilis.findElementByxpath(getDriver(), productxpath).click();
		System.out.println(WebUtilis.findElementByxpath(getDriver(), productTitleXpath).isDisplayed());
		System.out.println(WebUtilis.findElementByxpath(getDriver(), priceFieldxpath).isDisplayed());
		String priceAmount = WebUtilis.findElementByxpath(getDriver(), priceFieldxpath).getAttribute("innerText");
		String priceInDecimalValue = WebUtilis.findElementByxpath(getDriver(), priceInDecimal).getAttribute("innerText") .replaceAll("\\s+", "");;
		System.out.println(priceInDecimalValue);
		String unitPrice = (priceAmount.trim() + priceInDecimalValue).replaceAll("\\s+", "");
		
		double priceValue = Double.parseDouble(unitPrice);
		System.out.println(priceValue);

		String productTitleInsearch=WebUtilis.findElementByxpath(getDriver(), productTitleXpath).getAttribute("innerText");
		System.out.println(productTitleInsearch);
		WebUtilis.findElementByxpath(getDriver(), addtoCart).click();
		
		System.out.println(WebUtilis.findElementByxpath(getDriver(), producAddedMessage).getAttribute("innerText"));
		WebUtilis.findElementByxpath(getDriver(), incrementIcon).click();
		WebUtilis.findElementByxpath(getDriver(), gotToCart).click();
		
		
		String productInCartTitle=WebUtilis.findElementByxpath(getDriver(), productInCart).getAttribute("innerText");
		System.out.println(productInCartTitle);
		String addedQty = WebUtilis.findElementByxpath(getDriver(), qtyXpath).getAttribute("innerText");
		String subtotalValue=WebUtilis.findElementByxpath(getDriver(), subtotalXpath).getAttribute("innerText");
		System.out.println(subtotalValue);
		//String numericOnly = subtotalValue.replaceAll("[^\\d]", "");
		double subtotalFormatted = Double.parseDouble(subtotalValue.replaceAll("[$,]", "").trim());


		System.out.println(subtotalFormatted);
		
		Assert.assertEquals(productTitleInsearch, productInCartTitle);
		Assert.assertEquals(addedQty, addedTwice);	
		int addedProductsCount = elementCount(productInCart);
		Assert.assertEquals(addedProductsCount, 1);
		
		if(addedProductsCount>1) {
			
			System.out.println("product is duplicated");
			
		}else {
			System.out.println("product is not duplicated");
		}
		
		int totalQty=Integer.parseInt(addedQty);
		
		double subTotal = priceValue*totalQty;
		System.out.println(subTotal);
		
		System.out.println("subtotal is " +subTotal);
		
		Assert.assertEquals(subtotalFormatted, subTotal);
		
	}

}
