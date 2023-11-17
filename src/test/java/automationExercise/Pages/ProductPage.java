package automationExercise.Pages;

import java.time.Duration;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

public class ProductPage {
    WebDriver driver;
    By viewProductStylishDress =By.xpath("//*[text()='Stylish Dress']//parent::div//parent::div//following-sibling::div[@class='choose']");
    By quantityloc =By.id("quantity");
    By addToCart =By.xpath("//button[@class=\"btn btn-default cart\"]");
    By continueShoppingButton =By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    By viewCart =By.xpath("//div[@class='modal-body']//*[@href='/view_cart']");

    
    

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAutomationExercise() {
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
    }
    public void goToViewProductStylishDress() throws InterruptedException
    {
   
		driver.findElement(viewProductStylishDress).click();
    	Thread.sleep(5000);

    	     }
    public void selectQuantity(String quantity) throws InterruptedException
    {   

    	driver.findElement(quantityloc).clear();
    	driver.findElement(quantityloc).sendKeys(quantity);
    	Thread.sleep(5000);

    }
    public void addToCart() throws InterruptedException
    {

    	driver.findElement(addToCart).click();
    	Thread.sleep(5000);
    }
    public void continueShopping() throws InterruptedException
    {

    	driver.findElement(continueShoppingButton).click();
    	Thread.sleep(5000);
}
    public void viewCart() throws InterruptedException
    {

    	driver.findElement(viewCart).click();
    	Thread.sleep(5000);
}
}
