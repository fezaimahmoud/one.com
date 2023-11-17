package automationExercise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
	

	WebDriver driver;
	By register =By.xpath("//*[@class=\"text-center\"]//a[@href='/login']");
    By namefield =By.xpath("//*[@data-qa='signup-name']");
    By emailfield =By.xpath("//*[@data-qa='signup-email']");
    By psw =By.id("password");
    By signUpForNewsletter =By.id("newsletter");

    By signup =By.xpath("//*[@data-qa='signup-button']");
    By firstNameField =By.id("first_name");

    By lastNameField =By.id("last_name");
    By addressField =By.id("address1");
    By stateField =By.id("state");
    By cityField =By.id("city");
    By zipCodeField =By.id("zipcode");
    By phoneNumberField =By.id("mobile_number");
    By createAccount =By.xpath("//*[@data-qa='create-account']");
    By continueButton =By.xpath("//*[@data-qa='continue-button']");

    
    
    
    public SignUp(WebDriver driver) {
		this.driver = driver;
	
	}
	 public void register(String name,String email) throws InterruptedException
	    {
	    	driver.findElement(register).click();
	    	driver.findElement(namefield).sendKeys(name);
	    	driver.findElement(emailfield).sendKeys(email);
	    	driver.findElement(signup).click();
	    	Thread.sleep(3000);

	    }
	 public void fillInAccountInformation(String password) throws InterruptedException
	    {
		 HomePage homePage = new HomePage(driver);
	    	driver.findElement(psw).sendKeys(password);
	         homePage.scrolloIntoView(driver.findElement(signUpForNewsletter));

	    	driver.findElement(signUpForNewsletter).click();
	    	Thread.sleep(3000);

	    }
	 public void fillInAddressInformation(String firstName, String lastName,String address, String state ,String city ,String zipCode, String phoneNumber) throws InterruptedException
	    {
	    	HomePage homePage = new HomePage(driver);
            homePage.scrolloIntoView(driver.findElement(firstNameField));
	    	driver.findElement(firstNameField).sendKeys(firstName);
	    	driver.findElement(lastNameField).sendKeys(lastName);
            homePage.scrolloIntoView(driver.findElement(phoneNumberField));
	    	driver.findElement(addressField).sendKeys(address);
	    	driver.findElement(stateField).sendKeys(state);
	    	driver.findElement(cityField).sendKeys(city);
	    	driver.findElement(zipCodeField).sendKeys(zipCode);
	    	driver.findElement(phoneNumberField).sendKeys(phoneNumber);
	    	driver.findElement(createAccount).click();
	    	Thread.sleep(3000);
	    	driver.findElement(continueButton).click();
	    	Thread.sleep(3000);

	    }
	 public String generateEmail()
	 {
		 long timestamp = System.currentTimeMillis();
			String emailAddGen = "automated_test" + timestamp + "@gmail.com";
			return emailAddGen;
	 }
	 public String generateRandomName()
	 {
		 long timestamp = System.currentTimeMillis();
			String name = "automated_test" + timestamp;
			return name;
	 }

}
