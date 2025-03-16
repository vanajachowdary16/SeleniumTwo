package test.scripts;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;


@Test()
public class GmailRegistrationTest extends WebUtilis {
	
	public static final String GmailUrl ="https://accounts.google.co.in/";
	public static final String createAccount ="//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-dgl2Hf ksBjEc lKxP2d LQeN7 BqKGqe eR0mzb TrZEUc J7pUA']";
	public static final String personalUseOption = "//div[@class='VfPpkd-xl07Ob-XxIAqe VfPpkd-xl07Ob q6oraf P77izf KMdFve VfPpkd-xl07Ob-XxIAqe-OWXEXe-uxVfW-FNFY6c-uFfGwd VfPpkd-xl07Ob-XxIAqe-OWXEXe-FNFY6c']";
	public static final String firstNamexpath ="//input[@name='firstName']";
	public static final String lastNamexpath ="//input[@name='lastName']";
	public static final String nextButtonxpath="//button[@type='button']";
	public static final String BirthdaymonthSelection ="//select[id='month']";
	public static final String Birth_Day="//select[@id='day']";
	public static final String BirthYearSelection="//select[@id='year']";
	public static final String GenderSelection ="//select[@id='gender']";
	public static final String Usernamexpath="//input[@name='Username']";
	public static final String FirstName = "testingSelenium";
	public static final String SurName = "Surname";

	public static final String BirthDay = "10";
	public static final String BirthdayMonth ="2";
	public static final String BirthdayYear = "1999";
	public static final String Gender="Female";
	
	@BeforeClass
	public void SetUp() {
		WebUtilis.LaunchDriver();
		driver.get(GmailUrl);
	}
	
	@AfterSuite
	public void afterMethod() {
		WebUtilis.tearDown();
	}
	
	@Test
	public void TestGmailRegistration() throws InterruptedException {	
		WebUtilis.findElementByxpath(getDriver(), createAccount).click();
		Thread.sleep(2000);
		WebUtilis.findElementByxpath(getDriver(), personalUseOption).click();
		WebUtilis.sendkeysTab(getDriver(), firstNamexpath, FirstName);
		WebUtilis.sendkeysTab(getDriver(), lastNamexpath, SurName);
		WebUtilis.findElementByxpath(getDriver(), nextButtonxpath).click();
		WebUtilis.selectOptions(getDriver(), BirthdaymonthSelection, BirthdayMonth);
		WebUtilis.sendkeysTab(getDriver(), Birth_Day, BirthDay);
		WebUtilis.sendkeysTab(getDriver(), BirthYearSelection, BirthdayYear);
		WebUtilis.selectOptions(getDriver(), GenderSelection, Gender);
		boolean UserNameField =WebUtilis.findElementByxpath(getDriver(), Usernamexpath).isDisplayed();
		
		if(UserNameField) {
			System.out.println("GmailSignup is success");
		}
		
	}
	
}
