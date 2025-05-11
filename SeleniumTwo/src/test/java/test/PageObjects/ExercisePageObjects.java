package test.PageObjects;

import Test.Uitilities.WebUtilis;

public class ExercisePageObjects extends WebUtilis{
public static String Url="https://www.automationexercise.com/";
	
	public static String mensProductAddToCart="(//*[@class='btn btn-default add-to-cart'])[3]";
	
	public static String viewCart="(//a[@href='/view_cart'])[2]";
	
	public static String mensShirtText="//*[contains(text(), \"Men > Tshirts\")]";
	

}
