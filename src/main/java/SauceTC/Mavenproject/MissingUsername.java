package SauceTC.Mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MissingUsername {
	private WebDriver driver;
	
	public MissingUsername(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(id="user-name")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	
	public void enterPass(String password) {
		passwordField.sendKeys(password);
	}
	
 
 public void clickOnSignInButton(){
     driver.findElement(By.id("login-button")).click();
 }
 
	public  String errMesg() {
		
		return driver.findElement(By.cssSelector("[data-test=\"error\"]")).getText();
	}
}

	
