package SauceTC;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseTest;
import SauceTC.Mavenproject.DashboardPage;
import SauceTC.Mavenproject.MissingPassword;
import SauceTC.Mavenproject.MissingUsername;
import SauceTC.Mavenproject.UsernameAndPassMissing;

public class SaucePageTest extends BaseTest{
	
	private UsernameAndPassMissing Login;
	private MissingUsername login2;
	private MissingPassword login3;
	private DashboardPage page;

	

	@BeforeClass
	public void loginTest() {
	Login = PageFactory.initElements(driver,UsernameAndPassMissing.class);
	login2 = PageFactory.initElements(driver, MissingUsername.class);
	login3 = PageFactory.initElements(driver, MissingPassword.class);
	 page = PageFactory.initElements(driver,DashboardPage.class);
	
	}
	

	
	@Test(priority = 1)
	public void verifyLogin() throws Exception {
		Login.clickOnSignInButton();
		
		String actual_error = Login.getErrMsg();
		String expected_error ="Epic sadface: Username is required";
		Assert.assertEquals(actual_error, expected_error);
		System.out.println(expected_error);
		Thread.sleep(3000);
		driver.navigate().refresh();
		
	}

	
	@Test(priority = 2)
	public void VerifyErrorMessageWhenUserNameIsMisssing() throws Exception {
		login2.enterPass("secret_sauce");
		login2.clickOnSignInButton();
		String actual_error = login2.errMesg();
		String expected_error ="Epic sadface: Username is required";
		Assert.assertEquals(actual_error, expected_error);
		System.out.println(expected_error);
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
	
	
	@Test(priority = 3)
	public void VerifyErrWhenPassMiss() throws Exception {
		login3.emptyUsername();
		login3.enterUser("standard_user");
		login3.clickOnSignInButton();
		String actual_error = login3.getErrMsg();
		String expected_error ="Epic sadface: Password is required";
		Assert.assertEquals(actual_error, expected_error);
		System.out.println(expected_error);
		Thread.sleep(3000);
		driver.navigate().refresh();
	}
		@Test(priority = 4)
		public void VerifyAddedItemIsDisplayed() throws Exception {
			page.login("standard_user","secret_sauce");
			String url = page.getUrl();
			Assert.assertEquals(url,"https://www.saucedemo.com/inventory.html","Dashboard page url is incorrect");
			page.ClickOnAddCart();
			Thread.sleep(3000);
			
		    String actual = page.NumbItem();
		    String expected = "1";
		    Assert.assertEquals(actual, expected);
		    Thread.sleep(3000);
		    System.out.println(actual);
		    Thread.sleep(3000);
		     page.ClickOnAddCart2();
		     
		    String expectedNum = "2";
		    String actualNum = page.NumberOfItem2();
		    Assert.assertEquals(actualNum, expectedNum);
		    System.out.println(actualNum);
		    Thread.sleep(3000);
		    
		    String expectedPriceOfBike= "$9.99";
		    String actualPriceOfBike = page.PriceOfBike();
		    Assert.assertEquals(actualPriceOfBike, expectedPriceOfBike);
		    System.out.println(actualPriceOfBike);
		    Thread.sleep(3000);
		    
		    String expectedPriceOfOnesie= "$7.99";
		    String actualPriceOfOnesie = page.PriceOfOnesie();
		    Assert.assertEquals(actualPriceOfOnesie,expectedPriceOfOnesie);
		    System.out.println(actualPriceOfOnesie);
		    Thread.sleep(3000);
		    
		    page.ClickOnBasket();
		    Thread.sleep(3000);
		    
		    String expectedPriceOfBikeCart="9.99";
		    String actualPriceOfBikeCart =page.PriceOfBikeOnCart();
		    Assert.assertEquals(actualPriceOfBikeCart,expectedPriceOfBikeCart);
		    System.out.println(actualPriceOfBikeCart);
		    Thread.sleep(3000);
		    
		    
		    String expectedPriceOfOnesieCart="7.99";
		    String actualPriceOfOnesieCart =page.PriceOfOnesieOnCart();
		    Assert.assertEquals(actualPriceOfOnesieCart,expectedPriceOfOnesieCart);
		    System.out.println(actualPriceOfOnesieCart);
		    Thread.sleep(3000);
		    
		    
			
		    boolean Pricebike = "9.99" != null ;
		    if(Pricebike = actualPriceOfBike != null ) {
		    	System.out.println("The price for Bike is the same.");
		    }else {
		    	System.out.println("The price for Bike is not same.");
		    };
			
		    boolean PriceOnesie = "7.99" != null;
			if(PriceOnesie = actualPriceOfOnesieCart != null  ) {
				System.out.println("The price for Onesie is the same.");
			}else {
				System.out.println("The price for Onesie is not the same.");
			}
			
			String BikeIsDisplayedOnYourCart = "Sauce Labs Bike Light";
			String actualDisplay= page.BikeIsDisplayed();
			Assert.assertEquals(actualDisplay,BikeIsDisplayedOnYourCart);
			System.out.println("Item on Your Cart page is:" + actualDisplay);
			
			String OnesieIsDisplayedOnYourCart = "Sauce Labs Onesie";
			String actualOnesieDisplay = page.OnesieIsDisplayed();
			Assert.assertEquals(actualOnesieDisplay, OnesieIsDisplayedOnYourCart);
			System.out.println("The second item on your cart is:" + actualOnesieDisplay);
			
			String QunatityOfBike = "1";
			String actualQunatityOfBike = page.BikeQunatityIsOne();
			Assert.assertEquals(actualQunatityOfBike, QunatityOfBike);
			System.out.println("The quantity of Bike on your cart is:" + actualQunatityOfBike );
			
			String QuantityOfOnesie = "1";
			String actualQuantityOfOnesie = page.OnesieQuantityIsOne();
			Assert.assertEquals(actualQuantityOfOnesie, QuantityOfOnesie);
			System.out.println("The quantity of Onesie on your cart is:" + actualQuantityOfOnesie);
	
	}

}
