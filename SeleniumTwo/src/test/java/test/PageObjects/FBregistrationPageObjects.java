package test.PageObjects;

import Test.Uitilities.WebUtilis;

public class FBregistrationPageObjects extends WebUtilis{
	public static final String Firstnamexpath = "//input[@name='firstname']";
	public static final String Surnamexpath = "//input[@name='lastname']";
	public static final String Birthdayxpath = "//select[@name='birthday_day']";
	public static final String BMonthxpath = "//select[@name='birthday_month']";
	public static final String Byearxpath = "//select[@name='birthday_year']";
	public static final String Genderxpath = "//span[@class='_5k_2 _5dba']";
	public static final String EmailIdxpath = "//input[@name='reg_email__']";
	public static final String Passwordxpath = "//input[@id='password_step_input']";
	public static final String Signupxpath = "//button[@type='submit']";

	public static final String FirstName = "testingSelenium";
	public static final String SurName = "Surname";

	public static final String BirthDay = "10";
	public static final String BirthdayMonth = "2";
	public static final String BirthdayYear = "1999";

	public static final String email = "testautomation001@gmail.com";
	public static final String Password = "Password@xpath1234";
	public static final String FBUrl = "https://en-gb.facebook.com/reg/";

}
