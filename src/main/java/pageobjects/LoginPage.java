package pageobjects;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import testBase.BaseTestClass;

public class LoginPage extends BaseTestClass {

	
	
	
	public void enterUsername(String username) throws MalformedURLException, URISyntaxException, InterruptedException {

		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		try {
			configureAppium();
			Thread.sleep(5000);
			// WebElement element =
			// webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((AppiumBy.accessibilityId(LoginPageLocators.USER_NAME))));
			WebElement element = driver.findElement(AppiumBy.accessibilityId("test-Username"));
			if (element != null) {
				element.click();
				element.sendKeys("standard_user");
				System.out.println("User Successfully enters the username");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPassword(String password) {
		// password
		try {
			Thread.sleep(2000);
			WebElement passWord = driver.findElement(AppiumBy.accessibilityId("test-Password"));
			if (passWord != null) {
				passWord.click();
				passWord.sendKeys("secret_sauce");
				System.out.println("User successfully entered the password");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnLoginButton() {
		// Login button
		try {
			Thread.sleep(2000);
			WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
			if (loginButton.isDisplayed()) {
				loginButton.click();
				System.out.println("User successfully clicked on the logined button");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void homePage() throws InterruptedException {
		
		    Thread.sleep(8000);
			WebElement homePageValue = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]"));
	        if(homePageValue.isDisplayed()){
	            System.out.println("Text appear on the homepage:"+homePageValue);
	        }
	            else {
	                System.out.println("Text is not appear on the homepage:"+homePageValue);
	        }
	 }
	
	public void menuButton() {
		try {
			Thread.sleep(7000);
			WebElement menuButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]"));
	        
	        if(menuButton.isDisplayed()){
	        	menuButton.click();
	        }
	            
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	  }
	 }
	public void logOut() {
		try {
			Thread.sleep(7000);
			WebElement logOUT = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]"));
	        if(logOUT.isDisplayed()){
	        	logOUT.click();
	        	
	        }
	            
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	  }
	 }
	
	public void enterinvalidUsername(String username) throws InterruptedException {
		Thread.sleep(7000);
		WebElement element = driver.findElement(AppiumBy.accessibilityId("test-Username"));
		if (element != null) {
			element.click();
			element.sendKeys("123test");
			System.out.println("User Successfully enters the username");
		}
	}
 
	public void entervalidPassword(String password) throws InterruptedException {
		Thread.sleep(7000);
		WebElement element = driver.findElement(AppiumBy.accessibilityId("test-Password"));
		if (element != null) {
			element.click();
			element.sendKeys("secret_sauce");
			System.out.println("User Successfully enters the Password");
			clickOnLoginButton();
		}
	}
		
	public void invalidUsernameErrorMessage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]"));
		String expectedError = element.getText();
		System.out.println(expectedError);
		String actualError = "Username and password do not match any user in this service.";
		if(expectedError.equals(actualError));
		{
			System.out.println("For invalid username errorMessage displayes: "+expectedError);
		}}
}