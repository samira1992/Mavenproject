package SauceTC.Mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsernameAndPassMissing  {
	
	private WebDriver driver;

	public UsernameAndPassMissing(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="user-name")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	
	
 public void clickOnSignInButton(){
     driver.findElement(By.id("login-button")).click();
 }


	

	public String getErrMsg() {
		
		return driver.findElement(By.cssSelector("[data-test=\"error\"]")).getText();
		}
	}

	

	

	

	



	



	
	
	

