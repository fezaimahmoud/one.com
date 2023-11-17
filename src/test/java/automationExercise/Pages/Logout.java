package automationExercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {
	
	
	WebDriver driver;
    By downloadInvoiceButton =By.xpath("//a[contains(@href,'download_invoice')]");
    By logOut =By.xpath("//a[contains(@href,'logout')]");

	
    public Logout(WebDriver driver) {
		this.driver = driver;
	}
	
	  public void downloadInvoice() throws InterruptedException
	    {
	    	driver.findElement(downloadInvoiceButton).click();
	    	Thread.sleep(3000);

	    	
	    }
	  public void logOut() throws InterruptedException
	    {
	    	driver.findElement(logOut).click();
	    	Thread.sleep(3000);

	    	
	    }

}
