package automationExerciseTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import javax.enterprise.inject.New;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationExercise.Pages.CartPage;
import automationExercise.Pages.HomePage;
import automationExercise.Pages.Logout;
import automationExercise.Pages.ProductPage;
import automationExercise.Pages.SignUp;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PassingOrder {

    WebDriver driver;
    
    
	@BeforeTest
    @Parameters({ "browser", "os" })
    public void setUp(String browser, String os) {
        System.out.println("Setting up the test for Browser: " + browser + ", OS: " + os);

        if (browser.equalsIgnoreCase("chrome")) {
            // Setup ChromeDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Setup FirefoxDriver
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Additional setup based on the operating system
        if (os.equalsIgnoreCase("mac")) {
            // Additional setup for macOS
            System.out.println("Setting up for macOS");
            // ...
        } else if (os.equalsIgnoreCase("windows")) {
            // Additional setup for Windows
            System.out.println("Setting up for Windows");
            // ...
        } else {
            throw new IllegalArgumentException("Unsupported operating system: " + os);
        }
    }

    
	@AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Parameters({ "browser", "os" })
    @Test
    public void PassOrderTest(String browser, String os) throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage =  new CartPage(driver);
        SignUp signup =  new SignUp(driver); 
        Logout logout = new Logout(driver);
        
        homePage.goToAutomationExercise();
        homePage.goToDress();
        productPage.goToViewProductStylishDress();
        productPage.selectQuantity("2");
        productPage.addToCart();
        productPage.continueShopping();
        homePage.goToBabyHug();
        homePage.addToCartHalfSleevesTopSchiffliDetailingPink();
        productPage.viewCart();
        cartPage.checkout();
        signup.register(signup.generateRandomName(), signup.generateEmail());
        signup.fillInAccountInformation(signup.generateRandomName());
        signup.fillInAddressInformation(signup.generateRandomName(), signup.generateRandomName(), signup.generateRandomName(), signup.generateRandomName(), signup.generateRandomName(), signup.generateRandomName(), signup.generateRandomName());
        cartPage.paymentOrder(signup.generateRandomName(), signup.generateRandomName(), signup.generateRandomName(), signup.generateRandomName(), signup.generateRandomName());
        logout.downloadInvoice();
        logout.logOut();

    }
}
