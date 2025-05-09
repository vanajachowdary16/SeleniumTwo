package test.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;


@Test()
public class GmailRegistrationTest extends WebUtilis {
	
	public static final String GmailUrl ="https://accounts.google.co.in/";
	public static final String createAccount ="//span[@class='VfPpkd-vQzf8d' and text()='Create account']\r\n";
	public static final String personalUseOption = "(//span[@jsname='K4r5Ff'])[1]";
	public static final String CreateAccountxpath="(//span[@jsname='V67aGc'])[3]";
	public static final String firstNamexpath ="//input[@name='firstName']";
	public static final String lastNamexpath ="//input[@name='lastName']";
	public static final String nextButtonxpath="//button[@type='button']";
	public static final String BirthdaymonthSelection ="//select[@id='month']";
	public static final String Birth_Day="//input[@id='day']";
	public static final String BirthYearSelection="//input[@id='year']";
	public static final String GenderSelection ="//select[@id='gender']";
	public static final String Usernamexpath="//span[normalize-space(text())='Pick a Gmail address or create your own']\r\n";
	public static final String FirstName = "testingSelenium";
	public static final String SurName = "Surname";

	public static final String BirthDay = "10";
	public static final String BirthdayMonth ="2";
	public static final String BirthdayYear = "1999";
	public static final String Gender="2";
	
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
		
		WebElement createAccountelement=WebUtilis.findElementByxpath(getDriver(), createAccount);
		Thread.sleep(2000);
		createAccountelement.click();
		//WebUtilis.JsClick(getDriver(), createAccountelement);	
		WebUtilis.findElementByxpath(getDriver(), personalUseOption).click();
		WebUtilis.sendkeysTab(getDriver(), firstNamexpath, FirstName);
		WebUtilis.sendkeysTab(getDriver(), lastNamexpath, SurName);
		WebUtilis.findElementByxpath(getDriver(), nextButtonxpath).click();
		WebUtilis.selectOptions(getDriver(), BirthdaymonthSelection, BirthdayMonth);
		WebUtilis.sendkeysTab(getDriver(), Birth_Day, BirthDay);
		WebUtilis.sendkeysTab(getDriver(), BirthYearSelection, BirthdayYear);
		WebUtilis.selectOptions(getDriver(), GenderSelection, Gender);
		WebUtilis.findElementByxpath(getDriver(), nextButtonxpath).click();
		boolean UserNameField =WebUtilis.findElementByxpath(getDriver(), Usernamexpath).isDisplayed();
		
		if(UserNameField) {
			System.out.println("GmailSignup is success");
		}
		
	}
	
}
