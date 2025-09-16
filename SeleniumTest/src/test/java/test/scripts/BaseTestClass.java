package test.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class BaseTestClass {
	
	
	public static void main(String[] args) {
	
	System.setProperty("Webdriver.chrome.driver", "/drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.programiz.com/java-programming/online-compiler/");

}
}
