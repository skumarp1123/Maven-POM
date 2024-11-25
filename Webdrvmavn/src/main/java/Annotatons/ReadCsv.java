package Annotatons;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
//import java.util.logging.Level;
//import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

//import ch.qos.logback.classic.LoggerContext;
//import ch.qos.logback.classic.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadCsv {
	public String baseUrl = "https://demoblaze.com/";
//	String driverPath = "D:\\Softwares\\geckodriver-v0.31.0-win64\\geckodriver.exe";
	String driverPath = "C:\\Users\\Administrator\\Desktop\\Selenium\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
		public WebDriver driver; 
		// TODO Auto-generated method stub
//
//		LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
//		Logger rootLogger = loggerContext.getLogger("io.netty");
//		rootLogger.setLevel(ch.qos.logback.classic.Level.OFF);
//		
//		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		@BeforeTest
		  public void launch() throws InterruptedException 
		{
		
			 System.setProperty("webdriver.chromedriver", driverPath);
			  driver= new ChromeDriver();
			  driver.get(baseUrl);
			  driver.manage().window().maximize();
			  System.out.println("launching application");
			  Thread.sleep(3000);
	  
		}
			  
		@Test (priority = 0)
		public void login() throws IOException, CsvException, InterruptedException
		{
			  CSVReader reader = new CSVReader(new FileReader("./TestResources/login.csv"));
		 
		 // this will load content into list
		  List<String[]> li=reader.readAll();
		  System.out.println("Total rows that we have is "+li.size());
		            
		 // create Iterator reference
		  Iterator<String[]>i1= li.iterator();
		    
		 // Iterate all values 
		 while(i1.hasNext()){
			 String[] str=i1.next();
				
				driver.findElement(By.linkText("Log in")).click();
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
//				   Thread.sleep(3000);
			    driver.findElement(By.id("loginusername")).sendKeys(str[0]);
			    driver.findElement(By.id("loginpassword")).sendKeys(str[1]);
			    driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
			    
			    WebElement username=driver.findElement(By.id("nameofuser"));
			    Thread.sleep(3000);
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
    
			    System.out.println(username.getText());
			    driver.findElement(By.xpath("//a[@id='logout2']")).click();
//			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			    Thread.sleep(3000);
//				
		 }	
		
		 driver.close();
		}
	}

