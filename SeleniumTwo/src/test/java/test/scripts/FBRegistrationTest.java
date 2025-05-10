package test.scripts;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Test.Uitilities.WebUtilis;
import test.PageObjects.FBregistrationPageObjects;

@Test()
public class FBRegistrationTest extends FBregistrationPageObjects {

	@BeforeClass
	public void SetUp() {
		WebUtilis.LaunchDriver();
		driver.get(FBUrl);
	}

	@AfterSuite
	public void afterMethod() {
		WebUtilis.tearDown();
	}

	//@SuppressWarnings("static-access")
	@Test()
	public void TestFBRegistration() {
		WebUtilis.sendkeysTab(getDriver(), Firstnamexpath, FirstName);
		WebUtilis.sendkeysTab(getDriver(), Surnamexpath, SurName);
		WebUtilis.selectOptions(getDriver(), Birthdayxpath, BirthDay);
		WebUtilis.selectOptions(getDriver(), BMonthxpath, BirthdayMonth);
		WebUtilis.selectOptions(getDriver(), Byearxpath, BirthdayYear);
		WebUtilis.findElementByxpath(getDriver(), Genderxpath).click();
		WebUtilis.sendkeysTab(getDriver(), EmailIdxpath, email);
		WebUtilis.sendkeysTab(getDriver(), Passwordxpath, Password);
		boolean signupsuccess = WebUtilis.findElementByxpath(getDriver(), Signupxpath).isDisplayed();

		if (signupsuccess) {
			System.out.println("signup is success");
		}
	}
}
