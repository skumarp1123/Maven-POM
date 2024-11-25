package Handlejson;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ReadJson {
	@Test
	public void readjsondata() throws IOException, InterruptedException {
	// Path to JSON file
    String filePath = "./Login.json";

    // Read data from JSON file
    jsondatastructure testData = readjsondata.readJson(filePath);

 // Set up WebDriver
    System.setProperty("webdriver.chromedriver", "C:\\Users\\Administrator\\Desktop\\Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver= new ChromeDriver();
    // Navigate to the URL
    driver.get(testData.url);
   
    // Iterate over user data and perform actions
    for (jsondatastructure.UserData user : testData.data) {
    	Thread.sleep(3000);
    	WebElement login=driver.findElement(By.id("login2"));
    	login.click();
        driver.findElement(By.id("loginusername")).sendKeys(user.username);
        driver.findElement(By.id("loginpassword")).sendKeys(user.password);
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

	    System.out.println(driver.findElement(By.id("nameofuser")).getText());
	    driver.findElement(By.xpath("//a[@id='logout2']")).click();
	    Thread.sleep(3000);
    	}
     driver.quit();
	}
}

