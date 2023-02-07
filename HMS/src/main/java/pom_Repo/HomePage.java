package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@href,'user-login')]")
	private WebElement patientClickhere;
	
	@FindBy(xpath = "//a[contains(@href,'doctor')]")
	private WebElement doctorClickhere;
	
	@FindBy(xpath = "//a[contains(@href,'admin')]")
	private WebElement adminClickhere;
	 
}
