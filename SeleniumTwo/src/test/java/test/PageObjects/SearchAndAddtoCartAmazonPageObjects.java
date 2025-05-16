package test.PageObjects;

import org.openqa.selenium.By;

import Test.Uitilities.WebUtilis;

public class SearchAndAddtoCartAmazonPageObjects extends WebUtilis {
	
	public static String AmzonURL ="https://www.amazon.com/";
	public static String searchBar ="//input[@id='twotabsearchtextbox']";
	public static String searchBarIcon="//input[@id='nav-search-submit-button']";
	public static String productxpath="(//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal'])[1]";
	public static String productTitleXpath="//span[@id='productTitle']";
	public static String priceFieldxpath="(//span[@class='a-price-whole'])[1]";
	public static String addtoCart ="//input[@id='add-to-cart-button']";
	public static String producAddedMessage="//h1[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']";
	public static String incrementIcon="//span[@data-a-selector='increment-icon']";
	public static String gotToCart="//span[@id='nav-cart-count']";
	public static String qtyXpath="//span[@data-a-selector='value']";
	public static String productInCart="//span[@class='a-truncate-cut']";
	public static String mouseSearch="wireless mouse";
	public static String addedTwice="2";
	public static String subtotalXpath="(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]";
	
	public static String priceInDecimal="(//span[@class='a-price-fraction'])[1]";
	public int elementCount(String locator) {
	    int i = driver.findElements(By.xpath(locator)).size();
	    if (i > 1) {
	        System.out.println("found duplicate elements");
	    } else {
	        System.out.println("Element count is "+i);
	    }
	    return i;
	}
	
	
}
