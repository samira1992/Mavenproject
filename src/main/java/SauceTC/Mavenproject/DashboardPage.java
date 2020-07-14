package SauceTC.Mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	private WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
	    this.driver = driver;
	}
	
	@FindBy(id="user-name")
	private WebElement UsernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy (id="login-button")
	private WebElement Button;
	
	@FindBy (xpath = "//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")
	private WebElement AddToCart;
	
	@FindBy (xpath ="//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button")
	private WebElement AddCart2;
	
	@FindBy(how = How.TAG_NAME, using ="path")
	private WebElement Basket;
	
	@FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[2]/div[3]/div")
	private WebElement SauceBikePrice;
	
	@FindBy (xpath = "//*[@id=\"inventory_container\"]/div/div[5]/div[3]/div")
	private WebElement SauceOnesiePrice;
	
	@FindBy (xpath ="//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
	private WebElement BikePrice2;
	
	@FindBy (xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")
	private WebElement OnesiePrice2;
	
	@FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
	private WebElement SauceLabsBikeLight;
	
	@FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]")
	private WebElement SauceLabsBikeLightQuantity;
	
	@FindBy (xpath = "//*[@id=\"item_2_title_link\"]/div")
	private WebElement SaucelabsOnesie;
	
	@FindBy(xpath = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[1]")
	private WebElement SaucelabsOnesieQuantity;
	
	public void login(String username, String password) {
		UsernameField.sendKeys(username);
		passwordField.sendKeys(password);
		Button.click();
	}
	
	public void ClickOnAddCart() {
		AddToCart.click();
	}
	
	
	
	public String NumbItem() {
		return driver.findElement(By.xpath("//span[contains(text(),'1')]")).getText();
	}
	
	
	
	public String getUrl() {
		String curUrl = driver.getCurrentUrl();
		System.out.println("Current url is" + " " + curUrl);
		return curUrl;
	}
	
	public WebElement Quantity() {
		 return driver.findElement(By.className("cart_quantity"));
	
	}
	
	public void ClickOnAddCart2() {
		AddCart2.click();
	}
	
	public String NumberOfItem2() {
		return driver.findElement(By.xpath("//span[contains(text(),'2')]")).getText();
	}
	
	public String PriceOfBike() {
		return SauceBikePrice.getText();
	}
	
	public String PriceOfOnesie() {
		return SauceOnesiePrice.getText();
	}
   
	public void  ClickOnBasket() {
	  Basket.click();
}
	
	public String PriceOfBikeOnCart() {
		return BikePrice2.getText();
		}
	
	public String PriceOfOnesieOnCart() {
		return OnesiePrice2.getText();
	}
	
	public String BikeIsDisplayed() {
		return SauceLabsBikeLight.getText();
	}
	
	public String BikeQunatityIsOne() {
		return SauceLabsBikeLightQuantity.getText();
	}
	
	public String OnesieIsDisplayed() {
		return SaucelabsOnesie.getText();
	}
	
	public String OnesieQuantityIsOne() {
		return SaucelabsOnesieQuantity.getText();
	}
}
