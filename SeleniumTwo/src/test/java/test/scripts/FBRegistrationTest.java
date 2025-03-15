package test.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;

@Test()
public class FBRegistrationTest extends WebUtilis{
		public static final String Firstnamexpath = "//input[@name='firstname']";
		public static final String Surnamexpath = "//input[@name='lastname']";
		public static final String Birthdayxpath = "//select[@name='birthday_day']";
		public static final String BMonthxpath ="//select[@name='birthday_month']";
		public static final String Byearxpath ="//select[@name='birthday_year']";
		public static final String Genderxpath ="//span[@class='_5k_2 _5dba']";
		public static final String EmailIdxpath ="//input[@name='reg_email__']";
		public static final String Passwordxpath ="//input[@id='password_step_input']";
		public static final String Signupxpath ="//button[@type='submit']";


		public static final String FirstName = "testingSelenium";
		public static final String SurName = "Surname";

		public static final String BirthDay = "10";
		public static final String BirthdayMonth ="2";
		public static final String BirthdayYear = "1999";

		public static final String email="testautomation001@gmail.com";
		public static final String Password ="Password@xpath1234";
		
@AfterMethod
public void afterMethod() {
	WebUtilis.tearDown();
}

@Test()
public void TestFBRegistration() {
	WebUtilis.LaunchDriver();
	WebUtilis.sendkeysTab(getDriver(), Firstnamexpath, FirstName);	
	WebUtilis.sendkeysTab(getDriver(), Surnamexpath, SurName);
	WebUtilis.selectOptions(getDriver(), Birthdayxpath, BirthDay);
	WebUtilis.selectOptions(getDriver(), BMonthxpath, BirthdayMonth);
	WebUtilis.selectOptions(getDriver(), Byearxpath, BirthdayYear);
	WebUtilis.findElementByxpath(getDriver(), Genderxpath).click();
	WebUtilis.sendkeysTab(getDriver(), EmailIdxpath, email);
	WebUtilis.sendkeysTab(getDriver(), Passwordxpath, Password);
	boolean signupsuccess =WebUtilis.findElementByxpath(getDriver(), Signupxpath).isDisplayed();
	
	if(signupsuccess) {
		System.out.println("signup is success");
	}
}
}

