package stepDefinitions;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import io.cucumber.java.en.Given;
import pageobjects.LoginPage;

public class LoginSteps {
	
	LoginPage lp = new LoginPage();
	
	@Given("User enters username as {string}")
	public void enterUsername(String username) throws MalformedURLException, URISyntaxException, InterruptedException {
		lp.enterUsername(username);
	}
	
	@Given("User enters password as {string}")
	public void enterPassword(String password) {
		lp.enterPassword(password);
	}
	
	@Given("User click on the login button")
	public void clickOnLoginButton() {
		lp.clickOnLoginButton();
	}
	
	@Given("User should be on the homepage")
	public void homePage() throws InterruptedException {
		lp.homePage();
	}
	
	@Given("User clicks on menuButton")
	public void menuButton() {
		lp.menuButton();
	}
	
	@Given("User clicks on logout button")
	public void logOut() {
		lp.logOut();
	}
	
	@Given("I enter username as {string}")
	public void enterinvalidUsername(String username) throws InterruptedException {
		lp.enterinvalidUsername(username);
	}
	
	@Given("I enter password as {string} and click on login button")
	public void entervalidPassword(String password) throws InterruptedException {
		lp.entervalidPassword(password);
	}
	
	@Given("login should fail with an error")
	public void invalidUsernameErrorMessage() throws InterruptedException {
		lp.invalidUsernameErrorMessage();
	}
	
	
}
