package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement userNameTextfield;
	
	@FindBy(name = "password")
	private WebElement passwordTextfield;
	
	@FindBy(name = "submit")
	private WebElement loginButton;
	
	public void login(String[] data) {
		
		
		//Step 1: enter the data in the user name
		String expectedUsername = data[0];
		userNameTextfield.sendKeys(expectedUsername);
		String actualUsername = userNameTextfield.getAttribute("value");
		Assert.assertEquals(actualUsername, expectedUsername,"username");
	}
	
}
