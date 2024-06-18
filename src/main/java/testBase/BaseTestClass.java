package testBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestClass{

	public static final long WAIT = 10;
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	public static WebDriverWait webDriverWait;
	
	
	@BeforeClass
	public static void configureAppium() throws MalformedURLException, URISyntaxException
	{
		//Appium Code -->>Appium Server -->>Mobile
     	//code to start server
		service = new AppiumServiceBuilder().withAppiumJS(new File("c://Users//sharma_rak//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();  
		service.start();
		 
		UiAutomator2Options options = new UiAutomator2Options();
		
		options.setDeviceName("RakeshPhone");
		options.autoGrantPermissions();
		options.noReset();
		options.setAutomationName("UiAutomator2");
		options.setPlatformVersion("14.0");
		options.setPlatformName("Android");
		options.setApp("E://AppiumTraining//Training//src//test//resources//app//demos.apk");
		options.setAppPackage("com.swaglabsmobileapp");
		options.setAppActivity("com.swaglabsmobileapp.MainActivity");
		options.setAppWaitForLaunch(true);
		options.setAppWaitActivity("*");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(50));
		}
	//@AfterClass
     public  void teardown() {
    	 driver.quit();
 		 service.stop();
    	 
     }
	
     public void clear(WebElement e) {
         waitForVisibility(e);
         e.clear();
     }

     public void click(WebElement e) {
         waitForVisibility(e);
         e.click();
     }

     public void click(WebElement e, String msg) {
         waitForVisibility(e);
         e.click();
     }

     public void click(By e, String msg) {
         waitForVisibility(e);
         driver.findElement(e).click();
     }

     public void sendKeys(WebElement e, String txt) {
         waitForVisibility(e);
         e.sendKeys(txt);
     }

     public void sendKeys(WebElement e, String txt, String msg) {
         waitForVisibility(e);
         e.sendKeys(txt);
     }

     public String getAttribute(WebElement e, String attribute) {
         waitForVisibility(e);
         return e.getAttribute(attribute);
     }

     public String getAttribute(By e, String attribute) {
         waitForVisibility(e);
         return driver.findElement(e).getAttribute(attribute);
     }

     public void waitForVisibility(WebElement e) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(BaseTestClass.WAIT));
         wait.until(ExpectedConditions.visibilityOf(e));
     }
     
     public void waitForVisibility(By e) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(BaseTestClass.WAIT));
         wait.until(ExpectedConditions.visibilityOfElementLocated(e));
     }
     
    
     
}
