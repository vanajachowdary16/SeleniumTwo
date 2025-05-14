package Test.Uitilities;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtilis {
	
	//private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public final static String PROJECT_PATH = System.getProperty("user.dir") + "/" ;
	public final static String webDriverPathChrome = PROJECT_PATH + "/drivers/chromedriver.exe";
	public final static String chrome = "chrome";
	public final static long SynchronizationTime = 45;
	public final static String agrstyle = "arguments[0].style.border='3px solid red'";
	public final static String agrClick ="argument[0].click()";
	public final static String agrsStyleEmpty = "arguments[0].style.broder=''";
	public final static String agrsClick="argument[0].click();";
	
	public static WebDriver driver;
	public static WebDriver getDriver() {
		return driver;
	}
	public static void tearDown() {
		 try {
			if (driver != null) {
			        driver.quit();
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void handleAutosuggestDropDown(String xPath, String searchInput){
		List<WebElement> dropOptions= driver.findElements(By.xpath(xPath));
		try {
		for(WebElement option : dropOptions) {
			if(option.getText().equalsIgnoreCase(searchInput)) {
				//WebUtilis.JsClick(driver, option);				
				option.click();
				System.out.println(option.getAttribute("innerText"));
				break;
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void LaunchDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();;
		
		caps.setBrowserName(chrome);
		System.setProperty("webdriver.chrome.driver", webDriverPathChrome);
		System.out.println(webDriverPathChrome);
		
		try {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(SynchronizationTime, TimeUnit.SECONDS);
			((WebDriver) driver).manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void fluentWait(String locator) {
		FluentWait wait = new FluentWait(driver);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
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
		WebElement element = WebUtilis.findElementByxpath(driver, locator);
		try {
			driver.manage().timeouts().implicitlyWait(SynchronizationTime, TimeUnit.SECONDS);
			Select s = new Select(element);
			s.selectByValue(testData);
			
		}catch(Exception e) {
			System.out.println("error to handle");
	}
	}
		
	public static WebElement findElementByxpath(WebDriver driver, String locator) {
		WebElement element = null;
		try {
			element = driver.findElement(By.xpath(locator));
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			WebUtilis.fluentWait(locator);
			highlight(driver, element);
		}catch(Exception e) {
			System.out.println("error in finding element" +locator);
		}
		return element;
			
		}
	public static void JsScrollToelement(WebDriver driver, WebElement element) {
		
		try {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		
	}catch(Exception e)
		{
		e.printStackTrace();
	}
	}
	
	public static void JsClick(WebDriver driver, WebElement element){
		try {
			((JavascriptExecutor) driver).executeScript(agrsClick, element);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
