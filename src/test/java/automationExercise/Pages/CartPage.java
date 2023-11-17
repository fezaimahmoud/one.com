package automationExercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	 WebDriver driver;
	    By proceedToCheckout =By.xpath("//a[@class='btn btn-default check_out']");
	    By continueOnCart =By.xpath("//button[@class='btn btn-success close-checkout-modal btn-block']");
	    By placeOrder =By.xpath("//a[@href='/payment']");
	    By nameField =By.name("name_on_card");
	    By cardNumberField =By.name("card_number");
	    By cvcField =By.name("cvc");
	    By monthField =By.name("expiry_month");
	    By yearField =By.name("expiry_year");
	    By payButton =By.xpath("//*[@data-qa='pay-button']");
	    By cart =By.xpath("//*[@href='/view_cart']");

	    

	  
	    
	    public CartPage (WebDriver driver)
	    {
	    	this.driver=driver;
	    
	    }
	    public void checkout()
	    {
	    	driver.findElement(proceedToCheckout).click();
	    	driver.findElement(continueOnCart).click();
	    	driver.findElement(proceedToCheckout).click();

	    	
	    }
	    public void paymentOrder(String name,String cardNumber,String cvv, String month ,String year) throws InterruptedException
	    {
	    	driver.findElement(cart).click();
	    	Thread.sleep(3000);
	    	driver.findElement(proceedToCheckout).click();
	    	Thread.sleep(3000);
	    	driver.findElement(placeOrder).click();
	    	Thread.sleep(3000);
	    	driver.findElement(nameField).sendKeys(name);
	    	driver.findElement(cardNumberField).sendKeys(cardNumber);
	    	driver.findElement(cvcField).sendKeys(cvv);
	    	driver.findElement(monthField).sendKeys(month);
	    	driver.findElement(yearField).sendKeys(year);
	    	driver.findElement(payButton).click();
	    	Thread.sleep(3000);



	    	
	    }
	   
}
