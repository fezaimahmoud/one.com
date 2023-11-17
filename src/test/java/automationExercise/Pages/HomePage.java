package automationExercise.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    By woman =By.xpath("//a[@href=\"#Women\"]");
    By dress =By.xpath("((//div[@class='panel-body']//ul)[1]/li)[1]");
    By babyHug =By.xpath("//a[@href='/brand_products/Babyhug']");
    By products =By.xpath("//ul[@class='nav navbar-nav']//a[@href='/products']");
    By addtoCartHalfSleevesTopSchiffliDetailingPink =By.xpath("//*[text()='Half Sleeves Top Schiffli Detailing - Pink']//parent::div//a");

        
    
    

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToAutomationExercise() {
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
    }
    public void goToDress() throws InterruptedException
    {

    	driver.findElement(woman).click();
    	Thread.sleep(5000);
    	driver.findElement(dress).click();
    	
    }
    public void visibleWait(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	wait.withMessage(element + " isn't visible.")
	.until(ExpectedConditions.visibilityOf(element));
    }
    public void goToBabyHug() throws InterruptedException
    {
    	
    	driver.findElement(products).click();
    	Thread.sleep(5000);
    	scrolloIntoView(driver.findElement(babyHug));
    	driver.findElement(babyHug).click();
    	Thread.sleep(5000);

    	
    }
    public void addToCartHalfSleevesTopSchiffliDetailingPink() throws InterruptedException
    {
    	scrolloIntoView(driver.findElement(addtoCartHalfSleevesTopSchiffliDetailingPink));
    	driver.findElement(addtoCartHalfSleevesTopSchiffliDetailingPink).click();
    	Thread.sleep(5000);
    	
    	
    }
    public void scrolloIntoView(WebElement element) throws InterruptedException
    {
    	// Use JavascriptExecutor to scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    	
    }
}
