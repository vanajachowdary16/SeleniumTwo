package test.PageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Test.Uitilities.WebUtilis;

public class ProductsToCartPageObjects extends WebUtilis{
	
	public static String itemsURL="https://rahulshettyacademy.com/seleniumPractise/";
	
	public static String addToCartButtonXpath="//div[@class='product-action']/button";
	
	public static String productsLocator="h4.product-name";
	
	
	
	public static  void addItems(WebDriver driver,String[] itemsNeeded)

	{

	int j=0;

	List<WebElement> products=driver.findElements(By.cssSelector(productsLocator));
	/*for (WebElement product : products) {
	    System.out.println(product.getText());
	}*/


	for(int i=0;i<products.size();i++)


	{


	//Brocolli - 1 Kg

	//Brocolli,    1 kg

	String[] name=products.get(i).getText().split("-");

	String formattedName=name[0].trim();
	
	System.out.println(formattedName);
	//format it to get actual vegetable name

	//convert array into array list for easy search

	//  check whether name you extracted is present in arrayList or not-


	List itemsNeededList = Arrays.asList(itemsNeeded);



	if(itemsNeededList.contains(formattedName))

	{


	j++;

	//click on Add to cart

	driver.findElements(By.xpath(addToCartButtonXpath)).get(i).click();
	if(j==itemsNeeded.length)

	{
		System.out.println(j);	
		break;

	}
	}

	}
	}}
