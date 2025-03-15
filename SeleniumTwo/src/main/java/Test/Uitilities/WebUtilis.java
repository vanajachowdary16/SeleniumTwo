package Test.Uitilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class WebUtilis {
	
	//public ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public final static String PROJECT_PATH = System.getProperty("user.dir") + "/" ;
	public final static String webDriverPathChrome = PROJECT_PATH + "/drivers/chromedriver.exe";
	public final static String chrome = "chrome";
	public final static long SynchronizationTime = 45;
	public final static String agrstyle = "arguments[0].style.border='3px solid red'";
	public final static String agrClick ="argument[0].click()";
	public final static String agrsStyleEmpty = "arguments[0].style.broder=''";
	
	 static WebDriver driver = new ChromeDriver();
	public  WebDriver getDriver() {
		return driver;
	}
	public static void tearDown() {
		driver.quit();
	}
	public static void LaunchDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();;
		
		caps.setBrowserName(chrome);
		System.setProperty("webdriver.chrome.driver", webDriverPathChrome);
		System.out.println(webDriverPathChrome);
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("https://en-gb.facebook.com/reg/");
	}
	@SuppressWarnings("deprecation")
	public static void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(SynchronizationTime, TimeUnit.SECONDS);
	}
	
	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		try {
			
			js.executeScript(agrstyle, element);
			Thread.sleep(2000);
		}catch(Exception e){
			js.executeScript(agrstyle, element);
			
		}
		
	}	
	
	@SuppressWarnings("deprecation")
	public static void sendkeysTab(WebDriver driver, String locator, String testData) {
		WebElement element = driver.findElement(By.xpath(locator));
		highlight(driver, element);
		try {
			driver.manage().timeouts().implicitlyWait(SynchronizationTime, TimeUnit.SECONDS);
			element.sendKeys(testData);
			element.sendKeys(Keys.TAB);
		}catch(Exception e) {
			element.sendKeys(testData);
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public static void selectOptions(WebDriver driver, String locator, String testData) {
		WebElement element = driver.findElement(By.xpath(locator));
		highlight(driver, element);
		try {
			driver.manage().timeouts().implicitlyWait(SynchronizationTime, TimeUnit.SECONDS);
			Select s = new Select(element);
			s.selectByValue(testData);
			
		}catch(Exception e) {
			System.out.println("error to ahndle");
	}
	}
		
	public static WebElement findElementByxpath(WebDriver driver, String locator) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(locator));
			highlight(driver, element);
		}catch(Exception e) {
			System.out.println("error in finding element" +locator);
		}
		return element;
			
		}


}
