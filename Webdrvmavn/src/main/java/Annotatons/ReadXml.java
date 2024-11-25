package Annotatons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.beust.jcommander.Parameters;

public class ReadXml {
	public String baseUrl = "https://demoblaze.com/";
//	String driverPath = "D:\\Softwares\\geckodriver-v0.31.0-win64\\geckodriver.exe";
	String driverPath = "C:\\Users\\Administrator\\Desktop\\Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
		public WebDriver driver; 
	
	@Test
	@Parameters({"sUsername", "sPassword"})
	public void login(@Optional("happyrockstar")String sUsername,@Optional("R0ckst@r") String sPassword) throws InterruptedException
	{
		
		 System.setProperty("webdriver.chromedriver", driverPath);
		  driver= new ChromeDriver();
		  driver.get(baseUrl);
		  driver.manage().window().maximize();
		//		System.setProperty("webdriver.gecko.driver",driverPath);			
//		driver = new FirefoxDriver();
//		driver.get("https://www.demoblaze.com/");
		driver.findElement(By.linkText("Log in")).click();
		 Thread.sleep(3000);
        driver.findElement(By.id("loginusername")).sendKeys(sUsername);
        driver.findElement(By.id("loginpassword")).sendKeys(sPassword);
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("nameofuser")).getText());
		driver.findElement(By.xpath("//a[@id='logout2']")).click();
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    Thread.sleep(3000);	
		driver.close();
		
	}
}

